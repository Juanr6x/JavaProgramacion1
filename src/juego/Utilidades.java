package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;

abstract class Utilidades {

	// Imprime las coordenadas de Laika en consola, para debug
	static void imprimirCoordenadas(Laika laika) {
		System.out.println("--------------------");
		System.out.println("x = " + laika.getX());
		System.out.println("y = " + laika.getY());
		System.out.println("--------------------");
	}

	public	static boolean sePuedeMover(Entorno e, Cuadra[] obj1, Laika obj2, char direccion) {
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
			Cuadrado c1 = new Cuadrado(ob1.getX(), ob1.getY(), ob1.getWidth(), ob1.getHeight());
			Cuadrado c2 = new Cuadrado(obj2.getX() + agregarX, obj2.getY() + agregarY + obj2.getVelocidad(),
					obj2.getWidth(),
					obj2.getHeight());
			if (HayInterseccion(c1,c2)) {
				return false;
			}
		}
		return true;
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
			
			Cuadrado c1 = new Cuadrado(ob1.getX(), ob1.getY(), ob1.getWidth(), ob1.getHeight());
			Cuadrado c2 = new Cuadrado(obj2.getX() + agregarX, obj2.getY() + agregarY + obj2.getVelocidad(),
					obj2.getWidth(),
					obj2.getHeight());
			if (HayInterseccion(c1,c2)) {
				return false;
			}
		}
		return true;
	}

	public static boolean sePuedeMover(Entorno e, Cuadra[] obj1, Auto obj2, char direccion) {
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
			Cuadrado c1 = new Cuadrado(ob1.getX(), ob1.getY(), ob1.getWidth(), ob1.getHeight());
			Cuadrado c2 = new Cuadrado(obj2.getX() + agregarX, obj2.getY() + agregarY + obj2.getVelocidad(),obj2.getWidth(),obj2.getHeight());
			
			
			if (HayInterseccion(c1,c2)) {
				return false;
			}
		}
		return true;
	}

	public static boolean colision(Planta obj1, Laika obj2) {
		Cuadrado c1 = new Cuadrado(obj1.getX(), obj1.getY(), obj1.getWidth(), obj1.getHeight());
		Cuadrado c2 = new Cuadrado(obj2.getX(), obj2.getY(), obj2.getWidth(), obj2.getHeight());
		if (HayInterseccion(c1,c2)) {
			return true;
		}
		return false;
	}

	public static boolean colision(Auto obj1, Laika obj2) {
		Cuadrado c1 = new Cuadrado(obj1.getX(), obj1.getY(), obj1.getWidth(), obj1.getHeight());
		Cuadrado c2 = new Cuadrado(obj2.getX(), obj2.getY(), obj2.getWidth(), obj2.getHeight());
		if (HayInterseccion(c1,c2)) {
			return true;
		}
		return false;
	}

	// Devuelve las coordenadas de la cuadra correspondiente al numero de calle,
	// para saber donde dibujarla posteriormente
	static Punto coordenadaCuadra(int numeroDeCalle) {
		Punto coordenadas = new Punto(0, 0);

		if (numeroDeCalle == 1) {
			coordenadas.setX(220);
			coordenadas.setY(285);
		}
		if (numeroDeCalle == 2) {
			coordenadas.setX(470);
			coordenadas.setY(285);
		}
		if (numeroDeCalle == 3) {
			coordenadas.setX(725);
			coordenadas.setY(285);
		}
		if (numeroDeCalle == 4) {
			coordenadas.setX(220);
			coordenadas.setY(565);
		}
		if (numeroDeCalle == 5) {
			coordenadas.setX(470);
			coordenadas.setY(565);
		}
		if (numeroDeCalle == 6) {
			coordenadas.setX(725);
			coordenadas.setY(565);
	//		coordenadas.setX(635);
	//		coordenadas.setY(440);
		}

		return coordenadas;
	}

	static Punto[] coordenadaAparicionEnemigo(int direccion) {
		Punto[] listCordenadas = new Punto[4];

		if (direccion == 1) {
			listCordenadas[0] = new Punto(30, 30);
			listCordenadas[1] = new Punto(280, 30);
			listCordenadas[2] = new Punto(530, 30);
			listCordenadas[3] = new Punto(760, 30);

		}
		if (direccion == 2) {
			listCordenadas[0] = new Punto(30, 760);
			listCordenadas[1] = new Punto(280, 760);
			listCordenadas[2] = new Punto(530, 760);
			listCordenadas[3] = new Punto(760, 760);
		}
		if (direccion == 3) {
			listCordenadas[0] = new Punto(30, 30);
			listCordenadas[1] = new Punto(30, 00);
			listCordenadas[2] = new Punto(30, 570);
			listCordenadas[3] = new Punto(30, 00);
		}
		if (direccion == 4) {
			listCordenadas[0] = new Punto(760, 30);
			listCordenadas[1] = new Punto(760, 300);
			listCordenadas[2] = new Punto(760, 570);
			listCordenadas[3] = new Punto(760, 760);
		}
		return listCordenadas;
	}

	public static Punto[] coordenadaAparicionAuto(int direccion) {
		Punto[] listCordenadas = new Punto[4];

		if (direccion == 1) {
			listCordenadas[0] = new Punto(0, 0);
			listCordenadas[1] = new Punto(220, 0);
			listCordenadas[2] = new Punto(470, 0);
			listCordenadas[3] = new Punto(760, 0);

		}
		if (direccion == 2) {
			listCordenadas[0] = new Punto(0, 760);
			listCordenadas[1] = new Punto(220, 760);
			listCordenadas[2] = new Punto(470, 760);
			listCordenadas[3] = new Punto(760, 760);
		}
		if (direccion == 3) {
			listCordenadas[0] = new Punto(0, 0);
			listCordenadas[1] = new Punto(0, 00);
			listCordenadas[2] = new Punto(0, 570);
			listCordenadas[3] = new Punto(0, 0);
		}
		if (direccion == 4) {
			listCordenadas[0] = new Punto(760, 0);
			listCordenadas[1] = new Punto(760, 300);
			listCordenadas[2] = new Punto(760, 570);
			listCordenadas[3] = new Punto(760, 760);
		}

		return listCordenadas;
	}
	
	public static boolean EstaAdentro(Cuadrado cuadrado, Punto punto) {
	    return cuadrado.getX() - cuadrado.getAncho() / 2 < punto.getX() &&
	           punto.getX() < cuadrado.getX() + cuadrado.getAncho() / 2 &&
	           cuadrado.getY() - cuadrado.getAlto() / 2 < punto.getY() &&
	           punto.getY() < cuadrado.getY() + cuadrado.getAlto() / 2;
	}

	public static boolean HayInterseccion(Cuadrado c1, Cuadrado c2) {
	    Punto p1 = new Punto(c2.getX() - c2.getAncho() / 2, c2.getY() + c2.getAlto() / 2);
	    Punto p2 = new Punto(c2.getX() - c2.getAncho() / 2, c2.getY() - c2.getAlto() / 2);
	    Punto p3 = new Punto(c2.getX() + c2.getAncho() / 2, c2.getY() + c2.getAlto() / 2);
	    Punto p4 = new Punto(c2.getX() + c2.getAncho() / 2, c2.getY() - c2.getAlto() / 2);

	    return EstaAdentro(c1, p1) || EstaAdentro(c1, p2) || EstaAdentro(c1, p3) || EstaAdentro(c1, p4);
	}
}
