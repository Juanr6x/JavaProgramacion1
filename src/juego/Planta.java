package juego;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Planta {
	private int x;
	private int y;
	private int height;
	private int width;
	private int velocidad = 2;
	private double escala = 0.07;
	private Image imagen;
	private static Planta[] plantas;
	private Direccion direccion;
	private Hitbox hitbox;
	private boolean estaVivo = true;
	private BolaDeFuego boladefuego;

	public Planta(int x, int y, int direccion) {
		this.x = x;
		this.y = y;

		if (direccion == 1) {
			this.imagen = Herramientas.cargarImagen("imagenes/planta-izquierda.png");

		} else {

			this.imagen = Herramientas.cargarImagen("imagenes/planta-derecha1.png");
		}
		this.height = (int) (this.imagen.getHeight(null) * escala);
		this.width = (int) (this.imagen.getWidth(null) * escala);
		// if (direccion == 2)

		this.direccion = new Direccion(direccion);
		this.hitbox = new Hitbox(estaVivo, this.x, this.y, this.width, this.height);
	}

	public static Planta[] generar(int cantidad) {
		plantas = new Planta[cantidad];
		for (int i = 0; i < cantidad; i++) {
			Random random = new Random();
			int xRandom = random.nextInt(750);
			int yRandom = random.nextInt(550);
			plantas[i] = new Planta(xRandom, yRandom, 1);
		}
		return plantas;
	}

	public static void moverPlantas(Entorno e, Cuadra[] cuadras, Planta[] plantas) {
		for (Planta planta : plantas) {
			if (planta.direccion.getDireccionString().equals("arriba")) {
				if (Utilidades.sePuedeMover(e, cuadras, planta, e.TECLA_ARRIBA)) {
					if (planta.y <= 0) {
						planta.direccion.invertirDireccion();
						planta.y -= planta.velocidad;
					}
				}
			}

			else if (planta.direccion.getDireccionString().equals("abajo")) {
				if (Utilidades.sePuedeMover(e, cuadras, planta, e.TECLA_ABAJO)) {
					if (planta.y >= 600) {
						planta.direccion.invertirDireccion();
						planta.y += planta.velocidad;
					}
				}
			}

			else if (planta.direccion.getDireccionString().equals("derecha")) {
				if (Utilidades.sePuedeMover(e, cuadras, planta, e.TECLA_DERECHA)) {
					if (planta.x >= 800) {
						planta.direccion.invertirDireccion();
						planta.girarIzquierda();
					}
				}
			}

			else if (planta.direccion.getDireccionString().equals("izquierda")) {
				if (Utilidades.sePuedeMover(e, cuadras, planta, e.TECLA_IZQUIERDA)) {
					if (planta.x <= 0) {
						planta.direccion.invertirDireccion();
						planta.girarDerecha();
					}
				}
			}
			planta.avanzar();
		}
	}

	public void avanzar() {

		if (this.direccion.getDireccionString().equals("derecha")) {
			this.x += this.velocidad;
		} else if (this.direccion.getDireccionString().equals("izquierda")) {
			this.x -= this.velocidad;
		} else if (this.direccion.getDireccionString().equals("arriba")) {
			this.y -= this.velocidad;
		} else if (this.direccion.getDireccionString().equals("abajo")) {
			this.y += this.velocidad;
		}

	}

	public static void atacar(Entorno e, Planta[] plantas, Laika laika) {
		for (Planta planta : plantas) {
			if (Utilidades.colision(planta, laika)) {
				laika.morir();
			}
		}
	}

	
	public void dibujar(Entorno e) {
		e.dibujarImagen(this.imagen, this.x, this.y, 0, this.escala);
	}

	// TODO
	// private boolean colisionRayo() {
	// return false;
	// }

	public void girarDerecha() {
		this.imagen = Herramientas.cargarImagen("imagenes/planta-derecha1.png");
	}

	public void girarIzquierda() {
		this.imagen = Herramientas.cargarImagen("imagenes/planta-izquierda.png");
	}

	public Rectangle getHitbox() {
		return this.hitbox.getBox();
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

	public Direccion getSentido() {
		return direccion;
	}
	
	public BolaDeFuego getBolaDeFuego() {
		return boladefuego;
	}
	
	public BolaDeFuego SetBolaDeFuego(BolaDeFuego VBolaDeFuego ) {
		return boladefuego = VBolaDeFuego;
	}
	public static void DispararPlantas(Entorno e, Planta[] plantas) {
		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i].getBolaDeFuego() == null) {
				plantas[i].SetBolaDeFuego( plantas[i].boladefuego = new BolaDeFuego(plantas[i].getX(), plantas[i].getY(), 30, 30,	plantas[i].getSentido().sentido, 5));
			}
			if (plantas[i].getBolaDeFuego() != null) {
				plantas[i].boladefuego.dibujar(e);
				plantas[i].boladefuego.mover();
			}
			
			if (plantas[i].getBolaDeFuego() != null && plantas[i].boladefuego.colisionBolaFuegoBordes(plantas[i].boladefuego)) {
				plantas[i].SetBolaDeFuego( null);
			} 
			
		}
	}
}
