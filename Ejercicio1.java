import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ext.DatabaseClosedException;

// http://www.odbms.org/wp-content/uploads/2013/11/db4o-7.10-tutorial-java.pdf

public class Ejercicio1 {
	
	private static ObjectContainer db;

	public static void main(String[] args) {

		/*
		 * Configuration config = Db4o.configure(); 
		 * ObjectContainer db = Db4o.openFile(config,"student.db4o"); 
		 * db.close();
		 */

		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DB_p6");

		Peliculas peli = new Peliculas(0, "El rey Leon", "Africana", 4.9f);
		almacenar_pelicula(peli);
		peli = new Peliculas(1, "Mulan", "China", 5.0f);
		almacenar_pelicula(peli);

		db.close();
	}
	
	public static void almacenar_pelicula (Peliculas peli){
		try {
			db.store(peli);
			System.out.println("Almacenada en la BD: " + peli.toString());
		} catch (DatabaseClosedException e) {
			System.out.println("Se ha producido un error introduciendo: " + peli.toString());
		}
	}
}
