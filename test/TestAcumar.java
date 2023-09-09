package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Acumar;
import modelo.Estacion;

public class TestAcumar {

	public static void main(String[] args) {

		Acumar a = new Acumar();

		System.out.println("Test 1");
		try {
			a.agregarEstacion("Lanus", "Carlos Casaresa 2000", -34.7f, -58.4f, 100f);
			System.out.println(a);
			a.agregarEstacion("Avellaneda", "Av. Manuel Belgrano 2800", -34.681667f, -58.349722f, 200f);
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 2");
		try {
			System.out.println(a.traerEstacion("Lanus"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 3");
		try {
			a.agregarEstacion("Lanus", "Carlos Casaresa 2000", -34.7f, -58.4f, 100f);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 4");
		try {

			Estacion lanus = a.traerEstacion("Lanus");
			Estacion avellaneda = a.traerEstacion("Avellaneda");

			a.agregarMedicion(lanus, LocalDate.of(2022, 9, 1), LocalTime.of(14, 0), 17.6f, 49f, 9.7f, "E", 0f);
			a.agregarMedicion(lanus, LocalDate.of(2022, 9, 1), LocalTime.of(13, 0), 18.4f, 45f, 6.2f, "SE", 0f);
			a.agregarMedicion(lanus, LocalDate.of(2022, 9, 1), LocalTime.of(16, 0), 19f, 39f, 7.3f, "S", 0f);

			a.agregarMedicion(avellaneda, LocalDate.of(2022, 9, 1), LocalTime.of(15, 0), 18.8f, 42.0f, 6.8f, "S", 0f);

			System.out.println(a);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 5");
		try {
			Estacion avellaneda = a.traerEstacion("Avellaneda");
			System.out.println(a.traerMediciones(avellaneda));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 6");
		try {
			Estacion lanus = a.traerEstacion("Lanus");
			System.out.println(
					a.promedioTemperatura(lanus, LocalDate.of(22, 9, 1), LocalTime.of(12, 0), LocalTime.of(15, 30)));

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 7");
		try {
			Estacion lanus = a.traerEstacion("Lanus");
			Estacion avellaneda = a.traerEstacion("Avellaneda");
			System.out.println(lanus.distanciaConEstacion(avellaneda));

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 8");
		try {
			Estacion lanus = a.traerEstacion("Lanus");
			System.out.println(a.traerMedicion(lanus, LocalDate.of(2022, 9, 1), LocalTime.of(16, 0))
					.temperaturaCorregidaPorAltura());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
