package juego;

//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Image;

import entorno.Entorno;
//import entorno.Herramientas;
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
	//private BolaDeFuego boladefuego[];
	//private boolean gameOver;
	//private boolean ganaste;
	//private int puntaje;
	//private Image imagen = Herramientas.cargarImagen("imagenes/carretera.png");

	Juego() {
		// Inicio del juego
		this.entorno = new Entorno(this, "Plantas invasoras", width, height);

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
		// GAME OVER
		//if (this.gameOver == true) {
		//	this.textoGrande("GAME OVER", 180, 300, Color.RED);
		//	this.textoChico("Enemigos Derrotados: " + this.puntaje,300,350,Color.WHITE);
		//	return;
			//}
		// GANASTE
		//if(this.ganaste == true) {
		//	this.textoGrande("VICTORIA", 220, 300, Color.BLUE);
		//	this.textoChico("Enemigos Derrotados: " + this.puntaje,300,350,Color.WHITE);//da por ganado el juego y finaliza
		//	return;
		//}
		this.laika.dibujarse(entorno);
		// Dibuja Puntaje
		//entorno.dibujarImagen(imagen, 395, 368, 0, 1.1);
		//this.textoChico("ENEMIGOS ELIMINADOS: " + this.puntaje, 10,20,Color.RED);
		//this.condicionVictoria();
	

		// Mueve a Laika
		this.laika.mover(entorno, this.calle.getCuadras());
		this.laika.isViva();
		Auto.moverAutos(autos);
		Planta.moverPlantas(entorno, cuadras, plantas);
	}

	@SuppressWarnings("unused")

	public static void main(String[] args) {
		Juego juego = new Juego();
	}
	//public boolean condicionVictoria() {
	//	if(this.planta[0] == null && this.planta[1] == null && this.planta[2] == null && this.planta[3] == null) {
	//		return this.ganaste = true;
	//	}
	//	return this.ganaste = false;
	//}
	//Agrega texto con sombra
	//public void texto(String texto, int x, int y) {
	//	this.entorno.cambiarFont(Font.MONOSPACED,20 ,Color.BLACK);
		//	this.entorno.escribirTexto(texto, x - 1, y - 1);
	//	this.entorno.cambiarFont(Font.MONOSPACED,20 ,Color.RED);
	//	this.entorno.escribirTexto(texto, x, y);
	//}	
	//Agrega texto grande con sombra y color
	//public void textoGrande(String texto, int x, int y, Color color) {
	//	entorno.cambiarFont(Font.MONOSPACED,80 ,Color.BLACK);
	//	entorno.escribirTexto(texto, x - 2, y - 2);
		//	entorno.cambiarFont(Font.MONOSPACED,80 , color);
	//	entorno.escribirTexto(texto, x, y);
		//}
	//public void textoChico(String texto, int x, int y, Color color) {
	//	entorno.cambiarFont(Font.MONOSPACED,20 ,Color.BLACK);
	//	entorno.escribirTexto(texto, x - 1, y - 1);
		//	entorno.escribirTexto(texto, x - 2, y - 2);
	//	entorno.escribirTexto(texto, x - 1, y - 1);
	//	entorno.cambiarFont(Font.MONOSPACED,20 , color);
		//	entorno.escribirTexto(texto, x, y);
			
}	

