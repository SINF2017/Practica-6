import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.List;

/**
 * @Reference: https://globis.ethz.ch/files/2015/03/db4o-8.0-tutorial.pdf
 *
 * Exercises: 2 & 3.
 *
 */

public class ConsultaBaseDatos {

    public static void main(String[] args) {
        //Access DB4o
        ObjectContainer db = Db4oEmbedded.
                openFile(Db4oEmbedded.newConfiguration(),"student.db4o");

        //Consultar todas las peliculas:
        System.out.println("Todas las peliculas del sistema: ");
        Peliculas peliculas = new Peliculas();
        ObjectSet result = db.queryByExample(peliculas);
        listResult(result);

        //Consultar una pelicula expecifica.
        System.out.println("\n\nPeliculas españolas: ");
        Peliculas peliculasSpa = new Peliculas(null,null,"España",null);
        ObjectSet resultSpa = db.queryByExample(peliculasSpa);
        listResult(resultSpa);

        //Close DB40
        db.close();

    }

    //Imprimir contenido de una lista:
    public static void listResult(List<?> result){
        for (Object o : result) {
            System.out.println(o);
        }
    }

}
