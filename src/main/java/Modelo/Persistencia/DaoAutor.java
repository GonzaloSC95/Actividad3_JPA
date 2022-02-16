package Modelo.Persistencia;

import Modelo.Entidad.Autor;
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
public class DaoAutor implements DaoInterfaceMYSQL {

    /////////////////////////////////////
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    ////////////////////////////////////

    /**
     *
     * @param autor
     * @return
     */
    @Override
    public boolean insert(Object autor) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(autor);
            entityTransaction.commit();
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return true;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            System.err.println("Conexion cerrada = " + cerrarConexion());
            return false;
        }

    }

    /**
     *
     * @param autor
     * @return
     */
    @Override
    public boolean update(Object autor) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(autor);
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
            Autor autor = entityManager.find(Autor.class, id);
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(autor);
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
    public List<Autor> selectAll(String tabla) {
        try {
            //System.out.println("Conexion abierta = " + abrirConexion());
            List<Autor> autores = entityManager.createQuery("from " + tabla + " a").getResultList();
            //System.out.println("Conexion cerrada = " + cerrarConexion());
            return autores;
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
    public Autor select(int id) {
        try {
            //System.out.println("Conexion abierta = " + abrirConexion());
            Autor autor = entityManager.find(Autor.class, id);
            //System.out.println("Conexion cerrada = " + cerrarConexion());
            return autor;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return null;
        }

    }

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

}
