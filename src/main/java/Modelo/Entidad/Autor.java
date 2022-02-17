package Modelo.Entidad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gonzalo
 */
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /////////////////////////////////////
    private String nombre;
    private String apellidos;
    ////////////////////////////////
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fNacimiento;
    /////////////////////////////
    //fetch = FetchType.LAZY
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;

    /**
     *
     */
    public Autor() {
        super();
        libros= new ArrayList<>();
    }

    /**
     *
     * @param nombre
     * @param string1
     * @param fNacimiento
     */
    public Autor(String nombre, String apellidos, String fNacimiento) {
        super();
        try {
            libros= new ArrayList<>();
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fNacimiento
                    = new SimpleDateFormat("dd-MM-yyyy").parse(fNacimiento);
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    //CONSTRUCTOR PRINCIPAL CON ID Y SIN LIBROS
    /**
     *
     * @param id
     * @param libros
     * @param i
     * @param list
     */
    public Autor(int id, List<Libro> libros) {
        super();
        try {
            this.id = id;
            this.libros = libros;
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    /////GETTERS Y SETTERS
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
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return
     */
    public Date getfNacimiento() {
        return fNacimiento;
    }

    /**
     *
     * @param fNacimiento
     */
    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
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
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fNacimiento=" + fNacimiento + '}';
    }

}
