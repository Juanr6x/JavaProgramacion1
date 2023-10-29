package juego;

import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;

public class Calle {
	private Cuadra[] cuadras = new Cuadra[6];
	private Image img = Herramientas.cargarImagen("imagenes/carretera.png");

	public Calle() {
		for (int i = 0; i < cuadras.length; i++) {
			// Crea las manzanas
			cuadras[i] = new Cuadra(i + 1);
		}
	}

	public Cuadra[] getCuadras() {
		return cuadras;
	}

	public void dibujarse(Entorno e) {
		// Dibuja la calle
		e.dibujarImagen(img, 400, 300, 0, 1);
		// Dibuja las manzanas
		for (Cuadra cuadra : cuadras) {
			cuadra.dibujar(e);
		}
	}

}
