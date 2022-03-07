package application.modelo.persistencia;

import application.modelo.entidad.Pelicula;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gonzalo Solís Campos
 * -------------------------------------------------------- Para crear un DAO,
 * simplemente tenemos que crear una interfaz y extender de la clase
 * JpaRepository. Esta clase esta parametrizada. El primer parametro es la
 * entidad con la que vamos a trabajar; y el segundo parametro es el tipo de la
 * clave primaria.
 *
 * Con la anotacion @Repository, estamos dando de alta un objeto de este tipo en
 * el contexto de Spring.
 */
@Repository
public interface DaoPelicula extends JpaRepository<Pelicula, Integer> {
//ESTA INTERFAZ YA INCLUYE LOS METODOS DE ACCESO MAS IMPORTANTES

    //Metodo para buscar peliculas por titulo
    public List<Pelicula> findByTitulo(String titulo);
    
    public List<Pelicula> findByEstudio(int id);

    //Adminte operadores logicos "And" y "Or" entre atributos
    //public List<Pelicula> findByTituloAndOtroAtributo(String titulo, String OtroAtributo);

    //"findAll" devolvera todas las peliculas
    //Poniendo "By" podemos poner otras condiciones
    //"OrderBy" ordena por un atributo
    //Tambien podemos poner "Asc" o "Desc" al final para ordenar en orden
    //ascendente o descendente
    public List<Pelicula> findAllByOrderByTituloAsc();

    public List<Pelicula> findAllByOrderByTituloDesc();

    //Para buscar cadenas que contengan el titulo podemos
    //usar la palabra "Containing"
    public List<Pelicula> findByTituloContaining(String titulo);

    //public List<Pelicula> findByTituloAndOtroAtributoContaining(String titulo, String genero);

    //Si queremos que busquedas por cadenas ignorando mayusculas y minusculas
    //podemos usar la palabra "IgnoreCase"
    public List<Pelicula> findByTituloIgnoreCase(String titulo);

    //public List<Pelicula> findByTituloAndOtroAtributoIgnoreCase(String titulo, String genero);

    //Buscar por cadenas que contanga el titulo
    //sin importar que sean mayusculas y minusculas
    public List<Pelicula> findByTituloIgnoreCaseContaining(String titulo);

    //public List<Pelicula> findByTituloAndOtroAtributoIgnoreCaseContaining(String titulo, String genero);

    //JPQL
    @Query("select p from Pelicula p where p.estudio.nombre=?1")
    public List<Pelicula> findByEstudio(String estudio);
}
