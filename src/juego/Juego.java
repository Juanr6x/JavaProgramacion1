package juego;

import java.util.Random;

import entorno.Entorno;
import entorno.InterfaceJuego;
// import entorno.Menu;
// import entorno.Herramientas;

public class Juego extends InterfaceJuego {
	private Entorno entorno;
	private int width = 800;
	private int height = 600;
	private Calle calle;
	private Laika laika = new Laika();
	private Planta planta[];
	private Auto auto[];

	Juego() {
		// Inicio del juego
		this.entorno = new Entorno(this, "Attack on Titan, Final Season - Grupo ... - v1", width, height);
		this.calle = new Calle();
		this.planta = new Planta[4];
		planta[0] = this.nuevaPlanta();
		planta[1] = this.nuevaPlanta();
		planta[2] = this.nuevaPlanta();
		planta[3] = this.nuevaPlanta();
		this.auto = new Auto[4];
		auto[0] = this.nuevoAuto();
		auto[1] = this.nuevoAuto();
		auto[2] = this.nuevoAuto();
		auto[3] = this.nuevoAuto();

		this.entorno.iniciar();

	}

	public void tick() {
		// Dibuja en pantalla
		this.calle.dibujarse(entorno);
		this.laika.dibujarse(entorno);
		// this.laika.setCuadras(this.calle.getCuadras());
		// Mueve a Laika
		this.laika.mover(entorno, this.calle.getCuadras());
		// Recorre la cantidad de Plantas y si hay alguno en null lo dibuja en cierto
		// tiempo.
		for (int i = 0; i < planta.length; i++) {
			if (this.planta[i] != null) {
				this.planta[i].dibujar(this.entorno);
			}
			// if(this.planta[i] == null) {
			// ReapareceKyojines(i);
			// }
			// if(this.reaparicionKyojines== 0) {
			// this.reaparicionKyojines=150;
		}
		// Recorre la cantidad de Autos y si hay alguno en null lo dibuja en cierto
		// tiempo.
		for (int i = 0; i < auto.length; i++) {
			if (this.auto[i] != null) {
				this.auto[i].dibujar(this.entorno);
			}
			// if(this.auto[i] == null) {
			// ReapareceKyojines(i);
			// }
			// if(this.reaparicionKyojines== 0) {
			// this.reaparicionKyojines=150;
			// }
		}
		for (int planta = 0; planta < this.planta.length; planta++) {
			this.planta[planta].moverDerecha();

			// this.planta[3].moverArriba();
		}

		for (int auto = 0; auto < this.auto.length; auto++) {
			this.auto[auto].moverDe();

			// this.auto[auto].moverArriba();
		}

	}

	@SuppressWarnings("unused")

	public static void main(String[] args) {
		Juego juego = new Juego();
	}

	// crea un nuevo enemigo en posicion random
	private Planta nuevaPlanta() {
		Random random = new Random();
		int xRandom = random.nextInt(750);
		int yRandom = random.nextInt(550);

		return new Planta(xRandom, yRandom, 30, 30);
	}

	// crea un nuevo enemigo en posicion random
	private Auto nuevoAuto() {
		Random random = new Random();
		int xRandom = random.nextInt(750);
		int yRandom = random.nextInt(550);

		return new Auto(xRandom, yRandom, 30, 30);
	}
}
