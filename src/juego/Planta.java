package juego;

import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
	private double x;
	private double y;
	private double alto;
	private double ancho;
	private double velocidad = 1.5;
	private double escala = 0.08;
	private Image imagen;
	private static Planta[] plantas;

	public Planta(int x, int y, int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.imagen = Herramientas.cargarImagen("imagenes/planta-derecha1.png");
	}

	public static Planta[] generar(int cantidad) {
		plantas = new Planta[cantidad];
		for (int i = 0; i < cantidad; i++) {
			Random random = new Random();
			int xRandom = random.nextInt(750);
			int yRandom = random.nextInt(550);
			plantas[i] = new Planta(xRandom, yRandom, 30, 30);
		}
		return plantas;
	}

	public static void moverPlantas(Planta[] plantas) {
		for (Planta planta : plantas) {
			planta.moverDerecha();
		}
	}

	public static void dibujar(Entorno entorno, Planta[] plantas) {
		for (Planta planta : plantas) {
			entorno.dibujarImagen(planta.imagen, planta.x, planta.y, 0, planta.escala);
		}
	}

	public void dibujar(Entorno e) {
		e.dibujarImagen(this.imagen, this.x, this.y, 0, this.escala);
	}

	public void moverDerecha() {
		this.x = this.x + this.velocidad;
	}

	void moverIzquierda() {
		this.x = this.x - this.velocidad;
	}

	void moverArriba() {
		this.y = this.y - this.velocidad;
	}

	void moverAbajo() {
		this.y = this.y + this.velocidad;
	}

	// TODO
	// private boolean colisionEntorno() {
	// return false;
	// }

	// private boolean colisionCuadra() {
	// return false;
	// }

	// private boolean colisionRayo() {
	// return false;
	// }

	public void girarDerecha() {
		this.imagen = Herramientas.cargarImagen("imagenes/planta-derecha1.png");
	}

	public void girarIzquierda() {
		this.imagen = Herramientas.cargarImagen("imagenes/planta-izquierda.png");
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getAlto() {
		return this.alto;
	}

	public double getAncho() {
		return this.ancho;
	}

	public double getVelocidad() {
		return this.velocidad;
	}
}
