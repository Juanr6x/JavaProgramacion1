package juego;

import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;
import java.util.Random;

public class Calle {
	private Cuadra[] cuadras = new Cuadra[6];
	private Planta[] plantas = new Planta[4];
	private Auto[] autos = new Auto[4];
	private Image img = Herramientas.cargarImagen("imagenes/carretera.png");
	private int direccion;  
	public Calle() {
		// Crea las manzanas
		for (int i = 0; i < cuadras.length; i++) {
			cuadras[i] = new Cuadra(i + 1);
		}

		// Crea las plantas
		for (int i = 0; i < plantas.length; i++) {
			Random random = new Random();
			int xRandom = random.nextInt(750);
			int yRandom = random.nextInt(550);
			int RandomLadoAparicion = random.nextInt(3);
			if (RandomLadoAparicion==0)
				 xRandom = 30;
			
			if (RandomLadoAparicion==1)
				 yRandom = 30;
			
			if (RandomLadoAparicion==2)
				xRandom = xRandom + 200 ;
			
			if (RandomLadoAparicion==3)
			   yRandom = yRandom + 200 ;
			   

			plantas[i] = new Planta(xRandom, yRandom, 30, 30,RandomLadoAparicion);
		}

		// Crea los autos
		for (int i = 0; i < plantas.length; i++) {
			Random random = new Random();
			int xRandom = random.nextInt(750);
			int yRandom = random.nextInt(550);
			autos[i] = new Auto(xRandom, yRandom, 30, 30);
		}

	}

	public void moverPlantas() {
		for (Planta plantas : plantas) {
			plantas.moverDerecha();
		}
	}

	public Cuadra[] getCuadras() {
		return cuadras;
	}

	public Planta[] getPlantas() {
		return plantas;
	}

	public Auto[] getAutos() {
		return autos;
	}

	public void dibujarse(Entorno e) {
		// Dibuja la calle
		e.dibujarImagen(img, 400, 300, 0, 1);
		// Dibuja las manzanas
		for (Cuadra cuadra : cuadras) {
			cuadra.dibujar(e);
		}

		// Dibuja las plantas
		for (Planta planta : plantas) {
			planta.dibujar(e);
		}

		// Dibuja los autos
		for (Auto auto : autos) {
			auto.dibujar(e);
		}
	}

}
