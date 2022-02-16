package Modelo.Entidad;

import javax.persistence.Embeddable;

/**
 *
 * @author Gonzalo
 */
@Embeddable
public class Direccion {

    private String pais;
    private String ciudad;
    private String calle;
    private String cp;

    /**
     *
     */
    public Direccion() {
        super();
    }

    /**
     *
     * @param pais
     * @param ciudad
     * @param calle
     * @param cp
     */
    public Direccion(String pais, String ciudad, String calle, String cp) {
        super();
        this.pais = pais;
        this.ciudad = ciudad;
        this.calle = calle;
        this.cp = cp;
    }

    /**
     *
     * @return
     */
    public String getPais() {
        return pais;
    }

    /**
     *
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     *
     * @return
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     *
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     *
     * @return
     */
    public String getCalle() {
        return calle;
    }

    /**
     *
     * @param calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     *
     * @return
     */
    public String getCp() {
        return cp;
    }

    /**
     *
     * @param cp
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Direccion{" + "pais=" + pais + ", ciudad=" + ciudad + ", calle=" + calle + ", cp=" + cp + '}';
    }

}
