public class ActorEnPelicula {
    private Actores actor;
    private Peliculas pelicula;

    ActorEnPelicula(){

    }

    ActorEnPelicula(Actores actor, Peliculas pelicula){
        this.actor = actor;
        this.pelicula = pelicula;
    }


    public Actores getActor() {
        return actor;
    }

    public void setActor(Actores actor) {
        this.actor = actor;
    }

    public Peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
    }

    public String toString() {
        return "+--------------------------------------------------------------+" +
                "\nNombre del actor: " + actor.getNombre() +
                "\n Nombre de la pelicula: " + pelicula.getTitulo() +
                "+--------------------------------------------------------------+";

    }
}
