import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;

// http://www.odbms.org/wp-content/uploads/2013/11/db4o-7.10-tutorial-java.pdf

public class Ejercicio3 {
	
	private static ObjectContainer db;

	public static void main(String[] args) {
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DB_p6");

		/*
		Peliculas peli = new Peliculas(0, "El rey Leon", "Africana", 4.9f);
		almacenar_pelicula(peli);
		peli = new Peliculas(1, "Mulan", "China", 5.0f);
		almacenar_pelicula(peli);
		
		recuperar_peliculas(null);
		*/

		recuperar_peliculas_por_nacionalidad("Africana");
		
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
	
	public static void recuperar_peliculas (Peliculas peli){
		if(peli == null){
			ObjectSet result = db.queryByExample(Peliculas.class);
			listar_resultados(result);
		}else{
			ObjectSet result = db.queryByExample(peli);
			listar_resultados(result);
		}
	}

	public static void recuperar_peliculas_por_nacionalidad (String nacionalidad){
		ObjectSet result = db.queryByExample(new Peliculas(0, null, nacionalidad, 0));
		listar_resultados(result);
	}
	
	public static void listar_resultados(ObjectSet result) {
		System.out.println("Numero de resultados: " + result.size());
		int i = 0;
		while (result.hasNext()) {
			i++;
			System.out.println(i +".- " + result.next());
		}
	}
}
