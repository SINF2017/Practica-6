public class Directores {
    private int id_director;
    private int imdb;
    private int edad;
    private String nombre;
    private String nacionalidad;

    public Directores(){
    }

    public Directores(int id_director,int imdb,int edad,String nombre, String nacionalidad){
        this.id_director = id_director;
        this.imdb = imdb;
        this.edad = edad;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
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
                "\nID_director: " + id_director +
                "\nIMDB: " + imdb +
                "\nNombre: " + nombre +
                "\nEdad: " + edad +
                "\nNacionalidad: " + nacionalidad +
                "\n+--------------------------------------------------------------+";

    }
}
