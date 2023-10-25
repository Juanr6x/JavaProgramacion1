package juego;

import entorno.Herramientas;
import java.awt.Image;
import entorno.Entorno;

public class Manzana {
	private Image imagen;
	private int x;
	private int y;
	private int numeroDeCalle;

	public Manzana(Image imagen, int x, int y, int numeroDeCalle) {
		this.imagen = imagen;
		this.x = x;
		this.y = y;
		this.numeroDeCalle = numeroDeCalle;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void dibujar(Entorno e) {
		e.dibujarImagen(imagen, x, y, 0, 0.75);
	}
}