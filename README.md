# RPG Menu Simulator

Este proyecto es una simulación básica de un menú de juego estilo RPG implementado en Java. Permite al usuario interactuar con un personaje y enfrentarse a enemigos en un entorno de texto.

## 🌟 Características actuales

* Definición de clases básicas para `Personaje` y `Enemigo`, con atributos como vida, ataque, defensa y nombre.
* Simulación de combates entre el jugador y enemigos utilizando valores aleatorios.
* Menú textual interactivo para elegir acciones.

## ⚖️ Cómo funciona

El programa principal (`RPGMenuSimulator`) ejecuta un bucle donde el usuario puede elegir entre:

* Ver los atributos de su personaje.
* Enfrentarse a un enemigo generado aleatoriamente.
* Salir del juego.

El sistema utiliza objetos de las clases `Personaje` y `Enemigo` para gestionar el estado del jugador y los oponentes.

## 🔧 Tecnologías utilizadas

* Lenguaje: Java (JDK 8+)
* IDE sugerido: IntelliJ IDEA, Eclipse o cualquier compatible con Java

## ⚒️ Mejoras previstas

Este proyecto está en una fase inicial, pero se planean las siguientes mejoras para futuras versiones:

1. **Refactorización de la lógica de combate**:

   * Mejor manejo de daños y críticos.
   * Aplicación de reglas de combate más complejas.

2. **Aplicación de principios de programación orientada a objetos**:

   * Uso de **herencia** para crear diferentes tipos de personajes o enemigos.
   * Incorporación de **polimorfismo** para manejar acciones comunes entre clases.
   * Introducción de **abstracciones** para mejorar la extensibilidad.

3. **Sistema de menú ampliado**:

   * Inclusión de **consumibles** (pociones, elixires, etc.).
   * Adición de **múltiples tipos de enemigos** con habilidades especiales.
   * Posibilidad de subir de nivel y mejorar estadísticas.

## ⚡ Ejecución

1. Clona el repositorio:

```bash
git clone https://github.com/tu-usuario/RPGMenuSimulator.git
cd RPGMenuSimulator
```

2. Compila los archivos:

```bash
javac *.java
```

3. Ejecuta el programa:

```bash
java RPGMenuSimulator
```

---

Este proyecto es ideal como base para explorar conceptos de programación orientada a objetos y estructuras de control en Java.

Si deseas contribuir o sugerir mejoras, no dudes en abrir un issue o pull request.

**Autor:** [Javier-va32]
