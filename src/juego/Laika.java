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

	public void chocaConCuadra(Entorno e, Cuadra[] cuadras) {

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// Constructor de Laika
	public Laika() {
		this.width = (int) (img.getWidth(null) * escala);
		this.height = (int) (img.getHeight(null) * escala);
	}

	public void dibujarse(Entorno e) {
		e.dibujarImagenConCentro(img, x, y, 0, 0, 0, escala);
	}

	// Movimientos de Laika

	public void mover(Entorno e, Cuadra[] cuadras) {
		for (Cuadra cuadra : cuadras) {

			Rectangle rec = new Rectangle(cuadra.getX(), cuadra.getY(), cuadra.getWidth(), cuadra.getHeight());
			Rectangle recLaika = new Rectangle(this.getX(), this.getY(), this.width, this.height);
			e.dibujarImagenConCentro(img, x, y, 0, 0, 0, escala);
			if (rec.intersects(recLaika)) {
				System.out.println("choca laika");
				this.x -= velocidad;
				this.y -= velocidad;
				return;
			}
		}
		if (e.estaPresionada(e.TECLA_ARRIBA))
			// if(!colisionCuadra())
			moverArriba(e);
		if (e.estaPresionada(e.TECLA_ABAJO))
			// if(!colisionCuadra())
			moverAbajo(e);
		if (e.estaPresionada(e.TECLA_DERECHA))
			// if(!colisionCuadra())
			moverDerecha(e);
		if (e.estaPresionada(e.TECLA_IZQUIERDA))
			// if(!colisionCuadra())
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
	// public boolean colisionCuadra() {
	// for (int i = 0; i < cuadras.length; i++) {
	// if(this.x + this.ancho /2 > cuadras[i].getX() - cuadras[i].getAncho()/2 &&
	// this.x - this.ancho/2<cuadras[i].getX() + cuadras[i].getAncho() /2 &&
	// this.y + this.alto/2 > cuadras[i].getY() - cuadras[i].getAlto()/2 &&
	// this.y -this.alto/2 < cuadras[i].getY() + cuadras[i].getAlto()/2
	// )
	// return true;
	// }
	// return false;

	// }

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	// public void setCuadras( Cuadra cuadra[] ) {
	// cuadras = cuadra;
	// }
	// private boolean planta() {
	// return false;
	// }

	// private RayoDestructor dispararRayo() {
	// return new RayoDestructor();
	// }
}
