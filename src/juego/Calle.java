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
	private Punto[] cordenadaenemigos;
	// private Punto[] cordenadaAutos;

	public Calle() {
		// Crea las manzanas
		for (int i = 0; i < cuadras.length; i++) {
			cuadras[i] = new Cuadra(i + 1);
		}

		// Crea las plantas
		for (int i = 0; i < plantas.length; i++) {
			Random random = new Random();
			Punto coordenada = new Punto(0, 0);
			int RandomLadoAparicion =  random.nextInt(1, 4);
			cordenadaenemigos = Utilidades.coordenadaAparicionEnemigo(RandomLadoAparicion);
			for (int x = 1; x < cordenadaenemigos.length + 1; x++) {
				if (x == RandomLadoAparicion)
					coordenada = cordenadaenemigos[random.nextInt(4)];
			}
				while (Utilidades.ExisteCordenadaPlanta(plantas,coordenada.getX(), coordenada.getY(), RandomLadoAparicion)) {
				    coordenada = cordenadaenemigos[random.nextInt(4)];
				}
					
				
				plantas[i] = new Planta(coordenada.getX(), coordenada.getY(), RandomLadoAparicion);
			
		}

		for (int i = 0; i < autos.length; i++) {
			Random random = new Random();
			Punto coordenada = new Punto(0, 0);
			int RandomLadoAparicion = random.nextInt(1, 4);
			cordenadaenemigos = Utilidades.coordenadaAparicionAuto(RandomLadoAparicion);
			
			for (int x = 1; x < cordenadaenemigos.length + 1; x++) {
				if (x == RandomLadoAparicion)
					coordenada = cordenadaenemigos[random.nextInt(4)];
			}
			while (ExisteCordenadaAuto(coordenada.getX(), coordenada.getY(), RandomLadoAparicion)) {
			    coordenada = cordenadaenemigos[random.nextInt(4)];
			}
			
			autos[i] = new Auto(coordenada.getX(), coordenada.getY(), RandomLadoAparicion);
	
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
		e.dibujarImagen(img, 400, 325, 0, 1);
		// Dibuja las manzanas
		for (Cuadra cuadra : cuadras) {
			cuadra.dibujar(e);
		}

		// Dibuja las plantas
		for (Planta planta : plantas) {
			if (planta!= null)
			 planta.dibujar(e);
		}

		// Dibuja los autos
		for (Auto auto : autos) {
			if (auto!= null)
				auto.dibujar(e);
		}
	}
	

	
	public boolean ExisteCordenadaAuto(int x, int y, int Direccion) {
	    if (autos != null && autos.length > 0) {
	        for (int i = 0; i < autos.length; i++) {
	        	if (autos[i] != null)
		            if ( autos[i].getX() == x && autos[i].getY() == y && autos[i].getSentido().sentido == Direccion) 
		                return true;
	        }
	    }
	    return false;
	}
	
}
