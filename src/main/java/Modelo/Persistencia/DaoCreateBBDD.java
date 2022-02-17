package Modelo.Persistencia;

import Modelo.Entidad.Autor;
import Modelo.Entidad.Direccion;
import Modelo.Entidad.Editorial;
import Modelo.Entidad.Libreria;
import Modelo.Entidad.Libro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JTextArea;

/**
 *
 * @author Gonzalo
 */
public class DaoCreateBBDD {

    /**
     *
     */
    public void createSchema() {
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String password = "";
        String nombreSchema = "jpa_librerias";
        //-----------------------------------
        try (Connection conexion = DriverManager.getConnection(url, usuario, password);) {
            PreparedStatement sentencia = conexion.prepareStatement("CREATE SCHEMA " + nombreSchema + ";");
            int sntenciaEjecutada = sentencia.executeUpdate();
            if (sntenciaEjecutada == 1) {
                System.out.println("Esquema creado " + nombreSchema);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }

    /**
     *
     */
    public void limpiarTablas() {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPALibrerias");
            EntityManager em = factory.createEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            /*em.createQuery("DELETE FROM Libro").executeUpdate();
            em.createQuery("DELETE FROM Libreria").executeUpdate();
            em.createQuery("DELETE FROM Autor").executeUpdate();
            em.createQuery("DELETE FROM Editorial").executeUpdate();*/
            //---------------------------------------------------------
            em.createNativeQuery("DROP TABLE Libreria_libro").executeUpdate();
            em.createNativeQuery("DROP TABLE Libros").executeUpdate();
            em.createNativeQuery("DROP TABLE Librerias").executeUpdate();
            em.createNativeQuery("DROP TABLE Autores").executeUpdate();
            em.createNativeQuery("DROP TABLE Editoriales").executeUpdate();
            et.commit();
            em.close();
            factory.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    /**
     *
     * @param jTextArea
     */
    public void crearBBDD(JTextArea jTextArea) {
        //////////////////////DIRECCIONES////////////////////////
        Direccion dir1 = new Direccion("España", "Madrid", "CALLE MONTALBAN 1", "28014 ");
        Direccion dir2 = new Direccion("España", "Madrid", "CALLE LEONARDO PRIETO CASTRO 8", "28040");
        Direccion dir3 = new Direccion("España", "Madrid", "CARRETERA M-607 2100", "28049");
        Direccion dir4 = new Direccion("España", "Madrid", "PASEO JULIO ROMERO DE TORRES S/N", "28009");
        /////3 AUTORES/////////////
        Autor autor1 = new Autor("Chinua", "Achebe", "02-06-1970");
        Autor autor2 = new Autor("Hans", "Christian Andersen", "10-01-1835");
        Autor autor3 = new Autor("Paul", "Celan", "06-06-1349");
        ///2 EDITORIALES///////////////////////////
        Editorial editorial1 = new Editorial("Alianza Editorial", dir1);
        Editorial editorial2 = new Editorial("Fandogamia Editorial", dir2);
        /////8 LIBROS/////////////////////////////////////////
        Libro libro1 = new Libro("Todo se desmorona", 40.69);
        libro1.setAutor(autor1);//1
        libro1.setEditorial(editorial1);//1
        autor1.setLibro(libro1);
        editorial1.setLibro(libro1);
        //-------------------------------------------------------
        Libro libro2 = new Libro("Me alegraría de otra muerte", 30.40);
        libro2.setAutor(autor2);//2
        libro2.setEditorial(editorial2);//2
        autor2.setLibro(libro2);
        editorial2.setLibro(libro2);
        //-----------------------------------------------------------
        Libro libro3 = new Libro("La flecha del dios", 50.60);
        libro3.setAutor(autor3);//3
        libro3.setEditorial(editorial1);//3
        autor3.setLibro(libro3);
        editorial1.setLibro(libro3);
        //--------------------------------------
        Libro libro4 = new Libro("Termiteros de la sabana", 16.25);
        libro4.setAutor(autor1);//1
        libro4.setEditorial(editorial2);//2
        autor1.setLibro(libro4);
        editorial2.setLibro(libro4);
        //---------------------------------------------------------------------------------
        Libro libro5 = new Libro("La capsa de contes", 50.68);
        libro5.setAutor(autor2);//2
        libro5.setEditorial(editorial1);//1
        autor2.setLibro(libro5);
        editorial1.setLibro(libro5);
        //---------------------------------------------------------
        Libro libro6 = new Libro("El patito feo", 40.89);
        libro6.setAutor(autor3);//3
        libro6.setEditorial(editorial2);//2
        autor3.setLibro(libro6);
        editorial2.setLibro(libro6);
        //-----------------------------------------------------------
        Libro libro7 = new Libro("Pulgarcita", 60.54);
        libro7.setAutor(autor1);//1
        libro7.setEditorial(editorial1);//1
        autor1.setLibro(libro7);
        editorial1.setLibro(libro7);
        //-----------------------------------------------
        Libro libro8 = new Libro("Cuentos de Andersen", 15.23);
        libro8.setAutor(autor2);//2
        libro8.setEditorial(editorial2);//2
        autor2.setLibro(libro8);
        editorial2.setLibro(libro8);
        ////2 LIBRERIAS CON 4 LIBROS CADA 1////////////////////////
        List<Libreria> librerias1 = new ArrayList<>();//Libros que estan en 2 librerias a la vez
        List<Libro> libros1 = new ArrayList<>();
        List<Libreria> librerias2 = new ArrayList<>();//Libros que estan en 1 libreria
        List<Libro> libros2 = new ArrayList<>();
        ///-----------------------------------
        Libreria libreria1 = new Libreria("2Pajaros", "Ramon", dir3);
        Libreria libreria2 = new Libreria("Abarzuza", "Gonzalo", dir4);
        //--------------------------------------
        librerias1.add(libreria1);
        librerias1.add(libreria2);//Libros que estan en 2 librerias a la vez
        libros1.add(libro1);
        libros1.add(libro2);
        libros1.add(libro3);
        libros1.add(libro4);
        //*********************************************************
        libro1.setLibrerias(librerias1);
        libro2.setLibrerias(librerias1);
        libro3.setLibrerias(librerias1);
        libro4.setLibrerias(librerias1);
        libreria1.setLibros(libros1);
        libreria2.setLibros(libros1);
        //------------------------------------------------------------------------
        librerias2.add(libreria1);//Libros que estan en 1 libreria
        libros2.add(libro5);
        libros2.add(libro6);
        libros2.add(libro7);
        libros2.add(libro8);
        //***********************************************
        libro5.setLibrerias(librerias2);
        libro6.setLibrerias(librerias2);
        libro7.setLibrerias(librerias2);
        libro8.setLibrerias(librerias2);
        libreria1.setLibros(libros2);
        //--------------------------------------------------------------------
        DaoAutor daoAutor = new DaoAutor();
        try {

            if (checkNRows() > 0) {
                jTextArea.setText("Ya existe una bbdd creada, "
                        + "si deseas crearla de nuevo, debes borrar la actual.");
                return;
            }
            if (daoAutor.insert(autor1) || daoAutor.insert(autor2) || daoAutor.insert(autor3)) {
                jTextArea.setText(" +3 Atores creados...\n\n");
                jTextArea.append(" +2 Editoriales creadas...\n\n");
                jTextArea.append(" +8 Libros creados...\n\n");
                jTextArea.append(" +2 Librerias creadas...\n\n");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }

    /**
     *
     * @return
     */
    public long checkNRows() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPALibrerias");
        EntityManager em = factory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        long nRows = (long) em.createQuery("SELECT COUNT(a.id) FROM Autor a").getSingleResult();
        et.commit();
        em.close();
        factory.close();
        return nRows;
    }

}
