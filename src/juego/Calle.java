package juego;

import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;
import java.util.Random;
import java.awt.Point;

public class Calle {
	private Cuadra[] cuadras = new Cuadra[6];
	private Planta[] plantas = new Planta[4];
	private Auto[] autos = new Auto[4];
	private BolaDeFuego[] bolasdefuego = new BolaDeFuego[4];
	private Image img = Herramientas.cargarImagen("imagenes/carretera.png");
	private Point[] cordenadaenemigos;
	// private Point[] cordenadaAutos;

	public Calle() {
		// Crea las manzanas
		for (int i = 0; i < cuadras.length; i++) {
			cuadras[i] = new Cuadra(i + 1);
		}

		// Crea las plantas
		for (int i = 0; i < plantas.length; i++) {
			Random random = new Random();
			Point coordenada = new Point(0, 0);
			int RandomLadoAparicion = random.nextInt(1, 4);
			cordenadaenemigos = Utilidades.coordenadaAparicionEnemigo(RandomLadoAparicion);
			for (int x = 1; x < cordenadaenemigos.length + 1; x++) {
				if (x == RandomLadoAparicion)
					coordenada = cordenadaenemigos[random.nextInt(4)];
			}
			bolasdefuego[i] = new BolaDeFuego(coordenada.x, coordenada.y, 30, 30, RandomLadoAparicion, 5);
			plantas[i] = new Planta(coordenada.x, coordenada.y, RandomLadoAparicion);
		}

		for (int i = 0; i < autos.length; i++) {
			Random random = new Random();
			Point coordenada = new Point(0, 0);
			int RandomLadoAparicion = random.nextInt(1, 4);
			cordenadaenemigos = Utilidades.coordenadaAparicionAuto(RandomLadoAparicion);
			for (int x = 1; x < cordenadaenemigos.length + 1; x++) {
				if (x == RandomLadoAparicion)
					coordenada = cordenadaenemigos[random.nextInt(4)];
			}
			autos[i] = new Auto(coordenada.x, coordenada.y, RandomLadoAparicion);
		}

	}

	public BolaDeFuego[] getBolasDeFuego() {
		return bolasdefuego;
	}

	public Cuadra[] getCuadras() {
		return cuadras;
	}

	public Planta[] getPlantas() {
		return plantas;
	}

	public Auto[] getAutos() {
		return autos;
	}

	public void dibujarse(Entorno e) {
		// Dibuja la calle
		e.dibujarImagen(img, 400, 300, 0, 1);
		// Dibuja las manzanas
		for (Cuadra cuadra : cuadras) {
			cuadra.dibujar(e);
		}

		// Dibuja las plantas
		for (Planta planta : plantas) {
			planta.dibujar(e);
		}

		// Dibuja los autos
		for (Auto auto : autos) {
			auto.dibujar(e);
		}
	}

}
