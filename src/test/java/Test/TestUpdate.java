package Test;

import Modelo.Entidad.Autor;
import Modelo.Entidad.Editorial;
import Modelo.Entidad.Libreria;
import Modelo.Entidad.Libro;
import Modelo.Persistencia.DaoAutor;
import Modelo.Persistencia.DaoEditorial;
import Modelo.Persistencia.DaoLibreria;
import Modelo.Persistencia.DaoLibro;
import java.util.ArrayList;
import java.util.List;

public class TestUpdate {

    public static void main(String[] args) {
        DaoAutor daoAutor = new DaoAutor();
        DaoEditorial daoEditorial = new DaoEditorial();
        DaoLibreria daoLibreria = new DaoLibreria();
        DaoLibro daoLibro = new DaoLibro();
        try {
            daoEditorial.abrirConexion();
            Editorial editorial = daoEditorial.select(1);
            daoEditorial.cerrarConexion();
            //--------------------------------------
            daoAutor.abrirConexion();
            Autor autor = daoAutor.select(1);
            daoAutor.cerrarConexion();
            //----------------------------------------
            daoLibreria.abrirConexion();
            Libreria libreria = daoLibreria.select(1);
            daoLibreria.cerrarConexion();
            //----------------------------------------
            //Libro libro5 = new Libro("La capsa de contes", 50.68);
            daoLibro.abrirConexion();
            Libro libro5 = daoLibro.select(1);
            //************************************
            libro5.setAutor(autor);
            libro5.setEditorial(editorial);
            libro5.setLibreria(libreria);
            daoLibro.cerrarConexion();
            //----------------------------------
            //Libro libro6 = new Libro("El patito feo", 40.89);
            daoLibro.abrirConexion();
            Libro libro6 = daoLibro.select(2);
            //************************************
            libro6.setAutor(autor);
            libro6.setTitulo("xxxxxx");//Prueba de actualizar titulo
            libro6.setEditorial(editorial);
            libro6.setLibreria(libreria);
            daoLibro.cerrarConexion();
            //--------------------------------------
            //Libro libro7 = new Libro("Pulgarcita", 60.54);
            daoLibro.abrirConexion();
            Libro libro7 = daoLibro.select(3);
            //************************************
            libro7.setAutor(autor);
            libro7.setEditorial(editorial);
            libro7.setLibreria(libreria);
            daoLibro.cerrarConexion();
            //----------------------------------------
            //Libro libro8 = new Libro("Cuentos de Andersen", 15.23);
            //daoLibro.abrirConexion();
            /*Libro libro8 = daoLibro.select(54);
            //************************************
            libro8.setAutor(autor);
            libro8.setEditorial(editorial);
            libro8.setLibreria(libreria);
            daoLibro.cerrarConexion();*/
            //---------------------------------------------
            List libros = new ArrayList();
            libros.add(libro5);
            libros.add(libro6);
            libros.add(libro7);
            //libros.add(libro8);
            //-----------Update Autor-------------------
            /*autor.setLibros(libros);
            System.out.println("Autor actualizado = " + daoAutor.update(autor));*/
            //-----------Update Editorial-------------------
            /*editorial.setLibros(libros);
            daoEditorial.update(editorial);*/
            //------------------------------------------
            libreria.setLibros(libros);
            System.out.println("Libreria actualizada = " + 
                    daoLibreria.update(libreria));
            ///////////////////////////////////////////////////
            /*Libreria libreria = new Libreria(1,libros);
            Libro libro = new Libro(1, 100.98);
            //////////////////////////////////
            System.out.println("Registro modificado = " + daoLibreria.update(libreria));
            System.out.println("Registro modificado = " + daoAutor.update(autor));
            System.out.println("Registro modificado = " + daoLibro.update(libro));
            System.out.println("Registro modificado = " + daoEditorial.update(editorial));
            ////////////////////////////*/
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

}
