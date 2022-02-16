package Modelo.Persistencia;

import Modelo.Entidad.Libro;
import Modelo.Persistencia.Interfaz.DaoInterfaceMYSQL;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DaoLibro implements DaoInterfaceMYSQL {

    private String JPAEntityName = "JPALibrerias";
    //////////////////////////////
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    //////////////////////////////////////

    @Override
    public boolean abrirConexion() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(JPAEntityName);
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
    public boolean insert(Object libro) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(libro);
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
    public boolean update(Object libro) {
        try {
            System.out.println("Conexion abierta = " + abrirConexion());
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(libro);
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
            Libro libro = entityManager.find(Libro.class, id);
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(libro);
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
    public List<Libro> selectAll(String tabla) {
        try {
            //System.out.println("Conexion abierta = " + abrirConexion());
            List<Libro> libros = entityManager.createQuery("from " + tabla + " libro").getResultList();
            //System.out.println("Conexion cerrada = " + cerrarConexion());
            return libros;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return null;
        }

    }

    @Override
    public Libro select(int id) {
        try {
            //System.out.println("Conexion abierta = " + abrirConexion());
            Libro libro = entityManager.find(Libro.class, id);
            //System.out.println("Conexion cerrada = " + cerrarConexion());
            return libro;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
            System.out.println("Conexion cerrada = " + cerrarConexion());
            return null;
        }
    }

}
