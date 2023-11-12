package juego;

import entorno.Herramientas;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;

public class Cuadra {
	private Image cuadra;
	private int x;
	private int y;
	private int numeroDeCalle;
	private int escala = 1;
	private int width;
	private int height;
	private Color color;
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

		e.dibujarImagen(cuadra, x, y, 0, this.escala);
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