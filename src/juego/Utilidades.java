package juego;

import java.awt.Point;
import java.awt.Rectangle;

import entorno.Entorno;

abstract class Utilidades {

	// Imprime las coordenadas de Laika en consola, para debug
	static void imprimirCoordenadas(Laika laika) {
		System.out.println("--------------------");
		System.out.println("x = " + laika.getX());
		System.out.println("y = " + laika.getY());
		System.out.println("--------------------");
	}

	static boolean sePuedeMover(Entorno e, Cuadra[] obj1, Laika obj2, char direccion) {
		int agregarX = 0, agregarY = 0;

		if (direccion == e.TECLA_ARRIBA)
			agregarY -= obj2.getVelocidad();
		if (direccion == e.TECLA_ABAJO)
			agregarY += obj2.getVelocidad();
		if (direccion == e.TECLA_DERECHA)
			agregarX += obj2.getVelocidad();
		if (direccion == e.TECLA_IZQUIERDA)
			agregarX -= obj2.getVelocidad();

		for (Cuadra ob1 : obj1) {
			Rectangle rec1 = new Rectangle(ob1.getX(), ob1.getY(), ob1.getWidth(), ob1.getHeight());
			Rectangle rec2 = new Rectangle(obj2.getX() + agregarX, obj2.getY() + agregarY + obj2.getVelocidad(),
					obj2.getWidth(),
					obj2.getHeight());
			if (rec1.intersects(rec2)) {
				return false;
			}
		}
		return true;
	}

	public static boolean colision(Planta planta, Laika laika) {
		Rectangle rec1 = new Rectangle(planta.getX(), planta.getY(), planta.getWidth(), planta.getHeight());
		Rectangle rec2 = new Rectangle(laika.getX(), laika.getY(), laika.getWidth(), laika.getHeight());

		if (rec1.intersects(rec2)) {
			return true;
		}
		return false;
	}

	public static boolean sePuedeMover(Entorno e, Cuadra[] obj1, Planta obj2, char direccion) {
		int agregarX = 0, agregarY = 0;

		if (direccion == e.TECLA_ARRIBA)
			agregarY -= obj2.getVelocidad();
		if (direccion == e.TECLA_ABAJO)
			agregarY += obj2.getVelocidad();
		if (direccion == e.TECLA_DERECHA)
			agregarX += obj2.getVelocidad();
		if (direccion == e.TECLA_IZQUIERDA)
			agregarX -= obj2.getVelocidad();

		for (Cuadra ob1 : obj1) {
			Rectangle rec1 = new Rectangle(ob1.getX(), ob1.getY(), ob1.getWidth(), ob1.getHeight());
			Rectangle rec2 = new Rectangle(obj2.getX() + agregarX, obj2.getY() + agregarY + obj2.getVelocidad(),
					obj2.getWidth(),
					obj2.getHeight());
			if (rec1.intersects(rec2)) {
				return false;
			}
		}
		return true;
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

	static Point[] coordenadaAparicionEnemigo(int direccion) {
		Point[] listCordenadas = new Point[4];

		if (direccion == 1) {
			listCordenadas[0] = new Point(30, 30);
			listCordenadas[1] = new Point(260, 30);
			listCordenadas[2] = new Point(510, 30);
			listCordenadas[3] = new Point(760, 30);

		}
		if (direccion == 2) {
			listCordenadas[0] = new Point(30, 760);
			listCordenadas[1] = new Point(260, 760);
			listCordenadas[2] = new Point(510, 760);
			listCordenadas[3] = new Point(760, 760);
		}
		if (direccion == 3) {
			listCordenadas[0] = new Point(30, 30);
			listCordenadas[1] = new Point(30, 300);
			listCordenadas[2] = new Point(30, 570);
			listCordenadas[3] = new Point(30, 300);
		}
		if (direccion == 4) {
			listCordenadas[0] = new Point(760, 30);
			listCordenadas[1] = new Point(760, 300);
			listCordenadas[2] = new Point(760, 570);
			listCordenadas[3] = new Point(760, 760);
		}
		return listCordenadas;
	}

}
