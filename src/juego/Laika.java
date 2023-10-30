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
	private Image img = Herramientas.cargarImagen("imagenes/Laika.png");;
	private Hitbox hitbox;
	private boolean estaVivo = true;
	private int contadorInvincibility = 0;

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
		if (contadorInvincibility < 100)
			return;
		this.estaVivo = false;
		this.velocidad = 0;
	}

	// choca un auto, golpea una planta , o la bola de fuego

	public void dibujarse(Entorno e) {
		e.dibujarImagenConCentro(img, x, y, 0, 0, 0, escala);
		contadorInvincibility++;
	}

	public void mover(Entorno e, Cuadra[] cuadras) {
		if (e.estaPresionada(e.TECLA_ARRIBA) && Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_ARRIBA)) {
			if (y <= 0)
				return;
			y -= velocidad;
			direccion = 1 ;
			hitbox.mover(x, y);
		}

		if (e.estaPresionada(e.TECLA_ABAJO) && Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_ABAJO)) {
			if (y + img.getHeight(e) * escala * 1.85 >= e.getHeight())
				return;
			y += velocidad;
			direccion = 2 ;
			hitbox.mover(x, y);

		}

		if (e.estaPresionada(e.TECLA_DERECHA) && Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_DERECHA)) {
			girarDerecha();
			if (x + img.getWidth(e) * escala * 1.90 >= e.getWidth())
				return;
			x += velocidad;
			direccion = 3 ;
			hitbox.mover(x, y);

		}

		if (e.estaPresionada(e.TECLA_IZQUIERDA) && Utilidades.sePuedeMover(e, cuadras, this, e.TECLA_IZQUIERDA)) {
			girarIzquierda();
			if (x < 0)
				return;
			x -= velocidad;
			direccion = 4 ;
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
	public void dispararRayo(Entorno e,RayoDestructor rayodestructor) {	
		if (rayodestructor != null) {
			if (e.estaPresionada(e.TECLA_ESPACIO)){
				rayodestructor.SetDireccion(direccion);
				rayodestructor.dibujar(e);
				rayodestructor.mover();
			}
			
		}
		
				
	 }
	
}
