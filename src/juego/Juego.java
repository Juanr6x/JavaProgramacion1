package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
// import entorno.Menu;
// import entorno.Herramientas;

public class Juego extends InterfaceJuego {
	private Entorno entorno;
	private int width = 800;
	private int height = 650;
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
		this.laika.setX(entorno.ancho()/2 );
		this.laika.setY(entorno.alto()- (laika.getHeight()/2) );
		this.entorno.iniciar();
		this.laika.setPuntaje(0);
		this.laika.setEliminados(0);
	}

	public void tick() {
		// Dibuja en pantalla
		this.calle.dibujarse(entorno);
		this.laika.dibujarse(entorno);

		Utilidades.textoChico(entorno,"ENEMIGOS ELIMINADOS: " + laika.getEliminados(), 10,20,Color.GREEN);
		Utilidades.textoChico(entorno,"PUNTAJE: " + laika.getPuntaje(), entorno.ancho()-150,20,Color.GREEN);
		// comprueba si laika se encuentra viva
		if (!laika.isViva() && this.jugando) {
			this.jugando = false;
			// TODO
			// Utilidades.gameOver()
			System.out.println("Game Over");
			Utilidades.mostrarPuntuacion(laika.getPuntaje());
			volverAlMenu();
		} else {
			// Mueve a Laika;
			this.laika.mover(entorno, this.calle.getCuadras());

			// Serian como los mordiscos, si se encuentran con laika, laika muere.
			Planta.atacar(this.entorno, this.plantas, this.laika);
			Auto.Chocar(this.entorno, this.autos, this.laika);
		}
		Auto.moverAutos(entorno, cuadras, autos);
		Planta.moverPlantas(entorno, cuadras, plantas);
		Planta.DispararPlantas(entorno, plantas,this.laika,autos);
		laika.dispararRayo(entorno,plantas);

		
		
			

	
		

	}

	public void windowClosing(WindowEvent e) {
        volverAlMenu();
    }
	private void volverAlMenu() {
        // Cierra la ventana actual del juego
		entorno.dispose();

        // Crea una nueva instancia de la ventana del menú
        Menu menu = new Menu();
    }
	

}
