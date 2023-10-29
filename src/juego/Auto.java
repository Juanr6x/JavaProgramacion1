package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Auto {
	private int x;
	private int y;
	private int height;
	private int width;
	private int velocidad = 2;
	private double escala = 0.30;
	private Image img;

	public Auto(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.img = Herramientas.cargarImagen("imagenes/auto-derecha.png");
		this.height = (int) (img.getHeight(null) * escala);
		this.width = (int) (img.getWidth(null) * escala);
	}

	public static void moverAutos(Auto[] autos) {
		for (Auto auto : autos) {
			auto.moverDerecha();
		}
	}

	public static void atacar(Entorno e, Auto[] autos, Laika laika) {
		for (Auto auto : autos) {
			if (Utilidades.colision(auto, laika)) {
				laika.morir();
			}
		}
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(img, this.x, this.y, 0, escala);
	}

	public void moverDerecha() {
		this.x = this.x + this.velocidad;
	}

	public void moverIzquierda() {
		this.x = this.x - this.velocidad;
	}

	public void moverArriba() {
		this.y = this.y - this.velocidad;
	}

	public void moverAbajo() {
		this.y = this.y + this.velocidad;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

}
