import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;

// http://www.odbms.org/wp-content/uploads/2013/11/db4o-7.10-tutorial-java.pdf

public class Ejercicio4 {
	
	private static ObjectContainer db;

	public static void main(String[] args) {
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DB_p6");
		/*
		Peliculas peli = new Peliculas(0, "El rey Leon", "Africana", 4.9f);
		almacenar_pelicula(peli);
		peli = new Peliculas(1, "Mulan", "China", 5.0f);
		almacenar_pelicula(peli);
		
		recuperar_peliculas(null);
		recuperar_peliculas_por_nacionalidad("Africana");
		eliminar_pelicula(peli);
		*/
		
		actualizar_pelicula(new Peliculas(1, "Mulan", "China", 5.0f), new Peliculas(1, "Mulan", "China", 4.9f));
		
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
	
	public static void eliminar_pelicula(Peliculas peli){
		ObjectSet result = db.queryByExample(peli);
		if(result.isEmpty()){
			System.out.println("No existe la pelicula que se desea borrar en la base de datos.");
			recuperar_peliculas(null);
			return;
		}
		Peliculas encontrado = (Peliculas) result.next();
		db.delete(encontrado);
		System.out.println("Eliminada: " + encontrado);
		recuperar_peliculas(null);
	}
	
	public static void actualizar_pelicula (Peliculas peliVieja, Peliculas peliNueva){
			ObjectSet result = db.queryByExample(peliVieja);
			if(result.isEmpty()){
				System.out.println("No existe la pelicula que se desea actualizar en la base de datos.");
				recuperar_peliculas(null);
				return;
			}
			Peliculas found = (Peliculas) result.next();
			found.setId(peliNueva.getId());
			found.setInteres(peliNueva.getInteres());
			found.setNacionalidad(peliNueva.getNacionalidad());
			found.setTitulo(peliNueva.getTitulo());
			db.store(found);
			System.out.println("Pelicula actualizada:" + found);
			recuperar_peliculas(null);
	}
	
	public static void listar_resultados(ObjectSet result) {
		System.out.println("Numero de entradas en la base de datos: " + result.size());
		int i = 0;
		while (result.hasNext()) {
			i++;
			System.out.println(i +".- " + result.next());
		}
	}
}
