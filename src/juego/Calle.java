package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Image;

public class Calle {
	private Manzana[] manzanas = new Manzana[6];
	private Image img = Herramientas.cargarImagen("imagenes/carretera.png");

	public Calle(int height, int width) {

		manzanas[0] = new Manzana(150, 160, 1);
		manzanas[1] = new Manzana(390, 160, 2);
		manzanas[2] = new Manzana(635, 160, 3);
		manzanas[3] = new Manzana(150, 400, 4);
		manzanas[4] = new Manzana(390, 400, 5);
		manzanas[5] = new Manzana(635, 400, 6);

		// switch (i) {
		// case 1:
		// manzanas[i] = new Manzana(img, 120, 120, i);
		// break;
		// case 2:
		// manzanas[i] = new Manzana(img, 120, 360, i);
		// break;
		// case 3:
		// manzanas[i] = new Manzana(img, 120, 600, i);
		// break;
		// case 4:
		// manzanas[i] = new Manzana(img, 360, 120, i);
		// break;
		// case 5:
		// manzanas[i] = new Manzana(img, 360, 360, i);
		// break;
		// case 6:
		// manzanas[i] = new Manzana(img, 360, 600, i);
		// break;

		// }

	}

	public void dibujarse(Entorno e) {
		e.dibujarImagen(img, 400, 300, 0, 1);
		for (Manzana manzana : manzanas) {
			manzana.dibujar(e);
		}
	}

	// Método para verificar colisiones de Laika con las manzanas
	// public void verificarColisionesLaika(Laika laika) {
	// // Llamar al método de Laika para verificar colisiones con las manzanas
	// laika.verificarColisionesManzanas(manzanas);
	// }
}
