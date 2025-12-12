public class Enemigo {

    //Definir los atributos del enemigo
    private String nombre;
    private int vida;
    private int fuerza;
    private double velocidad;
    private boolean vivo;

    //Constructor
    public Enemigo () {
        this.nombre = "Orco menor";
        this.vida = 80;
        this.fuerza = 20;
        this.velocidad = 1.3;
        this.vivo = true;
    }

    //Getters
    public String getNombre() {return nombre;}
    public int getVida() {return vida;}
    public int getFuerza() {return fuerza;}
    public double getVelocidad() {return velocidad;}
    public boolean getVivo() {return vivo;}

    //Método para atacar
    int atacar() {
        return fuerza;
    }

    //Método para recibir daño
    void recibirDano(int cantidad) {
        this.vida -= cantidad;
        if (this.vida <=0) {
            this.vida = 0;
            this.vivo = false;
            System.out.println(this.nombre + " ha sido derrotado.");
        }
    }
}
