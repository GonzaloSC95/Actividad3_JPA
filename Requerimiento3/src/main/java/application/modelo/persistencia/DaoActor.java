
package application.modelo.persistencia;

import application.modelo.entidad.Actor;
import application.modelo.entidad.Pelicula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gonzalo Solís Campos
 * -------------------------------------------------------- 
 * Para crear un DAO,
 * simplemente tenemos que crear una interfaz y extender de la clase
 * JpaRepository. Esta clase esta parametrizada. El primer parametro es la
 * entidad con la que vamos a trabajar; y el segundo parametro es el tipo de la
 * clave primaria.
 *
 * Con la anotacion @Repository, estamos dando de alta un objeto de este tipo en
 * el contexto de Spring.
 */
@Repository
public interface DaoActor extends JpaRepository<Actor, Integer> {
//ESTA INTERFAZ YA INCLUYE LOS METODOS DE ACCESO MAS IMPORTANTES

    //Metodo para buscar peliculas por titulo
    public List<Actor> findByNombre(String nombre);
    
    @Query("select a.peliculas from Actor a where a.nombre like ?1")
    public List <Pelicula> findAllPeliculas(String actor);
}
