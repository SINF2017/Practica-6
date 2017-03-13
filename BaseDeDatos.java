import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * @Reference: https://globis.ethz.ch/files/2015/03/db4o-8.0-tutorial.pdf
 *
 * Exercises: 5.
 *
 */
public class BaseDeDatos {

    public static void main(String[] args) {

        //Access to DB4o
        ObjectContainer bbdd = Db4oEmbedded.
                openFile(Db4oEmbedded.newConfiguration(), "videoclub.db4o");

        //Create objects:
        Directores fordCoppola = new Directores(1, 338, 77,
                "Francis Ford Coppola", "Estados Unidos");
        Directores samTaylor = new Directores(2, 853374, 49,
                "Sam Taylor-Johnson", "Reino Unido");
        Actores marlonBrando = new Actores(1, 8, 93,
                "Malon Brando", "Estados Unidos");
        Actores dornan = new Actores(2, 1946193, 34,
                "Jamie Dornan", "Estados Unidos");
        Peliculas elPadrino = new Peliculas(1, 68646, fordCoppola, "El padrino",
                "Estados Unidos", 8.96);
        Peliculas csdg = new Peliculas(2, 2322441, samTaylor, "Cincuenta sombras de Grey",
                "Estados Unidos", 6.52);
        ActorEnPelicula actorEnPelicula1 = new ActorEnPelicula(marlonBrando, elPadrino);
        ActorEnPelicula actorEnPelicula2 = new ActorEnPelicula(dornan, csdg);


        //Store objects in DB.
        bbdd.store(fordCoppola);
        bbdd.store(samTaylor);
        bbdd.store(marlonBrando);
        bbdd.store(dornan);
        bbdd.store(elPadrino);
        bbdd.store(csdg);
        bbdd.store(actorEnPelicula1);
        bbdd.store(actorEnPelicula2);

        //Close DB40
        bbdd.close();
    }

}
