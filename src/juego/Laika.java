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
		// Puedes inicializar propiedades específicas de Laika aquí si es necesario.
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

	// Método para verificar colisiones con manzanas
	public void verificarColisionesManzanas(Manzana[] manzanas) {
		int alturaImagen = (int) (escala * img.getHeight(null));
		int anchoImagen = (int) (escala * img.getWidth(null));

		for (Manzana manzana : manzanas) {
			if (this.y + alturaImagen / 2 > (manzana.getY() - manzana.getY() / 2)
					&& this.y - alturaImagen / 2 < (manzana.getY() + manzana.getY() / 2)) {
				if (this.x - anchoImagen / 2 < (manzana.getX() + manzana.getX() / 2)
						&& this.x > manzana.getX()) {
					this.x = (manzana.getX() + manzana.getX() / 2) + anchoImagen / 2;
				}
				if (this.x + anchoImagen / 2 > (manzana.getX() - manzana.getX() / 2)
						&& this.x < manzana.getX()) {
					this.x = (manzana.getX() - manzana.getX() / 2) - anchoImagen / 2;
				}
			}
			if (this.x - anchoImagen / 2 < (manzana.getX() + manzana.getX() / 2)
					&& this.x + anchoImagen / 2 > (manzana.getX() - manzana.getX() / 2)) {
				if (this.y + alturaImagen / 2 > (manzana.getY() - manzana.getY() / 2) - 5
						&& this.y < manzana.getY()) {
					this.y = (manzana.getY() - manzana.getY() / 2) - 5 - alturaImagen / 2;
				}
				if (this.y - alturaImagen / 2 < (manzana.getY() + manzana.getY() / 2) + 5
						&& this.y > manzana.getY()) {
					this.y = (manzana.getY() + manzana.getY() / 2) + 5 + alturaImagen / 2;
				}
			}
		}
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
