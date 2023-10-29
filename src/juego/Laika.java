package juego;

import java.awt.Image;
import java.awt.Rectangle;

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

	public boolean sePuedeMover(Cuadra[] cuadras, String direccion) {
		int agregarX = 0, agregarY = 0;

		if (direccion.equals("arriba"))
			agregarY -= velocidad;
		if (direccion.equals("abajo"))
			agregarY += velocidad;
		if (direccion.equals("derecha"))
			agregarX += velocidad;
		if (direccion.equals("izquierda"))
			agregarX -= velocidad;

		for (Cuadra cuadra : cuadras) {
			Rectangle rec = new Rectangle(cuadra.getX(), cuadra.getY(), cuadra.getWidth(), cuadra.getHeight());
			Rectangle recLaika = new Rectangle(this.getX() + agregarX, this.getY() + agregarY + this.velocidad, this.width,
					this.height);
			if (rec.intersects(recLaika)) {
				return false;
			}
		}
		return true;
	}

	public void mover(Entorno e, Cuadra[] cuadras) {
		if (e.estaPresionada(e.TECLA_ARRIBA) && sePuedeMover(cuadras, "arriba")) {
			if (y <= 0)
				return;
			y -= velocidad;
		}

		if (e.estaPresionada(e.TECLA_ABAJO) && sePuedeMover(cuadras, "abajo")) {
			if (y + img.getHeight(e) * escala * 1.85 >= e.getHeight())
				return;
			y += velocidad;
		}

		if (e.estaPresionada(e.TECLA_DERECHA) && sePuedeMover(cuadras, "derecha")) {
			girarDerecha();
			if (x + img.getWidth(e) * escala * 1.90 >= e.getWidth())
				return;
			x += velocidad;
		}

		if (e.estaPresionada(e.TECLA_IZQUIERDA) && sePuedeMover(cuadras, "izquierda")) {
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

	// private RayoDestructor dispararRayo() {
	// return new RayoDestructor();
	// }
}
