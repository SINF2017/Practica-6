public class Actores {
    private int id_actor;
    private int imdb;
    private int edad;
    private String nombre;
    private String nacionalidad;

    public Actores(){}

    public Actores(int id_actor, int imdb, int edad, String nombre, String nacionalidad){
        this.id_actor = id_actor;
        this.imdb = imdb;
        this.edad = edad;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }


    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    public int getImdb() {
        return imdb;
    }

    public void setImdb(int imdb) {
        this.imdb = imdb;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String toString() {
        return "+--------------------------------------------------------------+" +
                "\nID_actor: " + id_actor +
                "\nIMDB: " + imdb +
                "\nNombre: " + nombre +
                "\nEdad: " + edad +
                "\nNacionalidad: " + nacionalidad +
                "\n+--------------------------------------------------------------+";

    }
}
