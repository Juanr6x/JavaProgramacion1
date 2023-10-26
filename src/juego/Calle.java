package juego;

import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;

public class Calle {
	private Cuadra[] manzanas = new Cuadra[6];
	private Image img = Herramientas.cargarImagen("imagenes/carretera.png");

	public Calle() {
		// Crea las manzanas
		for (int i = 0; i < manzanas.length; i++) {
			manzanas[i] = new Cuadra(i + 1);
		}
	}

	public void dibujarse(Entorno e) {
		e.dibujarImagen(img, 400, 300, 0, 1);
		for (Cuadra manzana : manzanas) {
			manzana.dibujar(e);
		}
	}

}
