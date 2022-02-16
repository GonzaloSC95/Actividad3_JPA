package Test;

import Modelo.Entidad.Libreria;
import Modelo.Persistencia.DaoAutor;
import Modelo.Persistencia.DaoLibreria;
import Modelo.Persistencia.DaoLibro;

public class TestFind {

    public static void main(String[] args) {
        DaoAutor daoAutor = new DaoAutor();
        //DaoEditorial daoEditorial = new DaoEditorial();
        DaoLibreria daoLibreria = new DaoLibreria();
        DaoLibro daoLibro = new DaoLibro();
        try {
            //////////////////////////////////////////////////////////////
            System.out.println("Conexion iniciada: "+daoLibreria.abrirConexion());
            int id = 1;
            Libreria libreria = daoLibreria.select(id);
            //////////////////////////////////
            //System.out.println("Registro encontrado = " + daoLibro.select(id));
            System.out.println("Libreria = " + libreria.getLibros().get(0));
            ////////////////////////////
            System.out.println("Conexion cerrada: "+daoLibreria.cerrarConexion());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

}
