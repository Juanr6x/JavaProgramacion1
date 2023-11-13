package juego;

import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;
import entorno.Herramientas;

public class Laika {
	private int x, y;
	private int height;
	private int width;
	private double escala = 0.037;
	private int velocidad = 3;
	private int direccion;
	private Image img = Herramientas.cargarImagen("imagenes/Laika.png");
	private Hitbox hitbox;
	private int Puntaje;
	private int Eliminados;
	private boolean estaVivo = true;
	private int contadorInvincibility = 0;
	private RayoDestructor rayodestructor;

	// Constructor de Laika
	public Laika() {
		this.width = (int) (img.getWidth(null) * escala);
		this.height = (int) (img.getHeight(null) * escala);
		this.hitbox = new Hitbox(estaVivo, this.x, this.y, this.width, this.height);
	}

	public boolean isViva() {
		return estaVivo;
	}

	public void morir() {
		// establecemos unos segundos de invenciilidad para que no muera al instante
		// y el jugador se pueda ubicar.
		// this.img = Herramientas.cargarImagen("imagenes/LaikaDead.png");
		if (contadorInvincibility < 100)
			return;
		this.estaVivo = false;
		this.velocidad = 0;

	}

	// choca un auto, golpea una planta , o la bola de fuego

	public void dibujarse(Entorno e) {
		e.dibujarImagen(img, x, y, 0, escala);
		contadorInvincibility++;
	}

	public void mover(Entorno e, Cuadra[] cuadras) {

		if (e.estaPresionada(e.TECLA_ARRIBA)
				&& Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_ARRIBA)) {
			if (y - (this.getHeight() / 2) <= 0)
				return;
			y -= velocidad;
			direccion = 1;
			hitbox.mover(x, y);
		}

		if (e.estaPresionada(e.TECLA_ABAJO)
				&& Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_ABAJO)) {
			if (y + img.getHeight(e) * escala * 1.85 >= e.getHeight() + (this.getHeight() / 2))
				return;
			y += velocidad;
			direccion = 2;
			hitbox.mover(x, y);

		}

		if (e.estaPresionada(e.TECLA_DERECHA)
				&& Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_DERECHA)) {
			girarDerecha();
			if (x + img.getWidth(e) * escala * 1.90 >= e.getWidth() + this.getWidth())
				return;
			x += velocidad;
			direccion = 3;
			hitbox.mover(x, y);

		}

		if (e.estaPresionada(e.TECLA_IZQUIERDA)
				&& Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_IZQUIERDA)) {
			girarIzquierda();
			if (x - (this.getWidth() / 2) < 0)
				return;
			x -= velocidad;
			direccion = 4;
		}
		hitbox.mover(x, y);

	}

	// cambio de imagen de laika dependiendo de la direccion
	public void girarDerecha() {
		this.img = Herramientas.cargarImagen("imagenes/Laika.png");
	}

	public void girarIzquierda() {
		this.img = Herramientas.cargarImagen("imagenes/Laika_izq.png");
	}

	public boolean colisionBola() {
		return false;
	}

	public Rectangle getHitbox() {
		return hitbox.getBox();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int setX(int X) {
		return x = X;
	}

	public int setY(int Y) {
		return y = Y;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getSentido() {
		return direccion;
	}

	public int getPuntaje() {
		return Puntaje;
	}

	public int setPuntaje(int puntaje) {
		return Puntaje = puntaje;
	}

	public int getEliminados() {
		return Eliminados;
	}

	public int setEliminados(int eliminados) {
		return Eliminados = eliminados;
	}

	public void dispararRayo(Entorno entorno, Planta[] plantas) {
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			if (rayodestructor == null) {
				rayodestructor = new RayoDestructor(x, y, 30, 30, direccion, 10);
			}
		}
		if (rayodestructor != null) {
			rayodestructor.dibujar(entorno);
			rayodestructor.mover();
		}

		if (rayodestructor != null) {
			if (rayodestructor.colisionRayoBolaDeFuego(rayodestructor, plantas) > -1) {
				this.Puntaje = this.Puntaje + 5;
				this.Eliminados = this.Eliminados + 1;
				System.out.println("colision");
				plantas[rayodestructor.colisionRayoBolaDeFuego(rayodestructor, plantas)].eliminarBolaDeFuego();
				rayodestructor = null;
			}
			if (rayodestructor.colisionRayoPlantas(rayodestructor, plantas)) {
				this.Puntaje = this.Puntaje + 5;
				this.Eliminados = this.Eliminados + 1;
				rayodestructor = null;
			} else if (rayodestructor.colisionRayoBordes(rayodestructor))
				rayodestructor = null;
		}

	}
}
