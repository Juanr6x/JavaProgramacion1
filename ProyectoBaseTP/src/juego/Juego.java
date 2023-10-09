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
	private Image fondo;
	// Variables y métodos propios de cada grupo
	// ...
	
	
	Juego()
	{
		
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Attack on Titan, Final Season - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		setBackground(Color.BLACK);
		fondo =  Herramientas.cargarImagen("C:\\JavaProgramacion1\\ProyectoBaseTP\\src\\Imagenes\\fondomenucompleto.png");
		
		
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
		this.entorno.dibujarImagen(fondo, this.entorno.ancho(), this.entorno.alto(), 0);

	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
