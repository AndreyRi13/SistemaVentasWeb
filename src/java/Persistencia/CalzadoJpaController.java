/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTO.Calzado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.DetalleCompra;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Andrey
 */
public class CalzadoJpaController implements Serializable {

    public CalzadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calzado calzado) {
        if (calzado.getDetalleCompraCollection() == null) {
            calzado.setDetalleCompraCollection(new ArrayList<DetalleCompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<DetalleCompra> attachedDetalleCompraCollection = new ArrayList<DetalleCompra>();
            for (DetalleCompra detalleCompraCollectionDetalleCompraToAttach : calzado.getDetalleCompraCollection()) {
                detalleCompraCollectionDetalleCompraToAttach = em.getReference(detalleCompraCollectionDetalleCompraToAttach.getClass(), detalleCompraCollectionDetalleCompraToAttach.getIdDetalle());
                attachedDetalleCompraCollection.add(detalleCompraCollectionDetalleCompraToAttach);
            }
            calzado.setDetalleCompraCollection(attachedDetalleCompraCollection);
            em.persist(calzado);
            for (DetalleCompra detalleCompraCollectionDetalleCompra : calzado.getDetalleCompraCollection()) {
                Calzado oldIdCalzadoOfDetalleCompraCollectionDetalleCompra = detalleCompraCollectionDetalleCompra.getIdCalzado();
                detalleCompraCollectionDetalleCompra.setIdCalzado(calzado);
                detalleCompraCollectionDetalleCompra = em.merge(detalleCompraCollectionDetalleCompra);
                if (oldIdCalzadoOfDetalleCompraCollectionDetalleCompra != null) {
                    oldIdCalzadoOfDetalleCompraCollectionDetalleCompra.getDetalleCompraCollection().remove(detalleCompraCollectionDetalleCompra);
                    oldIdCalzadoOfDetalleCompraCollectionDetalleCompra = em.merge(oldIdCalzadoOfDetalleCompraCollectionDetalleCompra);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Calzado calzado) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calzado persistentCalzado = em.find(Calzado.class, calzado.getIdCalzado());
            Collection<DetalleCompra> detalleCompraCollectionOld = persistentCalzado.getDetalleCompraCollection();
            Collection<DetalleCompra> detalleCompraCollectionNew = calzado.getDetalleCompraCollection();
            List<String> illegalOrphanMessages = null;
            for (DetalleCompra detalleCompraCollectionOldDetalleCompra : detalleCompraCollectionOld) {
                if (!detalleCompraCollectionNew.contains(detalleCompraCollectionOldDetalleCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleCompra " + detalleCompraCollectionOldDetalleCompra + " since its idCalzado field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<DetalleCompra> attachedDetalleCompraCollectionNew = new ArrayList<DetalleCompra>();
            for (DetalleCompra detalleCompraCollectionNewDetalleCompraToAttach : detalleCompraCollectionNew) {
                detalleCompraCollectionNewDetalleCompraToAttach = em.getReference(detalleCompraCollectionNewDetalleCompraToAttach.getClass(), detalleCompraCollectionNewDetalleCompraToAttach.getIdDetalle());
                attachedDetalleCompraCollectionNew.add(detalleCompraCollectionNewDetalleCompraToAttach);
            }
            detalleCompraCollectionNew = attachedDetalleCompraCollectionNew;
            calzado.setDetalleCompraCollection(detalleCompraCollectionNew);
            calzado = em.merge(calzado);
            for (DetalleCompra detalleCompraCollectionNewDetalleCompra : detalleCompraCollectionNew) {
                if (!detalleCompraCollectionOld.contains(detalleCompraCollectionNewDetalleCompra)) {
                    Calzado oldIdCalzadoOfDetalleCompraCollectionNewDetalleCompra = detalleCompraCollectionNewDetalleCompra.getIdCalzado();
                    detalleCompraCollectionNewDetalleCompra.setIdCalzado(calzado);
                    detalleCompraCollectionNewDetalleCompra = em.merge(detalleCompraCollectionNewDetalleCompra);
                    if (oldIdCalzadoOfDetalleCompraCollectionNewDetalleCompra != null && !oldIdCalzadoOfDetalleCompraCollectionNewDetalleCompra.equals(calzado)) {
                        oldIdCalzadoOfDetalleCompraCollectionNewDetalleCompra.getDetalleCompraCollection().remove(detalleCompraCollectionNewDetalleCompra);
                        oldIdCalzadoOfDetalleCompraCollectionNewDetalleCompra = em.merge(oldIdCalzadoOfDetalleCompraCollectionNewDetalleCompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = calzado.getIdCalzado();
                if (findCalzado(id) == null) {
                    throw new NonexistentEntityException("The calzado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calzado calzado;
            try {
                calzado = em.getReference(Calzado.class, id);
                calzado.getIdCalzado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calzado with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DetalleCompra> detalleCompraCollectionOrphanCheck = calzado.getDetalleCompraCollection();
            for (DetalleCompra detalleCompraCollectionOrphanCheckDetalleCompra : detalleCompraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Calzado (" + calzado + ") cannot be destroyed since the DetalleCompra " + detalleCompraCollectionOrphanCheckDetalleCompra + " in its detalleCompraCollection field has a non-nullable idCalzado field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(calzado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calzado> findCalzadoEntities() {
        return findCalzadoEntities(true, -1, -1);
    }

    public List<Calzado> findCalzadoEntities(int maxResults, int firstResult) {
        return findCalzadoEntities(false, maxResults, firstResult);
    }

    private List<Calzado> findCalzadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calzado.class));
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

    public Calzado findCalzado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calzado.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalzadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calzado> rt = cq.from(Calzado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
