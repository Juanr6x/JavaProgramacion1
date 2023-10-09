package juego;


import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import entorno.Entorno;
import entorno.InterfaceJuego;
import entorno.Menu;
import entorno.Herramientas; 
public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Image imgmanzana;
	private Color color;
	private Manzana manzana;
	// Variables y métodos propios de cada grupo
	// ...
	
	
	Juego()
	{
		
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Attack on Titan, Final Season - Grupo ... - v1", 800, 600);
		manzana = new Manzana(100, 100,100,100);
		// Inicializar lo que haga falta para el juego
		// ...
		//setBackground(Color.BLACK);
		//manzana = Herramientas.cargarImagen("Manzana1.png");
		//manzana[2] = Herramientas.cargarImagen("C:\\JavaProgramacion1\\ProyectoBaseTP\\src\\Imagenes\\manzana2.png");
		//manzana[3] = Herramientas.cargarImagen("C:\\JavaProgramacion1\\ProyectoBaseTP\\src\\Imagenes\\manzana3.png");
		//manzana[4] = Herramientas.cargarImagen("C:\\JavaProgramacion1\\ProyectoBaseTP\\src\\Imagenes\\manzana4.png");
		//manzana[5] = Herramientas.cargarImagen("C:\\JavaProgramacion1\\ProyectoBaseTP\\src\\Imagenes\\manzana5.png");
		//manzana[6] = Herramientas.cargarImagen("C:\\JavaProgramacion1\\ProyectoBaseTP\\src\\Imagenes\\manzana6.png");
		//this.entorno.dibujarRectangulo(10, 100,50, 50,0,color);
		

		
		// Inicia el juego!
		this.entorno.iniciar();
		
		
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
	
		// Procesamiento de un instante de tiempo
		// ...
		manzana.dibujarse(entorno);

	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
