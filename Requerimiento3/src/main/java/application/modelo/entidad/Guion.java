package application.modelo.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gonzalo Solís Campos
 */
@Entity
@Table(name = "guiones")
public class Guion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String autor;
    //------------------------------
    @OneToOne(mappedBy = "guion", cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "fk_id_pelicula", referencedColumnName = "id")
    private Pelicula pelicula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Guion{" + "id=" + id + ", autor=" + autor + ", pelicula=" + pelicula + '}';
    }
}
