package juego;

import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Auto {
	private double x;
	private double y;
	private double alto;
	private double ancho;
	private double velocidad = 1.5;
	private double escala = 0.30;
	private Image imagen;
	
	public Auto(int x, int y,int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.imagen = Herramientas.cargarImagen("imagenes/auto-derecha.png");	
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getAlto() {
		return this.alto;
	}
	public double getAncho() {
		return this.ancho;
	}
	public double getVelocidad() {
		return this.velocidad;
	}
	void dibujar(Entorno entorno) {
		entorno.dibujarImagen(imagen, this.x, this.y, 0,escala);
	}
	void moverDe() {
		this.x = this.x + this.velocidad;
	}
	void moverIz() {
		this.x = this.x - this.velocidad;
	}
	void moverAr() {
		this.y = this.y - this.velocidad;
	}
	void moverAb() {
		this.y = this.y + this.velocidad;
	}


}
