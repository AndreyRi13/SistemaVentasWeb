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
import DTO.Empleado;
import DTO.Cliente;
import DTO.DetalleVentas;
import DTO.Ventas;
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
public class VentasJpaController implements Serializable {

    public VentasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ventas ventas) {
        if (ventas.getDetalleVentasCollection() == null) {
            ventas.setDetalleVentasCollection(new ArrayList<DetalleVentas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado idEmpleado = ventas.getIdEmpleado();
            if (idEmpleado != null) {
                idEmpleado = em.getReference(idEmpleado.getClass(), idEmpleado.getIdEmpleado());
                ventas.setIdEmpleado(idEmpleado);
            }
            Cliente idCliente = ventas.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdCliente());
                ventas.setIdCliente(idCliente);
            }
            Collection<DetalleVentas> attachedDetalleVentasCollection = new ArrayList<DetalleVentas>();
            for (DetalleVentas detalleVentasCollectionDetalleVentasToAttach : ventas.getDetalleVentasCollection()) {
                detalleVentasCollectionDetalleVentasToAttach = em.getReference(detalleVentasCollectionDetalleVentasToAttach.getClass(), detalleVentasCollectionDetalleVentasToAttach.getDetalleVentasPK());
                attachedDetalleVentasCollection.add(detalleVentasCollectionDetalleVentasToAttach);
            }
            ventas.setDetalleVentasCollection(attachedDetalleVentasCollection);
            em.persist(ventas);
            if (idEmpleado != null) {
                idEmpleado.getVentasCollection().add(ventas);
                idEmpleado = em.merge(idEmpleado);
            }
            if (idCliente != null) {
                idCliente.getVentasCollection().add(ventas);
                idCliente = em.merge(idCliente);
            }
            for (DetalleVentas detalleVentasCollectionDetalleVentas : ventas.getDetalleVentasCollection()) {
                Ventas oldVentasOfDetalleVentasCollectionDetalleVentas = detalleVentasCollectionDetalleVentas.getVentas();
                detalleVentasCollectionDetalleVentas.setVentas(ventas);
                detalleVentasCollectionDetalleVentas = em.merge(detalleVentasCollectionDetalleVentas);
                if (oldVentasOfDetalleVentasCollectionDetalleVentas != null) {
                    oldVentasOfDetalleVentasCollectionDetalleVentas.getDetalleVentasCollection().remove(detalleVentasCollectionDetalleVentas);
                    oldVentasOfDetalleVentasCollectionDetalleVentas = em.merge(oldVentasOfDetalleVentasCollectionDetalleVentas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ventas ventas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ventas persistentVentas = em.find(Ventas.class, ventas.getIdVentas());
            Empleado idEmpleadoOld = persistentVentas.getIdEmpleado();
            Empleado idEmpleadoNew = ventas.getIdEmpleado();
            Cliente idClienteOld = persistentVentas.getIdCliente();
            Cliente idClienteNew = ventas.getIdCliente();
            Collection<DetalleVentas> detalleVentasCollectionOld = persistentVentas.getDetalleVentasCollection();
            Collection<DetalleVentas> detalleVentasCollectionNew = ventas.getDetalleVentasCollection();
            List<String> illegalOrphanMessages = null;
            for (DetalleVentas detalleVentasCollectionOldDetalleVentas : detalleVentasCollectionOld) {
                if (!detalleVentasCollectionNew.contains(detalleVentasCollectionOldDetalleVentas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleVentas " + detalleVentasCollectionOldDetalleVentas + " since its ventas field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idEmpleadoNew != null) {
                idEmpleadoNew = em.getReference(idEmpleadoNew.getClass(), idEmpleadoNew.getIdEmpleado());
                ventas.setIdEmpleado(idEmpleadoNew);
            }
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCliente());
                ventas.setIdCliente(idClienteNew);
            }
            Collection<DetalleVentas> attachedDetalleVentasCollectionNew = new ArrayList<DetalleVentas>();
            for (DetalleVentas detalleVentasCollectionNewDetalleVentasToAttach : detalleVentasCollectionNew) {
                detalleVentasCollectionNewDetalleVentasToAttach = em.getReference(detalleVentasCollectionNewDetalleVentasToAttach.getClass(), detalleVentasCollectionNewDetalleVentasToAttach.getDetalleVentasPK());
                attachedDetalleVentasCollectionNew.add(detalleVentasCollectionNewDetalleVentasToAttach);
            }
            detalleVentasCollectionNew = attachedDetalleVentasCollectionNew;
            ventas.setDetalleVentasCollection(detalleVentasCollectionNew);
            ventas = em.merge(ventas);
            if (idEmpleadoOld != null && !idEmpleadoOld.equals(idEmpleadoNew)) {
                idEmpleadoOld.getVentasCollection().remove(ventas);
                idEmpleadoOld = em.merge(idEmpleadoOld);
            }
            if (idEmpleadoNew != null && !idEmpleadoNew.equals(idEmpleadoOld)) {
                idEmpleadoNew.getVentasCollection().add(ventas);
                idEmpleadoNew = em.merge(idEmpleadoNew);
            }
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getVentasCollection().remove(ventas);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getVentasCollection().add(ventas);
                idClienteNew = em.merge(idClienteNew);
            }
            for (DetalleVentas detalleVentasCollectionNewDetalleVentas : detalleVentasCollectionNew) {
                if (!detalleVentasCollectionOld.contains(detalleVentasCollectionNewDetalleVentas)) {
                    Ventas oldVentasOfDetalleVentasCollectionNewDetalleVentas = detalleVentasCollectionNewDetalleVentas.getVentas();
                    detalleVentasCollectionNewDetalleVentas.setVentas(ventas);
                    detalleVentasCollectionNewDetalleVentas = em.merge(detalleVentasCollectionNewDetalleVentas);
                    if (oldVentasOfDetalleVentasCollectionNewDetalleVentas != null && !oldVentasOfDetalleVentasCollectionNewDetalleVentas.equals(ventas)) {
                        oldVentasOfDetalleVentasCollectionNewDetalleVentas.getDetalleVentasCollection().remove(detalleVentasCollectionNewDetalleVentas);
                        oldVentasOfDetalleVentasCollectionNewDetalleVentas = em.merge(oldVentasOfDetalleVentasCollectionNewDetalleVentas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ventas.getIdVentas();
                if (findVentas(id) == null) {
                    throw new NonexistentEntityException("The ventas with id " + id + " no longer exists.");
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
            Ventas ventas;
            try {
                ventas = em.getReference(Ventas.class, id);
                ventas.getIdVentas();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ventas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DetalleVentas> detalleVentasCollectionOrphanCheck = ventas.getDetalleVentasCollection();
            for (DetalleVentas detalleVentasCollectionOrphanCheckDetalleVentas : detalleVentasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ventas (" + ventas + ") cannot be destroyed since the DetalleVentas " + detalleVentasCollectionOrphanCheckDetalleVentas + " in its detalleVentasCollection field has a non-nullable ventas field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleado idEmpleado = ventas.getIdEmpleado();
            if (idEmpleado != null) {
                idEmpleado.getVentasCollection().remove(ventas);
                idEmpleado = em.merge(idEmpleado);
            }
            Cliente idCliente = ventas.getIdCliente();
            if (idCliente != null) {
                idCliente.getVentasCollection().remove(ventas);
                idCliente = em.merge(idCliente);
            }
            em.remove(ventas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ventas> findVentasEntities() {
        return findVentasEntities(true, -1, -1);
    }

    public List<Ventas> findVentasEntities(int maxResults, int firstResult) {
        return findVentasEntities(false, maxResults, firstResult);
    }

    private List<Ventas> findVentasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ventas.class));
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

    public Ventas findVentas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ventas.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ventas> rt = cq.from(Ventas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
