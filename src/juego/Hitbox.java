package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;

public class Hitbox {
	private Rectangle box;
	private boolean estaViva;

	public Hitbox(boolean estaViva, int x, int y, int width, int height) {
		this.box = new Rectangle(x, y, width, height);
		this.estaViva = estaViva;
	}

	public void mover(int x, int y) {
		box.setLocation(x, y);
	}

	public boolean colisiona(Hitbox otro) {
		return this.box.intersects(otro.box);
	}

	public void morir() {
		this.estaViva = false;
		System.out.println("laika murio");
	}

	public void dibujar(Entorno e) {
		e.dibujarRectangulo(box.getX(), box.getY(), box.getWidth(), box.getHeight(), 0, Color.RED);
	}

}