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

	public Manzana(int numeroDeCalle) {
		this.imagen = Herramientas.cargarImagen("imagenes/Manzana" + numeroDeCalle + ".png");
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
			this.y = 440;
		}
		if (numeroDeCalle == 5) {
			this.x = 390;
			this.y = 440;
		}
		if (numeroDeCalle == 6) {
			this.x = 635;
			this.y = 440;
		}
	}

	public void dibujar(Entorno e) {
		Image manzana = Herramientas.cargarImagen("imagenes/Manzana" + this.numeroDeCalle + ".png");
		e.dibujarImagen(manzana, this.x, this.y, 0, this.escala);
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