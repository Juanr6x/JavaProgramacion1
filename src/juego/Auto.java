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
	private int direccion = 1;
	private double escala = 0.30;
	private Image img;
	// private int chocaste = 0;

	public Auto(int x, int y, int direccion) {
		this.x = x;
		this.y = y;
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

	public static void moverAutos(Entorno e, Cuadra[] cuadras, Auto[] autos) {
		for (Auto auto : autos) {
			System.out.println("moviendo auto : " + auto.direccion);
			if (auto.direccion == 2) {
				if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_ARRIBA)) {
					if (auto.y <= 0)
						auto.direccion = 1;
					auto.y -= auto.velocidad;
				} else {
					auto.direccion = 1;
				}
			}

			else if (auto.direccion == 1) {
				if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_ABAJO)) {
					if (auto.y >= 600)
						auto.direccion = 2;
					auto.y += auto.velocidad;
				} else {
					auto.direccion = 2;
				}

			}

			else if (auto.direccion == 3) {
				if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_DERECHA)) {
					if (auto.x >= 800) {
						auto.direccion = 4;
						auto.girar();
					}
					auto.x += auto.velocidad;
				} else {
					auto.direccion = 4;
				}
			}

			else if (auto.direccion == 4) {
				if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_IZQUIERDA)) {
					if (auto.x <= 0) {
						auto.direccion = 3;
						auto.girar();
					}
					auto.x -= auto.velocidad;
				} else {
					auto.direccion = 3;
				}
			}
		}
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagenConCentro(img, this.x, this.y, 0, 0, 0, escala);
	}

	public void girar() {
		System.out.println(this.img.getSource());
		// if (this.img.getSource().equals("imagenes/auto-izquierda.png"))
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
