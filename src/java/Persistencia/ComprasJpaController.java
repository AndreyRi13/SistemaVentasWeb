/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import DTO.Pago;
import DTO.Comprador;
import DTO.Compras;
import DTO.DetalleCompras;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Andrey R
 */
public class ComprasJpaController implements Serializable {

    public ComprasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compras compras) {
        if (compras.getDetalleComprasCollection() == null) {
            compras.setDetalleComprasCollection(new ArrayList<DetalleCompras>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pago idPago = compras.getIdPago();
            if (idPago != null) {
                idPago = em.getReference(idPago.getClass(), idPago.getIdPago());
                compras.setIdPago(idPago);
            }
            Comprador idCliente = compras.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdComprador());
                compras.setIdCliente(idCliente);
            }
            Collection<DetalleCompras> attachedDetalleComprasCollection = new ArrayList<DetalleCompras>();
            for (DetalleCompras detalleComprasCollectionDetalleComprasToAttach : compras.getDetalleComprasCollection()) {
                detalleComprasCollectionDetalleComprasToAttach = em.getReference(detalleComprasCollectionDetalleComprasToAttach.getClass(), detalleComprasCollectionDetalleComprasToAttach.getIdDetalle());
                attachedDetalleComprasCollection.add(detalleComprasCollectionDetalleComprasToAttach);
            }
            compras.setDetalleComprasCollection(attachedDetalleComprasCollection);
            em.persist(compras);
            if (idPago != null) {
                idPago.getComprasCollection().add(compras);
                idPago = em.merge(idPago);
            }
            if (idCliente != null) {
                idCliente.getComprasCollection().add(compras);
                idCliente = em.merge(idCliente);
            }
            for (DetalleCompras detalleComprasCollectionDetalleCompras : compras.getDetalleComprasCollection()) {
                Compras oldIdComprasOfDetalleComprasCollectionDetalleCompras = detalleComprasCollectionDetalleCompras.getIdCompras();
                detalleComprasCollectionDetalleCompras.setIdCompras(compras);
                detalleComprasCollectionDetalleCompras = em.merge(detalleComprasCollectionDetalleCompras);
                if (oldIdComprasOfDetalleComprasCollectionDetalleCompras != null) {
                    oldIdComprasOfDetalleComprasCollectionDetalleCompras.getDetalleComprasCollection().remove(detalleComprasCollectionDetalleCompras);
                    oldIdComprasOfDetalleComprasCollectionDetalleCompras = em.merge(oldIdComprasOfDetalleComprasCollectionDetalleCompras);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compras compras) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compras persistentCompras = em.find(Compras.class, compras.getIdCompras());
            Pago idPagoOld = persistentCompras.getIdPago();
            Pago idPagoNew = compras.getIdPago();
            Comprador idClienteOld = persistentCompras.getIdCliente();
            Comprador idClienteNew = compras.getIdCliente();
            Collection<DetalleCompras> detalleComprasCollectionOld = persistentCompras.getDetalleComprasCollection();
            Collection<DetalleCompras> detalleComprasCollectionNew = compras.getDetalleComprasCollection();
            List<String> illegalOrphanMessages = null;
            for (DetalleCompras detalleComprasCollectionOldDetalleCompras : detalleComprasCollectionOld) {
                if (!detalleComprasCollectionNew.contains(detalleComprasCollectionOldDetalleCompras)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleCompras " + detalleComprasCollectionOldDetalleCompras + " since its idCompras field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPagoNew != null) {
                idPagoNew = em.getReference(idPagoNew.getClass(), idPagoNew.getIdPago());
                compras.setIdPago(idPagoNew);
            }
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdComprador());
                compras.setIdCliente(idClienteNew);
            }
            Collection<DetalleCompras> attachedDetalleComprasCollectionNew = new ArrayList<DetalleCompras>();
            for (DetalleCompras detalleComprasCollectionNewDetalleComprasToAttach : detalleComprasCollectionNew) {
                detalleComprasCollectionNewDetalleComprasToAttach = em.getReference(detalleComprasCollectionNewDetalleComprasToAttach.getClass(), detalleComprasCollectionNewDetalleComprasToAttach.getIdDetalle());
                attachedDetalleComprasCollectionNew.add(detalleComprasCollectionNewDetalleComprasToAttach);
            }
            detalleComprasCollectionNew = attachedDetalleComprasCollectionNew;
            compras.setDetalleComprasCollection(detalleComprasCollectionNew);
            compras = em.merge(compras);
            if (idPagoOld != null && !idPagoOld.equals(idPagoNew)) {
                idPagoOld.getComprasCollection().remove(compras);
                idPagoOld = em.merge(idPagoOld);
            }
            if (idPagoNew != null && !idPagoNew.equals(idPagoOld)) {
                idPagoNew.getComprasCollection().add(compras);
                idPagoNew = em.merge(idPagoNew);
            }
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getComprasCollection().remove(compras);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getComprasCollection().add(compras);
                idClienteNew = em.merge(idClienteNew);
            }
            for (DetalleCompras detalleComprasCollectionNewDetalleCompras : detalleComprasCollectionNew) {
                if (!detalleComprasCollectionOld.contains(detalleComprasCollectionNewDetalleCompras)) {
                    Compras oldIdComprasOfDetalleComprasCollectionNewDetalleCompras = detalleComprasCollectionNewDetalleCompras.getIdCompras();
                    detalleComprasCollectionNewDetalleCompras.setIdCompras(compras);
                    detalleComprasCollectionNewDetalleCompras = em.merge(detalleComprasCollectionNewDetalleCompras);
                    if (oldIdComprasOfDetalleComprasCollectionNewDetalleCompras != null && !oldIdComprasOfDetalleComprasCollectionNewDetalleCompras.equals(compras)) {
                        oldIdComprasOfDetalleComprasCollectionNewDetalleCompras.getDetalleComprasCollection().remove(detalleComprasCollectionNewDetalleCompras);
                        oldIdComprasOfDetalleComprasCollectionNewDetalleCompras = em.merge(oldIdComprasOfDetalleComprasCollectionNewDetalleCompras);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compras.getIdCompras();
                if (findCompras(id) == null) {
                    throw new NonexistentEntityException("The compras with id " + id + " no longer exists.");
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
            Compras compras;
            try {
                compras = em.getReference(Compras.class, id);
                compras.getIdCompras();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compras with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DetalleCompras> detalleComprasCollectionOrphanCheck = compras.getDetalleComprasCollection();
            for (DetalleCompras detalleComprasCollectionOrphanCheckDetalleCompras : detalleComprasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compras (" + compras + ") cannot be destroyed since the DetalleCompras " + detalleComprasCollectionOrphanCheckDetalleCompras + " in its detalleComprasCollection field has a non-nullable idCompras field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Pago idPago = compras.getIdPago();
            if (idPago != null) {
                idPago.getComprasCollection().remove(compras);
                idPago = em.merge(idPago);
            }
            Comprador idCliente = compras.getIdCliente();
            if (idCliente != null) {
                idCliente.getComprasCollection().remove(compras);
                idCliente = em.merge(idCliente);
            }
            em.remove(compras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compras> findComprasEntities() {
        return findComprasEntities(true, -1, -1);
    }

    public List<Compras> findComprasEntities(int maxResults, int firstResult) {
        return findComprasEntities(false, maxResults, firstResult);
    }

    private List<Compras> findComprasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compras.class));
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

    public Compras findCompras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compras.class, id);
        } finally {
            em.close();
        }
    }

    public int getComprasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compras> rt = cq.from(Compras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
