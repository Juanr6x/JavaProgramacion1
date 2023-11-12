package juego;

public class Cuadrado {

    private int x;
    private int y;
    private int alto;
    private int ancho;

    public Cuadrado(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int calcularArea() {
        return alto * ancho;
    }

    public int calcularPerimetro() {
        return 2 * (alto + ancho);
    }

}

