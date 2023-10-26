
package juego;

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
		Utilidades.coordenadas(laika);
	}

	@SuppressWarnings("unused")

	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}

class Utilidades {

	static void escucharTecla(Entorno entorno, Laika laika) {
		if (entorno.estaPresionada(entorno.TECLA_DERECHA) || entorno.estaPresionada('l')) {
			laika.moverDerecha();
		}
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) || entorno.estaPresionada('h')) {
			laika.moverIzquierda();
		}
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA) || entorno.estaPresionada('k')) {
			laika.moverArriba();
		}
		if (entorno.estaPresionada(entorno.TECLA_ABAJO) || entorno.estaPresionada('k')) {
			laika.moverAbajo();
		}
	}

	static void coordenadas(Laika laika) {
		System.out.println("x = " + laika.getX());
		System.out.println("y = " + laika.getY());
	}

}
