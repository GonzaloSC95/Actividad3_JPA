package Test;

import Modelo.Persistencia.DaoAutor;
import Modelo.Persistencia.DaoEditorial;
import Modelo.Persistencia.DaoLibreria;
import Modelo.Persistencia.DaoLibro;

public class TestDelete {

    public static void main(String[] args) {
        DaoAutor daoAutor = new DaoAutor();
        DaoEditorial daoEditorial = new DaoEditorial();
        DaoLibreria daoLibreria = new DaoLibreria();
        DaoLibro daoLibro = new DaoLibro();
        try {
            System.out.println("Conexion establecida = " + daoLibreria.abrirConexion());
            //////////////////////////////////////////////////////////////
            int id = 1;
            //////////////////////////////////
            //System.out.println("Registro actualizado = "+daoLibro.update(libro));
            System.out.println("Registro borrado = " + daoLibreria.delete(id));
            ////////////////////////////
            System.out.println("Conexion cerrada = " + daoLibreria.cerrarConexion());

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }

}
