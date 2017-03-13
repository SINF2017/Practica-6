import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.List;
import java.util.Scanner;

/**
 * @Reference: https://globis.ethz.ch/files/2015/03/db4o-8.0-tutorial.pdf
 *
 * Exercises: 4.
 *
 */
public class ModificarElimiarObjectos {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner keyboard = new Scanner(System.in);

        //Access DB4o
        ObjectContainer db = Db4oEmbedded.
                openFile(Db4oEmbedded.newConfiguration(),"student.db4o");

        while (opcion < 5) {
            System.out.println("\n\nGestion de base de datos de peliculas.");
            System.out.println("\nSeleccione una de las siguientes opciones:");
            System.out.println("1. Añadir pelicula a la base de datos.");
            System.out.println("2. Eliminar pelicula de la base de datos.");
            System.out.println("3. Listar todas las peliculas.");
            System.out.println("4. Modificar  sus valoraciones.");
            System.out.println("5. Salir.");
            System.out.println("\nOpcion: ");
            opcion = keyboard.nextInt();
            keyboard.nextLine();

            switch (opcion){
                case 1:
                    //Añadir pelicula a la base de datos.
                    Peliculas peliculas = new Peliculas();
                    ObjectSet result = db.queryByExample(peliculas);
                    int id = result.size() + 1;
                    System.out.println("\n\n\nTitulo de la pelicula: ");
                    String titulo = keyboard.nextLine();
                    System.out.println("\n\n\nNacionalidad de la pelicula: ");
                    String nacionalidad = keyboard.nextLine();
                    System.out.println("\n\n\nValoracion de la pelicula: ");
                    Double valoracion = keyboard.nextDouble();
                    keyboard.nextLine();

                    //Añadir a bbdd
                    Peliculas peliculas1 = new Peliculas(id,titulo,nacionalidad,valoracion);
                    db.store(peliculas1);
                    break;
                case 2:
                    //Eliminar pelicula de la base de datos
                    System.out.println("Titulo de pelicula que desea eliminar de la base de datos:");
                    titulo = keyboard.nextLine();
                    result = db.queryByExample(new Peliculas(null,titulo,null,null));
                    Peliculas found = (Peliculas) result.next();
                    db.delete(found);
                    System.out.println(found.getTitulo() + " se ha borrado satisfactoriamente");
                    break;
                case 3:
                    //Listar todas las peliculas:
                    Peliculas listar = new Peliculas();
                    result = db.queryByExample(listar);
                    listResult(result);
                    break;
                case 4:
                    //Modificar sus valoraciones.
                    System.out.println("Titulo de pelicula que desea cambiar su valoracion de la base de datos:");
                    titulo = keyboard.nextLine();
                    System.out.println("Nueva valoracion: ");
                    valoracion = keyboard.nextDouble();
                    keyboard.nextLine();
                    result = db.queryByExample(new Peliculas(null,titulo,null,null));
                    found = (Peliculas) result.next();
                    found.setInteres(valoracion);
                    db.store(found);
                    System.out.println("La valoración de la pelicula " + titulo + " se ha modificado correctamente.");
                    break;
                case 5:
                    System.out.println("Saliendo del gestor... ");
                    break;
                default:
                    System.out.println("Saliendo del gestor... ");
                    break;
            }
        }

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
