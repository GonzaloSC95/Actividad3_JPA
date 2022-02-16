package Modelo.Persistencia;

import Modelo.Entidad.Editorial;
import Modelo.Persistencia.Interfaz.DaoInterfaceMYSQL;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Gonzalo
 */
public class DaoEditorial implements DaoInterfaceMYSQL {

    /////////////////////////////
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    ////////////////////////////////////

    /**
     *
     * @return
     */
    @Override
    public boolean abrirConexion() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("JPALibrerias");
            entityManager = entityManagerFactory.createEntityManager();
            return true;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            return false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public boolean cerrarConexion() {
        try {
            entityManager.close();
            entityManagerFactory.close();
            return true;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            return false;
        }
    }

    /**
     *
     * @param editoria
     * @return
     */
    @Override
    public boolean insert(Object editoria) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(editoria);
            entityTransaction.commit();
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return true;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return false;
        }
    }

    /**
     *
     * @param editoria
     * @return
     */
    @Override
    public boolean update(Object editoria) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(editoria);
            entityTransaction.commit();
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return true;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return false;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            Editorial editorial = entityManager.find(Editorial.class, id);
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(editorial);
            entityTransaction.commit();
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return true;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return false;
        }

    }

    /**
     *
     * @param tabla
     * @return
     */
    @Override
    public List<Editorial> selectAll(String tabla) {
        try {
            //System.out.println("Conexion abierta = " + abrirConexion());
            List<Editorial> editoriales = entityManager.createQuery("from " + tabla + " e").getResultList();
            //System.out.println("Conexion cerrada = " + cerrarConexion());
            return editoriales;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return null;
        }

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Editorial select(int id) {
        try {
            //System.out.println("Conexion abierta = " + abrirConexion());
            Editorial editorial = entityManager.find(Editorial.class, id);
            //System.out.println("Conexion cerrada = " + cerrarConexion());
            return editorial;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return null;
        }

    }

}
