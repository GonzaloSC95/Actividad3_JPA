package Modelo.Persistencia;

import Modelo.Entidad.Libreria;
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
public class DaoLibreria implements DaoInterfaceMYSQL {

    //////////////////////////
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    /////////////////////////////

    public boolean abrirConexion() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("JPALibrerias");
            entityManager = entityManagerFactory.createEntityManager();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean cerrarConexion() {
        try {
            entityManager.close();
            entityManagerFactory.close();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            return false;
        }

    }

    @Override
    public boolean insert(Object libreria) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(libreria);
            entityTransaction.commit();
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return false;
        }

    }

    @Override
    public boolean update(Object libreria) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(libreria);
            entityTransaction.commit();
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            Libreria libreria = entityManager.find(Libreria.class, id);
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(libreria);
            entityTransaction.commit();
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return false;
        }

    }

    @Override
    public List<Libreria> selectAll(String tabla) {
        try {
            //System.out.println("Conexion abierta = " + abrirConexion());
            List<Libreria> librerias = entityManager.createQuery("from " + tabla + " libreria").getResultList();
            //System.out.println("Conexion cerrada = " + cerrarConexion());
            return librerias;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return null;
        }

    }

    @Override
    public Libreria select(int id) {
        try {
            //System.out.println("Conexion abierta = " + abrirConexion());
            Libreria libreria = entityManager.find(Libreria.class, id);
            //System.out.println("Conexion cerrada = " + cerrarConexion());
            return libreria;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return null;
        }

    }

}
