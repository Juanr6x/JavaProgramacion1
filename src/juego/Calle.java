package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Image;

public class Calle {
	private Manzana[] manzanas;
	private int height, width;
	private int numeroDeCalle = 6;

	public Calle(int height, int width) {
		this.height = height;
		this.width = width;

		manzanas = new Manzana[6];

		for (int i = 0; i < 6; i++) {
			Image img = Herramientas.cargarImagen("imagenes/Manzana" + (i + 1) + ".png");
			int imgWidth = (int) (img.getWidth(null) * 0.75);
			int imgHeight = (int) (img.getHeight(null) * 0.75);
			int gapX = 100;
			int gapY = 100;

			int startX = (width - (imgWidth * 3 + gapX * 2)) / 2 + (int) (width * 0.25);
			int startY = (height - (imgHeight * 2 + gapY)) / 2;

			int x = startX + i % 3 * (imgWidth + gapX);
			int y = startY + i / 3 * (imgHeight + gapY);

			manzanas[i] = new Manzana(img, x, y, numeroDeCalle);
		}
	}

	public void dibujarse(Entorno e) {
		for (Manzana manzana : manzanas) {
			manzana.dibujar(e);
		}
	}

	// Método para verificar colisiones de Laika con las manzanas
	public void verificarColisionesLaika(Laika laika) {
		// Llamar al método de Laika para verificar colisiones con las manzanas
		laika.verificarColisionesManzanas(manzanas);
	}
}
