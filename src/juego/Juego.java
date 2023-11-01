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
		Planta.DispararPlantas(entorno, plantas);
		laika.dispararRayo(entorno);
		
	
			
	//	rayodestructor = this.laika.dispararRayo(entorno, rayodestructor);
		// intenta que dispare otra vez
	
		

	}

	@SuppressWarnings("unused")

	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	
	

}
