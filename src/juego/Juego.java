package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;
// import entorno.Menu;
// import entorno.Herramientas;

public class Juego extends InterfaceJuego {
	private Entorno entorno;
	private int width = 1200;
	private int height = 300;
	private Calle calle;
	private Laika laika = new Laika();
	private Auto[] autos;
	private Planta[] plantas;
	private Cuadra[] cuadras;

	Juego() {
		// Inicio del juego
		this.entorno = new Entorno(this, "Attack on Titan, Final Season - Grupo ... - v1", width, height);

		// toda la logica del juego
		// está dentro de la clase Calle
		this.calle = new Calle();
		this.cuadras = this.calle.getCuadras();
		this.autos = this.calle.getAutos();
		this.plantas = this.calle.getPlantas();
		this.entorno.iniciar();
	}

	public void tick() {
		// Dibuja en pantalla
		this.calle.dibujarse(entorno);
		this.laika.dibujarse(entorno);

		// Mueve a Laika
		this.laika.mover(entorno, this.calle.getCuadras());
		this.laika.isViva();
		Auto.moverAutos(autos);
		Planta.moverPlantas(entorno, cuadras, plantas);
	}

	@SuppressWarnings("unused")

	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
