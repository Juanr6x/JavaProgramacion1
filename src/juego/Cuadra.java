package juego;

import entorno.Herramientas;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;

public class Cuadra {
	private Image cuadra;
	private int x;
	private int y;
	private int numeroDeCalle;
	private int escala = 1;
	private int width;
	private int height;

	public Cuadra(int numeroDeCalle) {
		this.cuadra = Herramientas.cargarImagen("imagenes/Manzana" + numeroDeCalle + ".png");
		this.width = this.cuadra.getWidth(null) * escala;
		this.height = this.cuadra.getHeight(null) * escala;
		this.numeroDeCalle = numeroDeCalle;

		// recupero las coordenadas de la cuadra para una correcta ubicacion en el mapa
		this.x = (int) Utilidades.coordenadaCuadra(numeroDeCalle).getX() - this.width / 2;
		this.y = (int) Utilidades.coordenadaCuadra(numeroDeCalle).getY() - this.height / 2;
	}

	public void dibujar(Entorno e) {
		// e.dibujarImagen(this.manzana, this.x, this.y, 0, this.escala);
		// e.dibujarRectangulo(x, y, this.width, this.height, 0, Color.RED);

		// Calcular las coordenadas (0,0)

		e.dibujarImagenConCentro(cuadra, x, y, 0, 0, 0, this.escala);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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