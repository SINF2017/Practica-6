import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * @Reference: https://globis.ethz.ch/files/2015/03/db4o-8.0-tutorial.pdf
 *
 * Exercise: 1.
 *
 */
public class CrearBaseDatos {

    public static void main(String[] args) {
        //Access DB4o
        ObjectContainer db = Db4oEmbedded.
                openFile(Db4oEmbedded.newConfiguration(),"student.db4o");

        //Create objects Peliculas.
        Peliculas pelicula1 = new Peliculas(1,"La La Land","Estados Unidos",5.0);
        Peliculas pelicula2 = new Peliculas(2,"Origen","Estados Unidos",4.6);
        Peliculas pelicula3 = new Peliculas(3,"Logan","Estados Unidos",5.0);
        Peliculas pelicula4 = new Peliculas(4,"Titanic","Estados Unidos",4.0);
        Peliculas pelicula5 = new Peliculas(5,"Celda 211","España",3.0);

        //Store objects in db.
        db.store(pelicula1);
        db.store(pelicula2);
        db.store(pelicula3);
        db.store(pelicula4);
        db.store(pelicula5);

        //Close DB40
        db.close();
    }
}
