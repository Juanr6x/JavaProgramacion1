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
	private Direccion direccion;
	private double escala = 0.30;
	private Image img;
	// private int chocaste = 0;

	public Auto(int x, int y, int direccion) {
		this.x = x;
		this.y = y;
		this.direccion = new Direccion("derecha");
		this.img = Herramientas.cargarImagen("imagenes/auto-derecha.png");
		this.height = (int) (img.getHeight(null) * escala);
		this.width = (int) (img.getWidth(null) * escala);
	}

	public static void atacar(Entorno e, Auto[] autos, Laika laika) {
		for (Auto auto : autos) {
			if (Utilidades.colision(auto, laika)) {
				laika.morir();
			}
		}
	}

	public void avanzar() {

		if (this.direccion.getDireccionString().equals("derecha")) {
			this.x += this.velocidad;
		} else if (this.direccion.getDireccionString().equals("izquierda")) {
			this.x -= this.velocidad;
		} else if (this.direccion.getDireccionString().equals("arriba")) {
			this.y -= this.velocidad;
		} else if (this.direccion.getDireccionString().equals("abajo")) {
			this.y += this.velocidad;
		}

	}

	public static void moverAutos(Entorno e, Cuadra[] cuadras, Auto[] autos) {
		for (Auto auto : autos) {
			if (auto.direccion.getDireccionString().equals("arriba")) {
				if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_ARRIBA)) {
					if (auto.y <= 0)
						auto.direccion.invertirDireccion();
				}
			}

			else if (auto.direccion.getDireccionString().equals("abajo")) {
				if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_ABAJO)) {
					if (auto.y >= 600)
						auto.direccion.invertirDireccion();
					auto.y += auto.velocidad;
				}

			}

			else if (auto.direccion.getDireccionString().equals("derecha")) {
				if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_DERECHA)) {
					if (auto.x >= 800) {
						auto.direccion.invertirDireccion();
						auto.girar();
					}
					auto.x += auto.velocidad;
				}
			}

			else if (auto.direccion.getDireccionString().equals("izquierda")) {
				if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_IZQUIERDA)) {
					if (auto.x <= 0) {
						auto.direccion.invertirDireccion();
						auto.girar();
					}
					auto.x -= auto.velocidad;
				}
			}
			auto.avanzar();
		}

	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagenConCentro(img, this.x, this.y, 0, 0, 0, escala);
	}

	// TODO
	public void girar() {
		if (direccion.equals("izquierda")) {

		}
		// (this.img.getSource().equals("imagenes/auto-izquierda.png"))
		// this.img = Herramientas.cargarImagen("imagenes/auto-derecha.png");
		// else
		// this.img = Herramientas.cargarImagen("imagenes/auto-derecha.png");
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
