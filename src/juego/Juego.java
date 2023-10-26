
package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.InterfaceJuego;
import entorno.Menu;
import entorno.Herramientas;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Image fondo;
	private Laika laika = new Laika();
	private Calle calle;
	private int width = 800;
	private int height = 600;

	Juego() {

		this.entorno = new Entorno(this, "Attack on Titan, Final Season - Grupo ... - v1", width, height);
		this.calle = new Calle(width, height);
		this.entorno.iniciar();

	}

	public void tick() {

		// calle.verificarColisionesLaika(laika);
		this.calle.dibujarse(entorno);
		this.laika.dibujarse(entorno);
		System.out.println("x = " + this.laika.getX());
		System.out.println("y = " + this.laika.getY());

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

	@SuppressWarnings("unused")

	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
