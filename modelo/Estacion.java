package modelo;

public class Estacion {

	private int id;
	private String nombre;
	private String direccion;
	private double latitud;
	private double longitud;
	private float altura;

	public Estacion(int id, String nombre, String direccion, double latitud, double longitud, float altura) {
		this.setId(id);
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.setAltura(altura);
	}

	public double distanciaConEstacion(Estacion estacion) {
		double primerTermino = Math.pow(estacion.getLongitud() - this.longitud, 2);
		double segundoTermino = Math.pow(estacion.getLatitud() - this.latitud, 2);
		return (Math.sqrt(primerTermino + segundoTermino) * 100);
	}

	@Override
	public String toString() {
		return "\nEstacion [id=" + id + ", \n\tnombre=" + nombre + ", \n\tdireccion=" + direccion + ", \n\tlatitud="
				+ latitud + ", \n\tlongitud=" + longitud + ", \n\taltura=" + altura + "]";
	}

	public boolean equals(Estacion estacion) {
		return (this.id == estacion.getId()) && (this.nombre == estacion.getNombre());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
}
