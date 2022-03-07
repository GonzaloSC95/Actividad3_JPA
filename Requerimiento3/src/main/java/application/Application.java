package application;

import application.modelo.entidad.Actor;
import application.modelo.entidad.Estudio;
import application.modelo.entidad.Guion;
import application.modelo.entidad.Pelicula;
import application.modelo.persistencia.DaoActor;
import application.modelo.persistencia.DaoEstudio;
import application.modelo.persistencia.DaoGuion;
import application.modelo.persistencia.DaoPelicula;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private DaoPelicula daoPelicula;
    @Autowired
    private DaoActor daoActor;
    @Autowired
    private DaoEstudio daoEstudio;
    @Autowired
    private DaoGuion daoGuion;

    //SCHEMA jpa_peliculas
    public static void main(String[] args) {
        createSchema();
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            //--PELICULAS-------------------
            ArrayList<Pelicula> peliculas = new ArrayList();
            //--------------------------------
            Pelicula pBatman = new Pelicula();
            pBatman.setTitulo("The Batman");
            pBatman.setfEstreno(new SimpleDateFormat("dd-MM-yyyy").parse("04-03-2022"));
            //-----------------------------------------------
            Pelicula pJoker = new Pelicula();
            pJoker.setTitulo("Joker");
            pJoker.setfEstreno(new SimpleDateFormat("dd-MM-yyyy").parse("04-10-2019"));
            //------------------------------------
            peliculas.add(pJoker);
            peliculas.add(pBatman);
            /////////////////////////////////////////////////////
            ////////////////////////////////////////////////////
            Estudio estudio = new Estudio();
            estudio.setNombre("Warner Bros");
            estudio.setPeliculas(peliculas);
            pBatman.setEstudio(estudio);
            pJoker.setEstudio(estudio);
            //////////////////////////////////////////////////////
            //////////////////////////////////////////////////////
            ArrayList<Actor> actoresB = new ArrayList();
            ArrayList<Actor> actoresJ = new ArrayList();
            //-------------------------------------------------
            Actor patinson = new Actor();
            patinson.setNombre("Robert Pattinson");
            patinson.setfNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("13-05-1986"));
            Actor fenix = new Actor();
            fenix.setNombre("Joaquin Phoenix");
            fenix.setfNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("28-10-1974"));
            Actor alfred = new Actor();
            alfred.setNombre("Alfred");
            alfred.setfNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1965"));
            //------------------------------------------
            actoresB.add(patinson);
            actoresB.add(alfred);
            //--------------------------------------
            actoresJ.add(fenix);
            actoresJ.add(alfred);
            //----------------------------
            pBatman.setActores(actoresB);
            pJoker.setActores(actoresJ);
            //////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////
            Guion gBatman = new Guion();
            gBatman.setAutor("Todd Phillips");
            gBatman.setPelicula(pBatman);
            pBatman.setGuion(gBatman);
            Guion gJoker = new Guion();
            gJoker.setAutor("Matt Reeves");
            gJoker.setPelicula(pJoker);
            pJoker.setGuion(gJoker);

            //-----------------------------------
            daoPelicula.saveAll(peliculas);
            //-----------------------------------
            System.out.println("----------Peliculas guardadas------------");
            //-----------------------------------------
            List<Pelicula> pelis = null;
            //--------------------------------------
            System.out.println("----------PELICULAS POR ORDEN ASCENDENTE------------");
            pelis = daoPelicula.findAllByOrderByTituloAsc();
            for (Pelicula peli : pelis) {
                System.out.println("Pelicula "
                        + peli.getId() + " --> " + peli);
            }
            //------------------------------------------
            System.out.println("------------PELICULAS DE WARNER BROS------------");
            pelis = daoPelicula.findByEstudio("Warner Bros");
            for (Pelicula peli : pelis) {
                System.out.println("Pelicula "
                        + peli.getId() + " --> " + peli);
            }
            //----------------------------------------------
            System.out.println("------------PELICULAS DE TODOS LOS ESTUDIOS------------");
            pelis = daoEstudio.findAllPeliculas();
            for (Pelicula peli : pelis) {
                System.out.println("Pelicula "
                        + peli.getId() + " --> " + peli);
            }
            //----------------------------------------------
            System.out.println("------------PELICULAS DE JOAQUIN PHOENIX------------");
            pelis = daoActor.findAllPeliculas("Joaquin Phoenix");
            for (Pelicula peli : pelis) {
                System.out.println("Pelicula "
                        + peli.getId() + " --> " + peli);
            }
            //----------------------------------------------
            System.out.println("------------AUTOR DEL GUION DE The Batman------------");
            String autor = daoGuion.findAutorOfGuion("The Batman");
            System.out.println("Autor --> " + autor);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }

    public static void createSchema() {
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String password = "";
        try (Connection conexion = DriverManager.getConnection(url, usuario, password);){
            //-----------------------
            PreparedStatement sentencia = conexion.prepareStatement("CREATE SCHEMA JPA_PELICULAS");
            int sentenciasEjecutadas = sentencia.executeUpdate();
            System.out.println("Sentencia CREATE SCHEMA JPA_PELICULAS ejecutada "
                    +sentenciasEjecutadas+" vez.");
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getLocalizedMessage());
        }
    }
}
