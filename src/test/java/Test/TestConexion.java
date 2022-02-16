
package Test;

import Modelo.Persistencia.DaoLibreria;


public class TestConexion {

    
    public static void main(String[] args) {
        DaoLibreria daoLibreria=new DaoLibreria();
        daoLibreria.abrirConexion();
        daoLibreria.cerrarConexion();
    }
    
}
