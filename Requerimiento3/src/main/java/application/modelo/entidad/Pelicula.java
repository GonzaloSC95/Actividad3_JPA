package application.modelo.entidad;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gonzalo Solís Campos
 */
@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    @Temporal(TemporalType.DATE)
    private Date fEstreno;
    //------------MANY TO MANY------------------------
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "actor_pelicula",
            joinColumns = @JoinColumn(name = "fk_id_pelicula", referencedColumnName = "id"), //FK que aporta Libro
            inverseJoinColumns = @JoinColumn(name = "fk_id_autor", referencedColumnName = "id")) //FKs que aportan el resto de entidades
    private List<Actor> actores;
    //-------------MANY TO ONE--------------------------------
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_id_estudio", referencedColumnName = "id")
    private Estudio estudio;
    //------------ONE TO ONE----------------------------------
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_guion", referencedColumnName = "id")
    private Guion guion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Guion getGuion() {
        return guion;
    }

    public void setGuion(Guion guion) {
        this.guion = guion;
    }

    public Date getfEstreno() {
        return fEstreno;
    }

    public void setfEstreno(Date fEstreno) {
        this.fEstreno = fEstreno;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", titulo=" + titulo + '}';
    }

}
