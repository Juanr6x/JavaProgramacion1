package juego;

import java.awt.Color;
import java.awt.Rectangle;

import entorno.Entorno;

public class Hitbox {
	private Rectangle box;

	public Hitbox(boolean estaViva, int x, int y, int width, int height) {
		this.box = new Rectangle(x, y, width, height);
	}

	public void mover(int x, int y) {
		box.setLocation(x, y);
	}

	public boolean colisiona(Hitbox otro) {
		return this.box.intersects(otro.box);
	}

	public void dibujar(Entorno e) {
		e.dibujarRectangulo(box.getX(), box.getY(), box.getWidth(), box.getHeight(), 0, Color.RED);
	}

	public Rectangle getBox() {
		return box;
	}

}