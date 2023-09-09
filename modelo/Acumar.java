package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author el3be
 *
 */
public class Acumar {

	private List<Estacion> estaciones;
	private List<Medicion> mediciones;

	public Acumar() {
		this.estaciones = new ArrayList<Estacion>();
		this.mediciones = new ArrayList<Medicion>();
	}

	@Override
	public String toString() {
		return "Acumar [estaciones=" + estaciones + ", mediciones=" + mediciones + "]";
	}

	public Estacion traerEstacion(String nombre) {

		Estacion estacion = null;
		boolean estacionEncontrada = false;
		int i = 0;

		while ((i < estaciones.size()) && (!estacionEncontrada)) {

			Estacion estacionActual = estaciones.get(i);

			if (estacionActual.getNombre().equalsIgnoreCase(nombre)) {
				estacion = estacionActual;
				estacionEncontrada = true;
			}
			i++;
		}
		return estacion;
	}

	public boolean agregarEstacion(String nombre, String direccion, float latitud, float longitud, float altura)
			throws Exception {

		if (traerEstacion(nombre) != null) {
			throw new Exception(String.format("La estacion con nombre `%s` ya existe", nombre));
		}

		int id = calcularAutoIncremental();
		return estaciones.add(new Estacion(id, nombre, direccion, latitud, longitud, altura));

	}

	public boolean agregarMedicion(Estacion estacion, LocalDate fecha, LocalTime hora, float temperatura, float humedad,
			float velocidadViento, String direccionViento, float precipitacion) {

		Medicion medicion = new Medicion(estacion, fecha, hora, temperatura, humedad, velocidadViento, direccionViento,
				precipitacion);
		return mediciones.add(medicion);

	}

	public Medicion traerMedicion(Estacion estacion, LocalDate fecha, LocalTime hora) {

		Medicion medicion = null;
		boolean medicionEcontrada = false;
		int i = 0;

		while ((i < mediciones.size()) && (!medicionEcontrada)) {

			Medicion medicionActual = mediciones.get(i);

			if ((medicionActual.getEstacion().equals(estacion)) && (medicionActual.getFecha().equals(fecha))
					&& (medicionActual.getHora().equals(hora))) {
				medicion = medicionActual;
				medicionEcontrada = true;

			}
			i++;
		}
		return medicion;
	}

	public List<Medicion> traerMediciones(Estacion estacion) {

		List<Medicion> medicionesDeEstacion = new ArrayList<Medicion>();

		for (Medicion medicion : mediciones) {
			if (medicion.getEstacion().equals(estacion)) {
				medicionesDeEstacion.add(medicion);
			}
		}
		return medicionesDeEstacion;
	}

	public float promedioTemperatura(Estacion estacion, LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta) {

		List<Medicion> medicionesDeEstacion = traerMediciones(estacion);

		float sumaTemperaturas = 0f;
		int cantidadTemperaturas = 0;

		for (Medicion medicion : medicionesDeEstacion) {

			if ((medicion.getHora().equals(horaDesde))
					|| (medicion.getHora().isAfter(horaDesde)) && (medicion.getHora().isBefore(horaHasta))
					|| (medicion.getHora().equals(horaHasta))) {

				sumaTemperaturas += medicion.getTemperatura();
				cantidadTemperaturas++;
			}
		}
		return (float) sumaTemperaturas / (float) cantidadTemperaturas;
	}

	public int calcularAutoIncremental() {
		if (estaciones.isEmpty()) {
			return 1;
		}
		return estaciones.get(this.estaciones.size() - 1).getId() + 1;
	}

}
