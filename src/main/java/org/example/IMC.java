package org.example;

import java.util.*;
import java.text.DecimalFormat;

public class IMC {
    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese los datos del niño/a " + (i + 1) + ". ");
            String nombre = ingresarNombre();
            double peso = ingresarPeso();
            int altura = ingresarAltura();
            double imc = calcularIMC(peso, altura);
            String categoria = establecerCategoria(imc);
            mostrarResultado(nombre, imc, categoria); // Muestra los resultados finales
        }
    }

    public static String ingresarNombre() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        do{
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine();
        } while (!nombreEsValido(nombre)); // Seguirá pidiendo el input del nombre hasta que el nombre ingresado sea válido
        return nombre;
    }

    public static boolean nombreEsValido(String nombre) {
        if(nombre == null || nombre.trim().isEmpty() || nombre.length() > 30){ // El nombre no debe esta vacío al quitar los espacios en blanco, ser nulo o contener más de 30 caracteres
            System.out.println("Nombre no válido. Inténtelo nuevamente.");
            return false;
        }
        for (int i = 0; i < nombre.length(); i++) {
            if (!Character.isLetter(nombre.charAt(i)) && !Character.isWhitespace(nombre.charAt(i))) { // Si el caracter no es una letra ni tampoco es un espacio blanco, se considera que el nombre contiene elementos no válidos
                System.out.println("El nombre no puede contener dígitos. Inténtelo nuevamente.");
                return false;
            }
        }
        return true;
    }


    public static double ingresarPeso() {
        double peso;
        do {
            System.out.print("Ingrese su peso en kilogramos: ");
            peso = manejarExcepcionDeEntradaDouble();
        } while (!pesoEsValido(peso)); // Seguirá pidiendo el input de peso hasta que se ingrese un peso válido
        return peso;
    }

    public static double manejarExcepcionDeEntradaDouble(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Entrada no válida. Por favor, ingrese un número: ");
                scanner.next(); // Permite ingresar un nuevo valor después del manejo de la excepción
            }
        }
    }

    public static boolean pesoEsValido(double peso){
        if (peso > 25 && peso < 250) { // Se considera un peso válido para este caso, un peso entre 25 y 250 kilogramos
            return true;
        } else if (peso < 0) {
            System.out.println("El peso debe ser un número positivo.");
            return false;
        } else {
            System.out.println("Peso no válido.");
            return false;
        }
    }

    public static int ingresarAltura() {
        int altura;
        do {
            System.out.print("Ingrese su altura en centímetros: ");
            altura = manejarExcepcionDeEntradaInt();
        } while(!alturaEsValida(altura)); // Seguirá pidiendo el input de altura hasta que se ingrese una altura válida
        return altura;
    }

    private static int manejarExcepcionDeEntradaInt() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                return scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.print("Entrada no válida. Por favor, ingrese un número: ");
                scanner.next(); // Permite ingresar un nuevo valor después del manejo de excepción
            }
        }
    }

    public static boolean alturaEsValida(int altura){
        if (altura <= 0) {
            System.out.println("La altura debe ser un número positivo.");
            return false;
        } else if (altura < 100 || altura > 270) {
            System.out.println("Altura no válida.");
            return false;
        }
        return true; // Se considera una altura válida a una altura mayor de 100 cm y menor a 270 cm
    }

    public static double calcularIMC(double peso, int altura) {
        return (peso / (Math.pow((altura / 100), 2))); // Se calcula el IMC dividiendo el peso por la altura (en metros) al cuadrado
    }

    private static String establecerCategoria(double imc) { // Método que retorna la categoría a la que pertenece el niño
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc < 24.9) {
            return "Normal";
        } else if (imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }

    public static void mostrarResultado(String nombre, double imc, String categoria) {
        DecimalFormat formato = new DecimalFormat("#.#"); // Define el formato en un decimal
        System.out.println("El niño/a " + nombre + " tiene un IMC de " + formato.format(imc));
        System.out.println("El niño/a " + nombre + " se encuentra en la categoría de " + categoria);
    }
}