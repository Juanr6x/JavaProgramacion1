package juego;

public class Punto {

    // Campos
    private int x;
    private int y;

    // Constructores
    public Punto() {
        this(0, 0);
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Métodos getters y setters
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


    public String toString() {
        return "Punto [x=" + x + ", y=" + y + "]";
    }

    
}






