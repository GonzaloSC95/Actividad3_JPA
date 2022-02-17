package Modelo.Entidad;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gonzalo
 */
@Entity
@Table(name = "editoriales")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //------------------------
    private String nombre;
    //----------------------------
    @Embedded
    private Direccion direccion;
    //---------------------------
    //fetch = FetchType.LAZY
    @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
    private List<Libro> libros;

    /**
     *
     */
    public Editorial() {
        super();
        libros=new ArrayList<>();
    }

    /**
     *
     * @param nombre
     * @param direccion
     */
    public Editorial(String nombre, Direccion direccion) {
        super();
        try {
            libros=new ArrayList<>();
            this.nombre = nombre;
            this.direccion = direccion;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    /**
     *
     * @param id
     * @param libros
     */
    public Editorial(int id, List<Libro> libros) {
        super();
        try {
            libros=new ArrayList<>();
            this.id = id;
            this.libros = libros;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }

    ///////GETTERS Y SETTERS//////
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
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }

}
