package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Laika {
	private int x, y;
	// private boolean estaViva;
	private double escala = 0.037;
	private int velocidad = 3;
	private Image img = Herramientas.cargarImagen("imagenes/Laika.png");

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// Constructor de Laika
	public Laika() {

	}

	public void dibujarse(Entorno e) {
		e.dibujarImagen(img, x + 30, y + 30, 0, escala);
	}

	// Movimientos de Laika

	public void mover(Entorno e) {
		if (e.estaPresionada(e.TECLA_ARRIBA))
			moverArriba(e);
		if (e.estaPresionada(e.TECLA_ABAJO))
			moverAbajo(e);
		if (e.estaPresionada(e.TECLA_DERECHA))
			moverDerecha(e);
		if (e.estaPresionada(e.TECLA_IZQUIERDA))
			moverIzquierda(e);
	}

	public void moverArriba(Entorno e) {
		if (y <= 0)
			return;
		y -= velocidad;
	}

	public void moverAbajo(Entorno e) {
		if (y + img.getHeight(e) * escala * 1.85 >= e.getHeight())
			return;
		y += velocidad;
	}

	public void moverDerecha(Entorno e) {
		girarDerecha();
		if (x + img.getWidth(e) * escala * 1.90 >= e.getWidth())
			return;

		x += velocidad;
	}

	public void moverIzquierda(Entorno e) {
		girarIzquierda();
		if (x < 0)
			return;
		x -= velocidad;
	}

	// cambio de imagen de laika dependiendo de la direccion
	public void girarDerecha() {
		this.img = Herramientas.cargarImagen("imagenes/Laika.png");
	}

	public void girarIzquierda() {
		this.img = Herramientas.cargarImagen("imagenes/Laika_izq.png");
	}

	public boolean colisionBola() {
		return false;
	}

	// private boolean planta() {
	// return false;
	// }

	// private RayoDestructor dispararRayo() {
	// return new RayoDestructor();
	// }
}
