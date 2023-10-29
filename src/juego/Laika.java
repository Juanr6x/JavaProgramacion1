package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Laika {
	private int x, y;
	// private boolean estaViva;
	private int height;
	private int width;
	private double escala = 0.037;
	private int velocidad = 3;
	private Image img = Herramientas.cargarImagen("imagenes/Laika.png");;

	// Constructor de Laika
	public Laika() {
		this.width = (int) (img.getWidth(null) * escala);
		this.height = (int) (img.getHeight(null) * escala);
	}

	public void dibujarse(Entorno e) {
		e.dibujarImagenConCentro(img, x, y, 0, 0, 0, escala);
	}

	public void mover(Entorno e, Cuadra[] cuadras) {
		if (e.estaPresionada(e.TECLA_ARRIBA) && Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_ARRIBA)) {
			if (y <= 0)
				return;
			y -= velocidad;
		}

		if (e.estaPresionada(e.TECLA_ABAJO) && Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_ABAJO)) {
			if (y + img.getHeight(e) * escala * 1.85 >= e.getHeight())
				return;
			y += velocidad;
		}

		if (e.estaPresionada(e.TECLA_DERECHA) && Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_DERECHA)) {
			girarDerecha();
			if (x + img.getWidth(e) * escala * 1.90 >= e.getWidth())
				return;
			x += velocidad;
		}

		if (e.estaPresionada(e.TECLA_IZQUIERDA) && Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_IZQUIERDA)) {
			girarIzquierda();
			if (x < 0)
				return;
			x -= velocidad;
		}
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getVelocidad() {
		return velocidad;
	}

	// private RayoDestructor dispararRayo() {
	// return new RayoDestructor();
	// }
}
