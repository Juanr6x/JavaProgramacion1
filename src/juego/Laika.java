package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Laika {
	private int x, y;
	private boolean estaViva;
	private double escala = 0.04;
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

	public void moverArriba() {
		y -= velocidad;
	}

	public void moverAbajo() {
		y += velocidad;
	}

	public void moverDerecha() {
		x += velocidad;
	}

	public void moverIzquierda() {
		x -= velocidad;
	}

	public boolean colisionBola() {
		return false;
	}

	private boolean planta() {
		return false;
	}

	private RayoDestructor dispararRayo() {
		return new RayoDestructor();
	}
}
