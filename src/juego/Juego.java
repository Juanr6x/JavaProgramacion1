package juego;

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
	private Auto[] autos;
	private Planta[] plantas;
	private Cuadra[] cuadras;
	private RayoDestructor rayodestructor = new RayoDestructor(laika.getX(), laika.getY(),30, 30, 1,10);
	private BolaDeFuego[] bolasdefuego;
	private boolean jugando = true;

	Juego() {
		// Inicio del juego
		this.entorno = new Entorno(this, "Plantas Invasoras", width, height);

		// toda la logica del juego
		// está dentro de la clase Calle
		this.calle = new Calle();

		this.cuadras = this.calle.getCuadras();
		this.autos = this.calle.getAutos();
		this.plantas = this.calle.getPlantas();
		this.bolasdefuego = this.calle.getBolasDeFuego();
		this.entorno.iniciar();
	}

	public void tick() {
		// Dibuja en pantalla
		this.calle.dibujarse(entorno);
		this.laika.dibujarse(entorno);

		// comprueba si laika se encuentra viva
		if (!laika.isViva() && this.jugando) {
			this.jugando = false;
			// TODO
			// Utilidades.gameOver()
			System.out.println("Game Over");
		} else {
			// Mueve a Laika
			this.laika.mover(entorno, this.calle.getCuadras());

 			// Serian como los mordiscos, si se encuentran con laika, laika muere.
	 		Planta.atacar(this.entorno, this.plantas, this.laika);
		}
		Auto.moverAutos(entorno, cuadras, autos);
		Planta.moverPlantas(entorno, cuadras, plantas);
		Planta.DispararPlantas(entorno, bolasdefuego, plantas);
this.laika.dispararRayo(entorno, rayodestructor);
		// intenta que dispare otra vez
		for (int i = 0; i < plantas.length; i++) {
			if (plantas[i].getSentido().sentido == 1) {
				if (plantas[i].getY() >= 600)
					bolasdefuego[i] = null;
				if (bolasdefuego[i] == null)
					bolasdefuego[i] = new BolaDeFuego(plantas[i].getX(), plantas[i].getY(), 30, 30,
							plantas[i].getSentido().sentido, 5);
			} else if (plantas[i].getSentido().sentido == 2) {
				if (plantas[i].getY() <= 0)
					bolasdefuego[i] = null;
			}
			if (plantas[i].getSentido().sentido == 3) {
				if (plantas[i].getX() >= 800)
					bolasdefuego[i] = null;
			}
			if (plantas[i].getSentido().sentido == 4) {
				if (plantas[i].getX() <= 0)
					bolasdefuego[i] = null;
			}
		}
		if(laika.getSentido()==1) {
			if(laika.getY()>600) rayodestructor = null;
			if(rayodestructor == null)  rayodestructor = new RayoDestructor(laika.getX(), laika.getY(),30, 30, 1,10);

		}
		else if(laika.getSentido()==2) {
			if(laika.getY()<=0) rayodestructor = null;
	}
		else if(laika.getSentido()==3) {
			if(laika.getX()>=800) rayodestructor = null;
	}
		else if(laika.getSentido()==4) {
			if(laika.getX()<=0) rayodestructor = null;
	}
		
	}

	@SuppressWarnings("unused")

	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
