import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

import java.util.List;

/**
 * @Reference: https://globis.ethz.ch/files/2015/03/db4o-8.0-tutorial.pdf
 *
 * Exercises: 6.
 *
 */
public class ConsultasNQ {

    private static ObjectContainer bbdd = null;

    public static void main(String[] args) {

        //Access to DB4o
        bbdd = Db4oEmbedded.
                openFile(Db4oEmbedded.newConfiguration(), "videoclub.db4o");


        actor("a");

        //SODA:
        Query query = bbdd.query();
        query.constrain(Actores.class);
        query.descend("nombre").constrain("Jamie Dornan");
        ObjectSet result = query.execute();
        System.out.println(result.get(0));

        //Close DB40
        bbdd.close();
    }

    //Imprimir contenido de una lista:
    public static void listResult(List<Peliculas> peliculas,List<Actores> actores){
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println("Actor: " + actores.get(i).getNombre());
            System.out.println("--> " + peliculas.get(i).getTitulo());
        }
    }

    public static void actor(String nombreActor){
        List<Actores> actor = bbdd.query(new Predicate<Actores>() {
            public boolean match(Actores actores) {
                return actores.getNombre().contains(nombreActor);
            }
        });

        if (actor.size() > 0) {
            List<ActorEnPelicula> actorEnPelicula = bbdd.query(new Predicate<ActorEnPelicula>() {
                public boolean match(ActorEnPelicula actorEnPelicula) {
                    for (int i = 0; i < actor.size(); i++) {
                        if (actorEnPelicula.getActor().getId_actor() == actor.get(i).getId_actor())
                            return true;
                    }
                    return false;
                }
            });
            List<Peliculas> peliculas = bbdd.query(new Predicate<Peliculas>() {
                @Override
                public boolean match(Peliculas peliculas) {
                    for (int i = 0; i < actorEnPelicula.size(); i++) {
                        if (peliculas.getId_pelicula() == actorEnPelicula.get(i).getPelicula().getId_pelicula())
                            return true;
                    }
                    return false;
                }
            });
            listResult(peliculas,actor);
        }else
            System.out.println("No existe ningun actor");
    }

}
