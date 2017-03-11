
public class Peliculas {
	private int id;
	private String titulo;
	private String nacionalidad;
	private float interes;
	
	public Peliculas(int id,String titulo,String nacionalidad, float interes){
		this.id = id;
		this.titulo = titulo;
		this.nacionalidad = nacionalidad;
		this.interes = interes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public float getInteres() {
		return interes;
	}
	public void setInteres(float interes) {
		if(interes > 5 || interes < 0){
			System.out.println("Error. El valor de interes tiene que estar comprendido entre 0.0 y 5.5.\nSe seguira usando su atiguo valor.");
		}else
			this.interes = interes;
	}

	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", titulo=" + titulo + ", nacionalidad=" + nacionalidad + ", interes=" + interes
				+ "]";
	}
}
