public class Personaje {

    //Definir los atributos del personaje
    private String nombre;
    private String tipo;
    private int vida;
    private int fuerza;
    private int magia;
    private double velocidad;
    private boolean vivo;
    private String [] inventario;

    //Constructor
    public Personaje (String nombre, String tipo) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.vivo = true;

        if (tipo.equalsIgnoreCase("Guerrero")) {
            this.vida = 80;
            this.fuerza = 12;
            this.magia = 0;
            this.velocidad = 1.2;
            this.inventario = new String[] {"Poción pequeña", "Espada de madera", "Llave Antigua"};
        }

        else if (tipo.equalsIgnoreCase("Mago")) {
            this.vida = 60;
            this.fuerza = 0;
            this.magia = 25;
            this.velocidad = 0.9;
            this.inventario = new String[] {"poción pequeña", "báculo de madera", "poción de maná"};
        }

        else{
            this.vida = 72;
            this.fuerza = 8;
            this.magia = 0;
            this.velocidad = 1.6;
            this.inventario = new String[] {"poción pequeña", "Arco de madera", "Flechas"};
        }
    }

    //Getters
    public String getNombre() {return nombre;}
    public String getTipo() {return tipo;}
    public int getVida() {return vida;}
    public int getFuerza() {return fuerza;}
    public int getMagia() {return magia;}
    public double getVelocidad() {return velocidad;}
    public boolean getVivo() {return vivo;}
    public String[] getInventario() {return inventario;}

    //Setters
    public void setVida(int vida) {this.vida = vida;}
    public void setFuerza(int fuerza) {this.fuerza = fuerza;}
    public void setMagia(int magia) {this.magia = magia;}
    public void setVivo(boolean vivo) {this.vivo = vivo;}
    public void setInventario(String[] inventario) {this.inventario = inventario;}

    //Método para atacar

    int atacar() {
        if (tipo.equalsIgnoreCase("Mago")) {
            return atacarMagia();
        } else {
            return atacarFisico();
        }
    }

    int atacarFisico() {
        return fuerza;
    }
    int atacarMagia() {
        return magia;
    }

    //Método para recibir daño
    void recibirDano(int cantidad) {
        this.vida -= cantidad;
        if(this.vida <= 0) {
            this.vida = 0;
            this.vivo = false;
            System.out.println("La vida de " + this.nombre + " ha llegado a 0");
            System.out.println("Game over");
        }
    }
}
