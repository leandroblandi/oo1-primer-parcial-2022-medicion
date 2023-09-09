package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Medicion {

	private Estacion estacion;
	private LocalDate fecha;
	private LocalTime hora;
	private float temperatura;
	private float humedad;
	private float velocidadViento;
	private String direccionViento;
	private float precipitacion;

	public Medicion(Estacion estacion, LocalDate fecha, LocalTime hora, float temperatura, float humedad,
			float velocidadViento, String direccionViento, float precipitacion) {
		this.setEstacion(estacion);
		this.setFecha(fecha);
		this.setHora(hora);
		this.setTemperatura(temperatura);
		this.setHumedad(humedad);
		this.setVelocidadViento(velocidadViento);
		this.setDireccionViento(direccionViento);
		this.setPrecipitacion(precipitacion);
	}

	public float temperaturaCorregidaPorAltura() {
		return (temperatura + (estacion.getAltura() * 6.5f) / 1000f);
	}

	@Override
	public String toString() {
		return "\nMedicion [estacion=" + estacion + ", \n\tfecha=" + fecha + ", \n\thora=" + hora + ", \n\ttemperatura="
				+ temperatura + ", \n\thumedad=" + humedad + ", \n\tvelocidadViento=" + velocidadViento
				+ ", \n\tdireccionViento=" + direccionViento + ", \n\tprecipitacion=" + precipitacion + "]";
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public float getHumedad() {
		return humedad;
	}

	public void setHumedad(float humedad) {
		this.humedad = humedad;
	}

	public float getVelocidadViento() {
		return velocidadViento;
	}

	public void setVelocidadViento(float velocidadViento) {
		this.velocidadViento = velocidadViento;
	}

	public String getDireccionViento() {
		return direccionViento;
	}

	public void setDireccionViento(String direccionViento) {
		this.direccionViento = direccionViento;
	}

	public float getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(float precipitacion) {
		this.precipitacion = precipitacion;
	}
}
