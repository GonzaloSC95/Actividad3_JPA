package Modelo.Entidad;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Gonzalo
 */
@Entity
@Table(name = "librerias")
public class Libreria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String nombre_duenio;
    //-------------------------------
    @Embedded
    private Direccion direccion;
    //-----------------------------------
    //fetch = FetchType.LAZY
    @ManyToMany(mappedBy = "librerias", cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Libro> libros;

    /**
     *
     */
    public Libreria() {
        super();
    }

    /**
     *
     * @param nombre
     * @param string1
     * @param direccion
     */
    public Libreria(String nombre, String nombre_duenio, Direccion direccion) {
        super();
        try {
            this.nombre = nombre;
            this.nombre_duenio = nombre_duenio;
            this.direccion = direccion;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }

    /**
     *
     * @param id
     * @param list
     * @param i
     */
    public Libreria(int id, List<Libro> libros) {
        super();
        try {
            this.id = id;
            this.libros = libros;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getNombre_duenio() {
        return nombre_duenio;
    }

    /**
     *
     * @param nombre_duenio
     */
    public void setNombre_duenio(String nombre_duenio) {
        this.nombre_duenio = nombre_duenio;
    }

    /**
     *
     * @return
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     *
     * @param libros
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    /**
     *
     * @param libro
     */
    public void setLibro(Libro libro) {
        this.libros.add(libro);
    }

    @Override
    public String toString() {
        return "Libreria{" + "id=" + id + ", nombre=" + nombre + ", nombre_duenio=" + nombre_duenio + ", direccion=" + direccion + '}';
    }

}
