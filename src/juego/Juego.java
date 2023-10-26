package juego;

import java.awt.Point;

import entorno.Entorno;
import entorno.InterfaceJuego;
import entorno.Menu;
import entorno.Herramientas;

public class Juego extends InterfaceJuego {
	private Entorno entorno;
	private int width = 800;
	private int height = 600;
	private Calle calle;
	private Laika laika = new Laika();

	Juego() {
		this.entorno = new Entorno(this, "Attack on Titan, Final Season - Grupo ... - v1", width, height);
		this.calle = new Calle();
		this.entorno.iniciar();
	}

	public void tick() {
		this.calle.dibujarse(entorno);
		this.laika.dibujarse(entorno);
		Utilidades.escucharTecla(entorno, laika);
		Utilidades.imprimirCoordenadas(laika);
	}

	@SuppressWarnings("unused")

	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}