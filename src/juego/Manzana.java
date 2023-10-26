package juego;

import entorno.Herramientas;
import java.awt.Image;
import entorno.Entorno;

public class Manzana {
	private Image imagen;
	private int x;
	private int y;
	private int numeroDeCalle;
	private int escala = 1;
	private Image manzana1 = Herramientas.cargarImagen("imagenes/Manzana1.png");
	private Image manzana2 = Herramientas.cargarImagen("imagenes/Manzana2.png");
	private Image manzana3 = Herramientas.cargarImagen("imagenes/Manzana3.png");
	private Image manzana4 = Herramientas.cargarImagen("imagenes/Manzana4.png");
	private Image manzana5 = Herramientas.cargarImagen("imagenes/Manzana5.png");
	private Image manzana6 = Herramientas.cargarImagen("imagenes/Manzana6.png");

	public Manzana(int x, int y, int numeroDeCalle) {
		this.imagen = Herramientas.cargarImagen("imagenes/Manzana" + numeroDeCalle + ".png");
		this.x = x;
		this.y = y;
		this.numeroDeCalle = numeroDeCalle;
		if (numeroDeCalle == 1) {
			this.x = 150;
			this.y = 160;
		}
		if (numeroDeCalle == 2) {
			this.x = 390;
			this.y = 160;
		}
		if (numeroDeCalle == 3) {
			this.x = 635;
			this.y = 160;
		}
		if (numeroDeCalle == 4) {
			this.x = 150;
			this.y = 400;
		}
		if (numeroDeCalle == 5) {
			this.x = 390;
			this.y = 400;
		}
		if (numeroDeCalle == 6) {
			this.x = 635;
			this.y = 400;
		}
	}

	public void dibujar(Entorno e) {
		if (this.numeroDeCalle == 1) {
			e.dibujarImagen(manzana1, this.x, this.y, 0, this.escala);
		}
		if (this.numeroDeCalle == 2) {
			e.dibujarImagen(manzana2, this.x, this.y, 0, this.escala);
		}
		if (this.numeroDeCalle == 3) {
			e.dibujarImagen(manzana3, this.x, this.y, 0, this.escala);
		}
		if (this.numeroDeCalle == 4) {
			e.dibujarImagen(manzana4, this.x, this.y, 0, this.escala);
		}
		if (this.numeroDeCalle == 5) {
			e.dibujarImagen(manzana5, this.x, this.y, 0, this.escala);
		}
		if (this.numeroDeCalle == 6) {
			e.dibujarImagen(manzana6, this.x, this.y, 0, this.escala);
		}

	}

	public void chocasteManzana(Manzana[] Manzanas) {
		for (int i = 0; i < Manzanas.length; i++) {
			if (this.y + 40 > (Manzanas[i].getY() - Manzanas[i].getY() / 2)
					&& this.y - 40 < (Manzanas[i].getY() + Manzanas[i].getY() / 2)) {
				if (this.x - 40 < (Manzanas[i].getX() + Manzanas[i].getX() / 2)
						&& this.x > Manzanas[i].getX()) {
					this.x = (Manzanas[i].getX() + Manzanas[i].getX() / 2) + 40;
				}
				if (this.x + 40 > (Manzanas[i].getX() - Manzanas[i].getX() / 2)
						&& this.x < Manzanas[i].getX()) {
					this.x = (Manzanas[i].getX() - Manzanas[i].getX() / 2) - 40;
				}

			}
			if (this.x - 40 < (Manzanas[i].getX() + Manzanas[i].getX() / 2)
					&& this.x + 40 > (Manzanas[i].getX() - Manzanas[i].getX() / 2)) {
				if (this.y + 40 > (Manzanas[i].getY() - Manzanas[i].getY() / 2) - 5
						&& this.y < Manzanas[i].getY()) {
					this.y = (Manzanas[i].getY() - Manzanas[i].getY() / 2) - 5 - 40;
				}
				if (this.y - 40 < (Manzanas[i].getY() + Manzanas[i].getY() / 2) + 5
						&& this.y > Manzanas[i].getY()) {
					this.y = (Manzanas[i].getY() + Manzanas[i].getY() / 2) + 5 + 40;
				}
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getNumeroDeCalle() {
		return numeroDeCalle;
	}
}