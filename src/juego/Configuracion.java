package juego;

public class Configuracion {
	private boolean sonido;
	private Dificultad dificultad;

	public Configuracion(boolean sonido, Dificultad dificultad) {
		this.sonido = sonido;
		this.dificultad = dificultad;
	}

	// Métodos getter y setter para sonido
	public boolean getSonido() {
		return sonido;
	}

	public void setSonido(boolean sonido) {
		this.sonido = sonido;
	}

	// Métodos getter y setter para dificultad
	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

	// Enum para representar las opciones de dificultad
	public enum Dificultad {
		FACIL,
		MEDIO,
		DIFICIL
	}
}
