package juego;

import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
	private int x;
	private int y;
	private int height;
	private int width;
	private int velocidad = 2;
	private double escala = 0.08;
	private Image imagen;
	private static Planta[] plantas;
	private int direccion;

	public Planta(int x, int y, int height, int width, int direccion) {
		this.x = x;
		this.y = y;
		this.height = (int) (height * escala);
		this.width = (int) (width * escala);
		this.imagen = Herramientas.cargarImagen("imagenes/planta-derecha1.png");
		this.direccion = direccion;
	}

	public static Planta[] generar(int cantidad) {
		plantas = new Planta[cantidad];
		for (int i = 0; i < cantidad; i++) {
			Random random = new Random();
			int xRandom = random.nextInt(750);
			int yRandom = random.nextInt(550);
			plantas[i] = new Planta(xRandom, yRandom, 30, 30, 1);
		}
		return plantas;
	}

	public static void moverPlantas(Entorno e, Cuadra[] cuadras, Planta[] plantas) {
		for (Planta planta : plantas) {
			// 1 ---> arriba
			// 2 ---> abajo
			// 3 ---> derecha
			// 4 ---> izquierda

			if (planta.direccion == 2) {
				if (Utilidades.sePuedeMover(e, cuadras, planta, e.TECLA_ARRIBA)) {
					if (planta.y <= 0)
						return;
					planta.y -= planta.velocidad;
				} else {
					planta.direccion = 1;
				}
			}

			else if (planta.direccion == 1) {

				if (Utilidades.sePuedeMover(e, cuadras, planta, e.TECLA_ABAJO)) {
					if (planta.y >= 600)
						return;
					planta.y += planta.velocidad;
				} else {
					planta.direccion = 2;
				}

			}

			else if (planta.direccion == 3) {

				if (Utilidades.sePuedeMover(e, cuadras, planta, e.TECLA_DERECHA)) {
					if (planta.x >= 800)
						return;
					planta.x += planta.velocidad;
				} else {
					planta.direccion = 4;
				}
			}

			else if (planta.direccion == 4) {
				if (Utilidades.sePuedeMover(e, cuadras, planta, e.TECLA_IZQUIERDA)) {
					if (planta.x <= 0)
						return;
					planta.x -= planta.velocidad;
				} else {
					planta.direccion = 3;
				}

			}
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
		this.x = (int) (this.x + this.velocidad);
	}

	void moverIzquierda() {
		this.x = (int) (this.x - this.velocidad);
	}

	void moverArriba() {
		this.y = (int) (this.y - this.velocidad);
	}

	void moverAbajo() {
		this.y = (int) (this.y + this.velocidad);
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

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getVelocidad() {
		return this.velocidad;
	}
}
