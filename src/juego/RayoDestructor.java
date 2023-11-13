package juego;

import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;


public class RayoDestructor {

	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int sentido;
	private int velocidad;
	private Image imagen;

	public RayoDestructor(int x, int y,int alto, int ancho, int sentido,int velocidad) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.sentido = sentido;
		this.velocidad = velocidad;
		this.imagen = Herramientas.cargarImagen("imagenes/rayo.png");
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getAlto() {
		return this.alto;
	}
	public int getAncho() {
		return this.ancho;
	}
	void dibujar(Entorno entorno) {
		double angulo = 0;
		if (this.sentido == 1) {//izq
			angulo = 180;
		}
		if (this.sentido == 2) {//arriba
			angulo = 270;
		}
		if (this.sentido == 3) {//abajo
			angulo = 90;
		}
		entorno.dibujarImagenConCentro(imagen, x,y+10, 30, 30, 0,0.10);
	}
	void mover() {
		if(sentido == 1) {
			moverAb();
		}
		else if(sentido == 2) {
			moverAr();
		}
		else if(sentido == 3) {
			moverD();
		}
		else if(sentido == 4) { 
			moverI();
		}
	}
	void moverD() {
		this.x = this.x +velocidad;
	}
	void moverI() {
		this.x = this.x -velocidad;
	}
	void moverAb() {
		this.y = this.y -velocidad;
	}
	
	void moverAr() {
		this.y = this.y +velocidad;
	}
	public int SetDireccion(int direccion) {
		return this.sentido = direccion ;
	}
	public boolean colisionRayoBordes(RayoDestructor rayodestructor) {
		if (rayodestructor != null) {
			if(rayodestructor.getX() >799  || rayodestructor.getX() < 0 ||
					rayodestructor.getY() <0 || rayodestructor.getY() > 649){
				return true;
			}
		}
		return false;
	}
	
	public boolean colisionRayoPlantas(RayoDestructor rayodestructor,Planta[] plantas) {
		Punto[] cordenadaenemigos;
		if (rayodestructor != null) { 
			for (int i = 0; i < plantas.length; i++) {
				if ( plantas[i] != null) {
					if (Utilidades.colision(rayodestructor, plantas[i])) {
				        plantas[i]= null; //Mato a la planta
				        //prodia crar una nueva  planta aqui asi mantengo la cantidad en el 
				        Random random = new Random();
						Punto coordenada = new Punto(0, 0);
						int RandomLadoAparicion = random.nextInt(1, 4);
						cordenadaenemigos = Utilidades.coordenadaAparicionEnemigo(RandomLadoAparicion);
						for (int x = 1; x < cordenadaenemigos.length + 1; x++) {
							if (x == RandomLadoAparicion)
								coordenada = cordenadaenemigos[random.nextInt(4)];
						}
						while (Utilidades.ExisteCordenadaPlanta(plantas,coordenada.getX(), coordenada.getY(), RandomLadoAparicion)) {
							    coordenada = cordenadaenemigos[random.nextInt(4)];
							}	
						plantas[i] = new Planta(coordenada.getX(), coordenada.getY(), RandomLadoAparicion);

						return true; 
					}
				}
			}
		}
		return false;
	}
}
	
