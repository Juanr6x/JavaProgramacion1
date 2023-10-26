package juego;

import entorno.Herramientas;
import java.awt.Image;
import entorno.Entorno;

public class Cuadra {
	private Image manzana;
	private int x;
	private int y;
	private int numeroDeCalle;
	private int escala = 1;

	public Cuadra(int numeroDeCalle) {
		this.manzana = Herramientas.cargarImagen("imagenes/Manzana" + numeroDeCalle + ".png");
		this.numeroDeCalle = numeroDeCalle;

		// recupero las coordenadas de la cuadra para una correcta ubicacion en el mapa
		this.x = (int) Utilidades.coordenadaCuadra(numeroDeCalle).getX();
		this.y = (int) Utilidades.coordenadaCuadra(numeroDeCalle).getY();
	}

	public void dibujar(Entorno e) {
		e.dibujarImagen(this.manzana, this.x, this.y, 0, this.escala);
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