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

public class TestInsertManyToMany {

    public static void main(String[] args) {
        DaoAutor daoAutor = new DaoAutor();
        DaoEditorial daoEditorial = new DaoEditorial();
        DaoLibreria daoLibreria = new DaoLibreria();
        DaoLibro daoLibro = new DaoLibro();
        try {
            //Creamos los objetos
            //-----------------------------
            Libro libro1 = new Libro("Todo se desmorona", 40.69);
            //---------------------
            Libro libro2 = new Libro("Me alegraría de otra muerte", 30.40);
            //-------------------------
            Libro libro3 = new Libro("La flecha del dios", 50.60);

            //-------------------
            Direccion dir1 = new Direccion("España", "Madrid", "CALLE MONTALBAN 1", "28014 ");
            Direccion dir2 = new Direccion("España", "Madrid", "CALLE LEONARDO PRIETO CASTRO 8", "28040");
            Libreria libreria1 = new Libreria("2Pajaros", "Ramon", dir1);
            //------------------------
            Libreria libreria2 = new Libreria("Abarzuza", "Gonzalo", dir2);

            //Creamos la lista de las librerias que tendran el libro 1
            List<Libreria> LibreriasLibro1 = new ArrayList<Libreria>();
            LibreriasLibro1.add(libreria1);
            libro1.setLibrerias(LibreriasLibro1);

            //Creamos la lista de las librerias que tendran el libro 2
            List<Libreria> LibreriasLibro2 = new ArrayList<Libreria>();
            LibreriasLibro2.add(libreria1);
            LibreriasLibro2.add(libreria2);
            libro2.setLibrerias(LibreriasLibro2);

            //Creamos la lista de las librerias que tendran el libro 3
            List<Libreria> LibreriasLibro3 = new ArrayList<Libreria>();
            LibreriasLibro3.add(libreria1);
            libro3.setLibrerias(LibreriasLibro3);

            //Creamos la lista de los libros que estaran en la libreria 1
            List<Libro> librosLibreia1 = new ArrayList<Libro>();
            librosLibreia1.add(libro1);
            librosLibreia1.add(libro3);
            libreria1.setLibros(librosLibreia1);

            //Creamos la lista de los libros que estaran en la libreria 2
            List<Libro> librosLibreia2 = new ArrayList<Libro>();
            librosLibreia2.add(libro1);
            librosLibreia2.add(libro2);
            libreria2.setLibros(librosLibreia2);

            //PERSISTIMOS LA INFORMACION CON CASCADE PERSIST Y MERGE
            //System.out.println("Libro creado = " + daoLibro.insert(libro1));
            
            //------ASIGNAMOS UN AUTOR Y UNA EDITORIAL A CADA LIBRO------
            libro1.setAutor(new Autor("Chinua", "Achebe", "02-06-1970"));
            libro1.setEditorial(new Editorial("Alianza Editorial", dir1));
            libro2.setAutor(new Autor("Hans", "Christian Andersen", "10-01-1835"));
            libro2.setEditorial(new Editorial("Fandogamia Editorial", dir2));
            libro3.setAutor(new Autor("Paul", "Celan", "06-06-1349"));
            libro3.setEditorial(new Editorial("ECC Ediciones", new Direccion("España", "Madrid", "PASEO JULIO ROMERO DE TORRES S/N", "28009")));
            
            //PERSISTIMOS LA INFORMACION CON CASCADE PERSIST Y MERGE
            System.out.println("Libro creado = " + daoLibro.insert(libro1));
            System.out.println("Libro creado = " + daoLibro.insert(libro2));
            System.out.println("Libro creado = " + daoLibro.insert(libro3));
            
            //////////////////////DIRECCIONES////////////////////////
            /* Direccion dir1 = new Direccion("España", "Madrid", "CALLE MONTALBAN 1", "28014 ");
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
            Libro libro2 = new Libro("Me alegraría de otra muerte", 30.40);
            Libro libro3 = new Libro("La flecha del dios", 50.60);
            Libro libro4 = new Libro("Termiteros de la sabana", 16.25);*/
            //---------------------------------------------------------------------------------
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

}
