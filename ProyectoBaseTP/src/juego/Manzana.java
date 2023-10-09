package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Manzana {
	double x;
	double y;
	int alto;
	int ancho;
	Image img1;
	
	public Manzana(int x, int y,int alto, int ancho) 
	{	this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
	img1 = Herramientas.cargarImagen("C:\\JavaProgramacion1\\ProyectoBaseTP\\src\\juego\\Manzana1.png");
	}

	public void dibujarse(Entorno entorno)
	{
	//	entorno.dibujarTriangulo(this.x, this.y, 50, 30, this.angulo, Color.yellow);
	
		
			entorno.dibujarImagen(img1, this.x, this.y,50);
		
	}
}