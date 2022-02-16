package Test;

import Modelo.Entidad.Autor;
import Modelo.Entidad.Libreria;
import Modelo.Entidad.Libro;
import Modelo.Persistencia.DaoAutor;
import Modelo.Persistencia.DaoLibreria;
import Modelo.Persistencia.DaoLibro;

public class TestSelectALL {

    public static void main(String[] args) {

        DaoAutor daoAutor = new DaoAutor();
        //DaoEditorial daoEditorial = new DaoEditorial();
        DaoLibreria daoLibreria = new DaoLibreria();
        DaoLibro daoLibro = new DaoLibro();
        try {

            //////////////////////////////////
            System.out.println("Conexion abierta: " + daoAutor.abrirConexion());
            System.out.println("/////////////Registros encontrados///////////");
            for (Autor autor : daoAutor.selectAll("Autor")) {
                for (Libro libro : autor.getLibros()) {
                    System.out.println(libro);
                }
            }
            System.out.println("Conexion cerrada: " + daoAutor.cerrarConexion());
            /*//daoLibreria.abrirConexion();
            System.out.println("/////////////Registros encontrados///////////");
            for (Libreria libreria : daoLibreria.selectAll("Libreria")) {
                for (Libro libro : libreria.getLibros()) {
                    System.out.println(libro);
                }
            }
            //daoLibreria.cerrarConexion();*/
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }

}
