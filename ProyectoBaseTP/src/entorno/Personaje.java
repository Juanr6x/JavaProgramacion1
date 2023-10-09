package entorno;

public class Personaje {
    private String nombre;
    private int vida;
    private int fuerza;

    public Personaje(String nombre, int vida, int fuerza) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
    }

    public void atacar(Personaje enemigo) {
        enemigo.recibirDano(this.fuerza);
    }

    public void caminar(int distancia) {
        System.out.println(this.nombre + " camina " + distancia + " metros.");
    }

    private void recibirDano(int cantidad) {
        this.vida -= cantidad;
        if (this.vida <= 0) {
            System.out.println(this.nombre + " ha muerto.");
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
}
