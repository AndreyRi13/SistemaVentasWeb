/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.Calzado;
import DTO.DetalleCompras;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Andrey
 */
public class DetalleComprasJpaController implements Serializable {

    public DetalleComprasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleCompras detalleCompras) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calzado idCalzado = detalleCompras.getIdCalzado();
            if (idCalzado != null) {
                idCalzado = em.getReference(idCalzado.getClass(), idCalzado.getIdCalzado());
                detalleCompras.setIdCalzado(idCalzado);
            }
            em.persist(detalleCompras);
            if (idCalzado != null) {
                idCalzado.getDetalleComprasCollection().add(detalleCompras);
                idCalzado = em.merge(idCalzado);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleCompras detalleCompras) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleCompras persistentDetalleCompras = em.find(DetalleCompras.class, detalleCompras.getIdDetalle());
            Calzado idCalzadoOld = persistentDetalleCompras.getIdCalzado();
            Calzado idCalzadoNew = detalleCompras.getIdCalzado();
            if (idCalzadoNew != null) {
                idCalzadoNew = em.getReference(idCalzadoNew.getClass(), idCalzadoNew.getIdCalzado());
                detalleCompras.setIdCalzado(idCalzadoNew);
            }
            detalleCompras = em.merge(detalleCompras);
            if (idCalzadoOld != null && !idCalzadoOld.equals(idCalzadoNew)) {
                idCalzadoOld.getDetalleComprasCollection().remove(detalleCompras);
                idCalzadoOld = em.merge(idCalzadoOld);
            }
            if (idCalzadoNew != null && !idCalzadoNew.equals(idCalzadoOld)) {
                idCalzadoNew.getDetalleComprasCollection().add(detalleCompras);
                idCalzadoNew = em.merge(idCalzadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detalleCompras.getIdDetalle();
                if (findDetalleCompras(id) == null) {
                    throw new NonexistentEntityException("The detalleCompras with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleCompras detalleCompras;
            try {
                detalleCompras = em.getReference(DetalleCompras.class, id);
                detalleCompras.getIdDetalle();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleCompras with id " + id + " no longer exists.", enfe);
            }
            Calzado idCalzado = detalleCompras.getIdCalzado();
            if (idCalzado != null) {
                idCalzado.getDetalleComprasCollection().remove(detalleCompras);
                idCalzado = em.merge(idCalzado);
            }
            em.remove(detalleCompras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleCompras> findDetalleComprasEntities() {
        return findDetalleComprasEntities(true, -1, -1);
    }

    public List<DetalleCompras> findDetalleComprasEntities(int maxResults, int firstResult) {
        return findDetalleComprasEntities(false, maxResults, firstResult);
    }

    private List<DetalleCompras> findDetalleComprasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleCompras.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public DetalleCompras findDetalleCompras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleCompras.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleComprasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleCompras> rt = cq.from(DetalleCompras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
