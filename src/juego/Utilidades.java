package juego;

import java.awt.Point;
import entorno.Entorno;

abstract class Utilidades {

	// Funciona a modo de eventos de teclado
	// y ejecuta acciones de Laika
	static void escucharTecla(Entorno entorno, Laika laika) {
		if (entorno.estaPresionada(entorno.TECLA_DERECHA) || entorno.estaPresionada('l')) {
			laika.moverDerecha();
		}
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) || entorno.estaPresionada('h')) {
			laika.moverIzquierda();
		}
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA) || entorno.estaPresionada('k')) {
			laika.moverArriba();
		}
		if (entorno.estaPresionada(entorno.TECLA_ABAJO) || entorno.estaPresionada('k')) {
			laika.moverAbajo();
		}
	}

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
