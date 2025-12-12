import java.util.Scanner;

public class RPGMenuSimulator {

    //Función menú
    static int menu(Scanner sc) {
        int opcion;

        System.out.println("===Menú del juego===");
        System.out.println("1. Crear personaje");
        System.out.println("2. Entrenar");
        System.out.println("3. Combate contra un enemigo");
        System.out.println("4. Ver estado del personaje");
        System.out.println("5. Salir");

        System.out.println("Ingrese una opción: ");
        opcion = sc.nextInt();
        return opcion;
    }

    //Función para crear personaje
    static Personaje crearPersonaje(Scanner sc) {
        sc.nextLine(); // ✔ limpiar buffer correcto

        String nombre;
        String tipo;
        int opcion;

        System.out.println("Ingrese el nombre de su personaje: ");
        nombre = sc.nextLine();
        System.out.println("Elija entre las clases: \n1. Guerrero \n2. Mago \n3. Arquero: ");
        opcion = sc.nextInt();
        sc.nextLine();

        //Definir la clase del personaje
        if (opcion == 1) {tipo = "Guerrero";}
        else if (opcion == 2) {tipo = "Mago";}
        else {tipo = "Arquero";}

        //Se instancia el objeto de la clase Personaje
        Personaje p = new Personaje(nombre, tipo);
        return p;
    }

    //Entrenamiento
    static void entrenar(Personaje p, Scanner sc) {
        int opcion;

        do {
            //menú de entrenamiento
            System.out.println("===Entrenamiento===");
            System.out.println("1. Entrenamiento de fuerza o magia: ganará +5 de fuerza o magia según la clase.");
            System.out.println("2. Entrenamiento de resistencia: ganará +10 de vida.");
            System.out.println("3. Salir");
            System.out.print("Seleccione una de las opciones: ");

            opcion = sc.nextInt();

            //Lógica para manejar el menú
            if (opcion == 1) {
                if (p.getTipo().equals("Mago")) {
                    p.setMagia(p.getMagia() + 5);
                    System.out.println(p.getNombre() + " ha ganado +5 puntos de magia.");
                }
                else {
                    p.setFuerza(p.getFuerza() + 5);
                    System.out.println(p.getNombre() + " ha ganado +5 puntos de fuerza.");
                }
            } else if (opcion == 2) {
                p.setVida(p.getVida() + 10);
                System.out.println(p.getNombre() + " ha ganado +10 puntos de vida.");
            } else {
                System.out.println("Volviendo al menú principal...");
            }
        } while (opcion != 3);
    }

    //Batalla
    static void batalla(Personaje p) {
        //Se instancia el objeto de la clase Enemigo
        Enemigo e = new Enemigo();

        //Se declaran las variables que almacenan el daño
        int danoP;
        int danoE;

        for (int i = 1; i <= 5; i++) {

            //Se evalúa quién atacará primero
            if (p.getVelocidad() > e.getVelocidad()) {
                // Personaje ataca primero
                danoP = p.atacar();
                System.out.println("Turno: " + i + ". " + p.getNombre() + " ataca, causando " + danoP + " puntos de daño a " + e.getNombre() + ".");
                e.recibirDano(danoP);
                if (!e.getVivo()) break;

                danoE = e.atacar();
                System.out.println("Turno: " + i + ". " + e.getNombre() + " ataca, causando " + danoE + " puntos de daño a " + p.getNombre() + ".");
                p.recibirDano(danoE);
                if (!p.getVivo()) break;
            } else {
                // Enemigo ataca primero
                danoE = e.atacar();
                System.out.println("Turno: " + i + ". " + e.getNombre() + " ataca, causando " + danoE + " puntos de daño a " + p.getNombre() + ".");
                p.recibirDano(danoE);
                if (!p.getVivo()) break;

                danoP = p.atacar();
                System.out.println("Turno: " + i + ". " + p.getNombre() + " ataca, causando " + danoP + " puntos de daño a " + e.getNombre() + ".");
                e.recibirDano(danoP);
                if (!e.getVivo()) break;
            }
        }
        //Revivir al personaje automáticamente
        if (!p.getVivo()) {
            p.setVivo(true);
        }
    }

    //Ver inventario
    static void verInventario(Personaje p) {
        System.out.println("Inventario de " + p.getNombre());
        for (String item: p.getInventario()) {
            System.out.println("-" + item);
        }
    }

    //Ver estado actual del personaje
    static void verEstado(Personaje p) {
        System.out.println("===Estado del personaje===");
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Clase del personaje: " + p.getTipo());
        System.out.println("Puntos de vida: " + p.getVida());
        System.out.println("Puntos de fuerza: " + p.getFuerza());
        System.out.println("Puntos de magia: " + p.getMagia());
        System.out.println("Puntos de velocidad: " + p.getVelocidad());
        verInventario(p);
    }

    public static void main(String[] args) {

        //Se inicia la variable para pedir datos al usuario
        Scanner sc = new Scanner(System.in);

        //Se inicializa la variable opcion
        int opcion;

        //Se declara el objeto p para tener alcance global
        Personaje p = null;

        do {
            //Se solicita la opción al usuario
            opcion = menu(sc);

            switch(opcion) {
                case 1:
                    p = crearPersonaje(sc);
                    break;
                case 2:
                    entrenar(p, sc);
                    break;
                case 3:
                    batalla(p);
                    break;
                case 4:
                    verEstado(p);
                    break;
                case 5:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 5);

        //Cerrar scanner
        sc.close();
    }
}