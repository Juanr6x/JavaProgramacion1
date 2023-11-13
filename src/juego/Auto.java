package juego;

import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Auto {
	private int x;
	private int y;
	private int height;
	private int width;
	private int velocidad = 2;
	private Direccion direccion;
	private double escala = 0.30;
	private Image img = Herramientas.cargarImagen("imagenes/auto-arriba.png");

	public Auto(int x, int y, int direccion) {
		this.x = x;
		this.y = y;
		this.direccion = new Direccion(direccion);
		this.img = Herramientas.cargarImagen("imagenes/auto-" + this.direccion.getDireccionString() + ".png");
		this.width = (int) (img.getWidth(null) * escala);
		this.height = (int) (img.getHeight(null) * escala);
	}

	public static void atacar(Entorno e, Auto[] autos, Laika laika) {
		for (Auto auto : autos) {
			if (Utilidades.colision(auto, laika)) {
				laika.morir();
			}
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

	public static void crearAutos(Auto[] autos) {
		Punto[] cordenadaenemigos;
		for (int i = 0; i < autos.length; i++) {
			if (autos[i] == null) {
				autos[i] = null; // Mato a la planta
				// podia crear una nueva planta aqui asi mantengo la cantidad en el
				Random random = new Random();
				Punto coordenada = new Punto(0, 0);
				int RandomLadoAparicion = random.nextInt(1, 4);
				cordenadaenemigos = Utilidades.coordenadaAparicionAuto(RandomLadoAparicion);
				for (int x = 1; x < cordenadaenemigos.length + 1; x++) {
					if (x == RandomLadoAparicion)
						coordenada = cordenadaenemigos[random.nextInt(4)];
				}
				while (Utilidades.ExisteCordenadaAuto(autos, coordenada.getX(), coordenada.getY(),
						RandomLadoAparicion)) {
					coordenada = cordenadaenemigos[random.nextInt(4)];
				}
				autos[i] = new Auto(coordenada.getX(), coordenada.getY(), RandomLadoAparicion);

			}
		}
	}

	public static void moverAutos(Entorno e, Cuadra[] cuadras, Auto[] autos) {
		for (Auto auto : autos) {
			if (auto != null) {
				if (auto.direccion.getDireccionString().equals("arriba")) {
					if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_ARRIBA)) {
						if (auto.y <= 0) {
							auto.girarImagen();
							auto.direccion.invertirDireccion();
						}
					}
				}

				else if (auto.direccion.getDireccionString().equals("abajo")) {
					if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_ABAJO)) {
						if (auto.y >= 600) {
							auto.girarImagen();
							auto.direccion.invertirDireccion();
						}
					}

				}

				else if (auto.direccion.getDireccionString().equals("derecha")) {
					if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_DERECHA)) {
						if (auto.x >= 800) {
							auto.girarImagen();
							auto.direccion.invertirDireccion();
						}
					}
				}

				else if (auto.direccion.getDireccionString().equals("izquierda")) {
					if (Utilidades.sePuedeMover(e, cuadras, auto, e.TECLA_IZQUIERDA)) {
						if (auto.x <= 0) {
							auto.girarImagen();
							auto.direccion.invertirDireccion();
						}
					}
				}

				auto.avanzar();
			}
		}

	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagenConCentro(img, this.x, this.y, 0, 0, 0, escala);
	}

	// TODO
	public void girarImagen() {
		if (this.direccion.getDireccionString().equals("derecha")) {
			this.img = Herramientas.cargarImagen("imagenes/auto-izquierda.png");
		}
		if (this.direccion.getDireccionString().equals("izquierda")) {
			this.img = Herramientas.cargarImagen("imagenes/auto-derecha.png");
		}
		if (this.direccion.getDireccionString().equals("arriba")) {
			this.img = Herramientas.cargarImagen("imagenes/auto-arriba.png");
		}
		if (this.direccion.getDireccionString().equals("abajo")) {
			this.img = Herramientas.cargarImagen("imagenes/auto-abajo.png");
		}

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

	public static void Chocar(Entorno e, Auto[] autos, Laika laika) {
		for (Auto auto : autos) {
			if (Utilidades.colision(auto, laika)) {
				laika.morir();
			}
		}
	}
}
