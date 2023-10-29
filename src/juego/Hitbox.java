package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;
import entorno.Herramientas;

public class Hitbox {
	private Rectangle box;

	private Image img = Herramientas.cargarImagen("imagenes/hitbox.jpg");

	public Hitbox(boolean estaViva, int x, int y, int width, int height) {
		this.box = new Rectangle(x, y, width, height);
	}

	public void mover(int x, int y) {
		box.setLocation(x, y);
	}

	public void dibujar(Entorno e) {
		e.dibujarImagenConCentro(img, box.getX(), box.getY(), 0, 0, 0, 1);
	}

}