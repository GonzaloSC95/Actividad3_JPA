package Test;

import Modelo.Entidad.Autor;
import Modelo.Entidad.Direccion;
import Modelo.Entidad.Editorial;
import Modelo.Entidad.Libreria;
import Modelo.Entidad.Libro;
import Modelo.Persistencia.DaoAutor;
import Modelo.Persistencia.DaoEditorial;
import Modelo.Persistencia.DaoLibreria;
import Modelo.Persistencia.DaoLibro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestInserOneToMany {

    public static void main(String[] args) {
        DaoAutor daoAutor = new DaoAutor();
        DaoEditorial daoEditorial = new DaoEditorial();
        DaoLibreria daoLibreria = new DaoLibreria();
        DaoLibro daoLibro = new DaoLibro();
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPALibrerias");
            EntityManager em = factory.createEntityManager();
            //////////////////////DIRECCIONES////////////////////////
            Direccion dir1 = new Direccion("España", "Madrid", "CALLE MONTALBAN 1", "28014 ");
            Direccion dir2 = new Direccion("España", "Madrid", "CALLE LEONARDO PRIETO CASTRO 8", "28040");
            Direccion dir3 = new Direccion("España", "Madrid", "CARRETERA M-607 2100", "28049");
            Direccion dir4 = new Direccion("España", "Madrid", "PASEO JULIO ROMERO DE TORRES S/N", "28009");
            Direccion dir5 = new Direccion("España", "Madrid", "CALLE HACIENDA DE PAVONES 146", "28030");
            //////////////////////////EDITORIALES//////////////////////////////////////////////////////////////////////
            Editorial editorial1 = new Editorial("Alianza Editorial", dir1);
            Editorial editorial2 = new Editorial("Fandogamia Editorial", dir2);
            Editorial editorial3 = new Editorial("Planeta Cómic", dir3);
            Editorial editorial4 = new Editorial("ECC Ediciones", dir4);
            ///////////////////////////////LIBRERIAS/////////////////////////////////////
            Libreria libreria1 = new Libreria("2Pajaros", "Ramon", dir1);
            Libreria libreria2 = new Libreria("Abarzuza", "Gonzalo", dir2);
            Libreria libreria3 = new Libreria("Acuarel xxx", "Julian", dir3);
            Libreria libreria4 = new Libreria("Ágora Libreria", "Pedro", dir4);
            ////////////////AUTORES//////////////////
            Autor autor1 = new Autor("Chinua", "Achebe", "02-06-1970");
            Autor autor2 = new Autor("Hans", "Christian Andersen", "10-01-1835");
            Autor autor3 = new Autor("Paul", "Celan", "06-06-1349");
            Autor autor4 = new Autor("Charles", "Dickens", "30-12-1861");
            /////////////////////////////////////LIBROS//////////////////////////////////
            Libro libro1 = new Libro("Todo se desmorona", 40.69);
            libro1.setAutor(autor1);
            libro1.setEditorial(editorial1);
            Libro libro2 = new Libro("Me alegraría de otra muerte", 30.40);
            libro2.setAutor(autor1);
            libro2.setEditorial(editorial1);
            Libro libro3 = new Libro("La flecha del dios", 50.60);
            libro3.setAutor(autor1);
            libro3.setEditorial(editorial1);
            Libro libro4 = new Libro("Termiteros de la sabana", 16.25);
            libro4.setAutor(autor1);
            libro4.setEditorial(editorial1);
            //---------------------------------------------------------------------------------
            Libro libro5 = new Libro("La capsa de contes", 50.68);
            libro5.setAutor(autor2);
            libro5.setEditorial(editorial2);
            Libro libro6 = new Libro("El patito feo", 40.89);
            libro6.setAutor(autor2);
            libro6.setEditorial(editorial2);
            Libro libro7 = new Libro("Pulgarcita", 60.54);
            libro7.setAutor(autor2);
            libro7.setEditorial(editorial2);
            Libro libro8 = new Libro("Cuentos de Andersen", 15.23);
            libro8.setAutor(autor2);
            libro8.setEditorial(editorial2);
            //----------------------------------------------------------------------------------
            Libro libro9 = new Libro("Microlitos", 15.23);
            libro9.setAutor(autor3);
            libro9.setEditorial(editorial3);
            Libro libro10 = new Libro("Los poemas póstumos", 50.68);
            libro10.setAutor(autor3);
            libro10.setEditorial(editorial3);
            Libro libro11 = new Libro("Correspondencia", 60.54);
            libro11.setAutor(autor3);
            libro11.setEditorial(editorial3);
            Libro libro12 = new Libro("Amapola y memoria", 40.89);
            libro12.setAutor(autor3);
            libro12.setEditorial(editorial3);
            //-----------------------------------------------------------------------
            Libro libro13 = new Libro("Cancion De Nadal", 15.23);
            libro13.setAutor(autor4);
            libro13.setEditorial(editorial4);
            Libro libro14 = new Libro("Grandes esperanzas", 50.68);
            libro14.setAutor(autor4);
            libro14.setEditorial(editorial4);
            Libro libro15 = new Libro("Canción de Navidad y otros cuentos", 60.54);
            libro15.setAutor(autor4);
            libro15.setEditorial(editorial4);
            Libro libro16 = new Libro("Oliver Twist", 40.89);
            libro16.setAutor(autor4);
            libro16.setEditorial(editorial4);
            //------------------------------------------------------------------------------
            List libros1 = new ArrayList();
            libros1.add(libro1);
            libros1.add(libro2);
            libros1.add(libro3);
            libros1.add(libro4);
            List libros2 = new ArrayList();
            libros2.add(libro5);
            libros2.add(libro6);
            libros2.add(libro7);
            libros2.add(libro8);
            List libros3 = new ArrayList();
            libros3.add(libro9);
            libros3.add(libro10);
            libros3.add(libro11);
            libros3.add(libro12);
            List libros4 = new ArrayList();
            libros4.add(libro13);
            libros4.add(libro14);
            libros4.add(libro15);
            libros4.add(libro16);
            //--------------------------------------------------------------------------
            autor1.setLibros(libros1);
            autor2.setLibros(libros2);
            autor3.setLibros(libros3);
            autor4.setLibros(libros4);
            //--------------------------------------------------------------------------
            //libreria1.setLibros(libros1);
            /*libreria2.setLibros(libros2);
            libreria3.setLibros(libros3);
            libreria4.setLibros(libros4);
            //--------------------------------------------------------------------------
            editorial1.setLibros(libros1);
            editorial2.setLibros(libros2);
            editorial3.setLibros(libros3);
            editorial4.setLibros(libros4);*/
            ///////////////////////////////DAO////////////////////////////////////////////////////
            System.out.println("Autor insertado: " + daoAutor.insert(autor1));
            System.out.println("Autor insertado: " + daoAutor.insert(autor2));
            System.out.println("Autor insertado: " + daoAutor.insert(autor3));
            System.out.println("Autor insertado: " + daoAutor.insert(autor4));
            ////////////////////////////////////////////////////////////////
            /*System.out.println("Editorial insertada: " + daoEditorial.insert(editorial1));
            System.out.println("Editorial insertada: "+daoEditorial.insert(editorial2));
            System.out.println("Editorial insertada: "+daoEditorial.insert(editorial3));
            System.out.println("Editorial insertada: "+daoEditorial.insert(editorial4));*/
            /////////////////////////////////////////////////////////
            //System.out.println("Libreria insertada: "+daoLibreria.insert(libreria1));
            /*System.out.println("Libreria insertada: "+daoLibreria.insert(libreria2));
            System.out.println("Libreria insertada: "+daoLibreria.insert(libreria3));
            System.out.println("Libreria insertada: "+daoLibreria.insert(libreria4));*/

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

}
