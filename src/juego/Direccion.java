package juego;

public class Direccion {
	public int sentido;
	public String sentidoString;
	public char sentidoChar;

	public Direccion(char direccion) {
		if (direccion == 40) {
			this.sentido = 1;
			this.sentidoChar = 40;
			this.sentidoString = "abajo";
		} else if (direccion == 38) {
			this.sentido = 2;
			this.sentidoChar = 38;
			this.sentidoString = "arriba";
		} else if (direccion == 39) {
			this.sentido = 3;
			this.sentidoChar = 39;
			this.sentidoString = "derecha";
		} else if (direccion == 37) {
			this.sentido = 4;
			this.sentidoChar = 37;
			this.sentidoString = "izquierda";
		}
	}

	public Direccion(int direccion) {
		if (direccion == 1 || direccion == 40) {
			this.sentido = 1;
			this.sentidoChar = 40;
			this.sentidoString = "abajo";
		} else if (direccion == 2 || direccion == 38) {
			this.sentido = 2;
			this.sentidoChar = 38;
			this.sentidoString = "arriba";
		} else if (direccion == 3 || direccion == 39) {
			this.sentido = 3;
			this.sentidoChar = 39;
			this.sentidoString = "derecha";
		} else if (direccion == 4 || direccion == 37) {
			this.sentido = 4;
			this.sentidoChar = 37;
			this.sentidoString = "izquierda";
		}
	}

	public Direccion(String direccion) {
		this.sentidoString = direccion;
		if (direccion.equals("abajo")) {
			this.sentido = 1;
			this.sentidoChar = 40;
		} else if (direccion.equals("arriba")) {
			this.sentido = 2;
			this.sentidoChar = 38;
		} else if (direccion.equals("derecha")) {
			this.sentido = 3;
			this.sentidoChar = 39;
		} else if (direccion.equals("izquierda")) {
			this.sentido = 4;
			this.sentidoChar = 37;
		}
	}

	public void invertirDireccion() {
		if (this.sentido == 1) {
			this.sentido = 2;
			this.sentidoChar = 38;
			this.sentidoString = "arriba";
			return;
		}
		if (this.sentido == 2) {
			this.sentido = 1;
			this.sentidoChar = 40;
			this.sentidoString = "abajo";
			return;
		}
		if (this.sentido == 3) {
			this.sentido = 4;
			this.sentidoChar = 37;
			this.sentidoString = "izquierda";
			return;
		}
		if (this.sentido == 4) {
			this.sentido = 3;
			this.sentidoChar = 39;
			this.sentidoString = "derecha";
			return;
		}
	}

	public int getDireccion() {
		return this.sentido;
	}

	public char getDireccionChar() {
		return this.sentidoChar;
	}

	public String getDireccionString() {
		return this.sentidoString;
	}
}
