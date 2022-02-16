package Modelo.Persistencia.Interfaz;

import java.util.List;

/**
 *
 * @author Gonzalo
 */
public interface DaoInterfaceMYSQL {

    /**
     *
     * @return
     */
    public boolean abrirConexion();

    /**
     *
     * @return
     */
    public boolean cerrarConexion();

    /**
     *
     * @param objeto
     * @return
     */
    public boolean insert(Object objeto);

    /**
     *
     * @param objeto
     * @return
     */
    public boolean update(Object objeto);

    /**
     *
     * @param id
     * @return
     */
    public boolean delete(int id);

    /**
     *
     * @param tabla
     * @return
     */
    public List selectAll(String tabla);

    /**
     *
     * @param id
     * @return
     */
    public Object select(int id);

}
