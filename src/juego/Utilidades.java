package juego;

import java.awt.Point;

abstract class Utilidades {

	// Imprime las coordenadas de Laika en consola, para debug
	static void imprimirCoordenadas(Laika laika) {
		System.out.println("--------------------");
		System.out.println("x = " + laika.getX());
		System.out.println("y = " + laika.getY());
		System.out.println("--------------------");
	}

	// Devuelve las coordenadas de la cuadra correspondiente al numero de calle,
	// para saber donde dibujarla posteriormente
	static Point coordenadaCuadra(int numeroDeCalle) {
		Point coordenadas = new Point(0, 0);

		if (numeroDeCalle == 1) {
			coordenadas.x = 150;
			coordenadas.y = 160;
		}
		if (numeroDeCalle == 2) {
			coordenadas.x = 390;
			coordenadas.y = 160;
		}
		if (numeroDeCalle == 3) {
			coordenadas.x = 635;
			coordenadas.y = 160;
		}
		if (numeroDeCalle == 4) {
			coordenadas.x = 150;
			coordenadas.y = 440;
		}
		if (numeroDeCalle == 5) {
			coordenadas.x = 390;
			coordenadas.y = 440;
		}
		if (numeroDeCalle == 6) {
			coordenadas.x = 635;
			coordenadas.y = 440;
		}

		return coordenadas;
	}

}
