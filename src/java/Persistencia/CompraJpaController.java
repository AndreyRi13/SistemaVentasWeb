/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTO.Compra;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.Comprador;
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
public class CompraJpaController implements Serializable {

    public CompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compra compra) {
        if (compra.getDetalleCompraCollection() == null) {
            compra.setDetalleCompraCollection(new ArrayList<DetalleCompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comprador idComprador = compra.getIdComprador();
            if (idComprador != null) {
                idComprador = em.getReference(idComprador.getClass(), idComprador.getIdComprador());
                compra.setIdComprador(idComprador);
            }
            Collection<DetalleCompra> attachedDetalleCompraCollection = new ArrayList<DetalleCompra>();
            for (DetalleCompra detalleCompraCollectionDetalleCompraToAttach : compra.getDetalleCompraCollection()) {
                detalleCompraCollectionDetalleCompraToAttach = em.getReference(detalleCompraCollectionDetalleCompraToAttach.getClass(), detalleCompraCollectionDetalleCompraToAttach.getIdDetalle());
                attachedDetalleCompraCollection.add(detalleCompraCollectionDetalleCompraToAttach);
            }
            compra.setDetalleCompraCollection(attachedDetalleCompraCollection);
            em.persist(compra);
            if (idComprador != null) {
                idComprador.getCompraCollection().add(compra);
                idComprador = em.merge(idComprador);
            }
            for (DetalleCompra detalleCompraCollectionDetalleCompra : compra.getDetalleCompraCollection()) {
                Compra oldIdCompraOfDetalleCompraCollectionDetalleCompra = detalleCompraCollectionDetalleCompra.getIdCompra();
                detalleCompraCollectionDetalleCompra.setIdCompra(compra);
                detalleCompraCollectionDetalleCompra = em.merge(detalleCompraCollectionDetalleCompra);
                if (oldIdCompraOfDetalleCompraCollectionDetalleCompra != null) {
                    oldIdCompraOfDetalleCompraCollectionDetalleCompra.getDetalleCompraCollection().remove(detalleCompraCollectionDetalleCompra);
                    oldIdCompraOfDetalleCompraCollectionDetalleCompra = em.merge(oldIdCompraOfDetalleCompraCollectionDetalleCompra);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compra compra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra persistentCompra = em.find(Compra.class, compra.getIdCompra());
            Comprador idCompradorOld = persistentCompra.getIdComprador();
            Comprador idCompradorNew = compra.getIdComprador();
            Collection<DetalleCompra> detalleCompraCollectionOld = persistentCompra.getDetalleCompraCollection();
            Collection<DetalleCompra> detalleCompraCollectionNew = compra.getDetalleCompraCollection();
            List<String> illegalOrphanMessages = null;
            for (DetalleCompra detalleCompraCollectionOldDetalleCompra : detalleCompraCollectionOld) {
                if (!detalleCompraCollectionNew.contains(detalleCompraCollectionOldDetalleCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleCompra " + detalleCompraCollectionOldDetalleCompra + " since its idCompra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idCompradorNew != null) {
                idCompradorNew = em.getReference(idCompradorNew.getClass(), idCompradorNew.getIdComprador());
                compra.setIdComprador(idCompradorNew);
            }
            Collection<DetalleCompra> attachedDetalleCompraCollectionNew = new ArrayList<DetalleCompra>();
            for (DetalleCompra detalleCompraCollectionNewDetalleCompraToAttach : detalleCompraCollectionNew) {
                detalleCompraCollectionNewDetalleCompraToAttach = em.getReference(detalleCompraCollectionNewDetalleCompraToAttach.getClass(), detalleCompraCollectionNewDetalleCompraToAttach.getIdDetalle());
                attachedDetalleCompraCollectionNew.add(detalleCompraCollectionNewDetalleCompraToAttach);
            }
            detalleCompraCollectionNew = attachedDetalleCompraCollectionNew;
            compra.setDetalleCompraCollection(detalleCompraCollectionNew);
            compra = em.merge(compra);
            if (idCompradorOld != null && !idCompradorOld.equals(idCompradorNew)) {
                idCompradorOld.getCompraCollection().remove(compra);
                idCompradorOld = em.merge(idCompradorOld);
            }
            if (idCompradorNew != null && !idCompradorNew.equals(idCompradorOld)) {
                idCompradorNew.getCompraCollection().add(compra);
                idCompradorNew = em.merge(idCompradorNew);
            }
            for (DetalleCompra detalleCompraCollectionNewDetalleCompra : detalleCompraCollectionNew) {
                if (!detalleCompraCollectionOld.contains(detalleCompraCollectionNewDetalleCompra)) {
                    Compra oldIdCompraOfDetalleCompraCollectionNewDetalleCompra = detalleCompraCollectionNewDetalleCompra.getIdCompra();
                    detalleCompraCollectionNewDetalleCompra.setIdCompra(compra);
                    detalleCompraCollectionNewDetalleCompra = em.merge(detalleCompraCollectionNewDetalleCompra);
                    if (oldIdCompraOfDetalleCompraCollectionNewDetalleCompra != null && !oldIdCompraOfDetalleCompraCollectionNewDetalleCompra.equals(compra)) {
                        oldIdCompraOfDetalleCompraCollectionNewDetalleCompra.getDetalleCompraCollection().remove(detalleCompraCollectionNewDetalleCompra);
                        oldIdCompraOfDetalleCompraCollectionNewDetalleCompra = em.merge(oldIdCompraOfDetalleCompraCollectionNewDetalleCompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compra.getIdCompra();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
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
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getIdCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DetalleCompra> detalleCompraCollectionOrphanCheck = compra.getDetalleCompraCollection();
            for (DetalleCompra detalleCompraCollectionOrphanCheckDetalleCompra : detalleCompraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compra (" + compra + ") cannot be destroyed since the DetalleCompra " + detalleCompraCollectionOrphanCheckDetalleCompra + " in its detalleCompraCollection field has a non-nullable idCompra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Comprador idComprador = compra.getIdComprador();
            if (idComprador != null) {
                idComprador.getCompraCollection().remove(compra);
                idComprador = em.merge(idComprador);
            }
            em.remove(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }

    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compra.class));
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

    public Compra findCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compra> rt = cq.from(Compra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
