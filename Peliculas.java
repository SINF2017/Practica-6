public class Peliculas {
    private int id_pelicula;
    private int imdb;
    private Directores director;
    private String titulo;
    private String nacionalidad;
    private Double valoración;

    public Peliculas(){
    }

    public Peliculas(int id_pelicula, int imdb, Directores director,
                     String titulo, String nacionalidad, Double valoración){
        this.id_pelicula = id_pelicula;
        this.imdb = imdb;
        this.director = director;
        this.titulo = titulo;
        this.nacionalidad = nacionalidad;
        this.valoración = valoración;
    }


    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getImdb() {
        return imdb;
    }

    public void setImdb(int imdb) {
        this.imdb = imdb;
    }

    public Directores getId_director() {
        return director;
    }

    public void setId_director(Directores director) {
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Double getValoración() {
        return valoración;
    }

    public void setValoración(Double valoración) {
        this.valoración = valoración;
    }

    public String toString(){
        return "+--------------------------------------------------------------+" +
                "\nID_pelicula: " + id_pelicula +
                "\nIMDB: " + imdb +
                "\nTitulo: " + titulo+
                "\nNacionalidad: " + nacionalidad +
                "\nValoración: " + valoración +
                "\n+--------------------------------------------------------------+";

    }
}
