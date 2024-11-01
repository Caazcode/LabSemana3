/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labsemana4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author adrianaguilar
 */
public class LabSemana4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        Random info = new Random();
        int opcion;
        int reversa = 0; 
        int perfecto = 0;
        int primo = 0;
        int votos = 0;

        do {
            
            System.out.println("Menu:");
            System.out.print("Seleccione una opcion: ");
            System.out.println("\n1 - Cambiar palabra al reves");
            System.out.println("2 - Numero perfecto");
            System.out.println("3 - Primos");
            System.out.println("4 - Votaciones");
            System.out.println("5 - Salir");
        
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    
                    System.out.print("Ingrese una palabra: ");
                    String palabra = sc.nextLine();
                    String palabraReversa = "";
                    for (int i = palabra.length() - 1; i >= 0; i--) {
                        palabraReversa += palabra.charAt(i);
                    }
                    System.out.println("Palabra al reves: " + palabraReversa);
                    reversa++;
                    break;

                case 2:
                   
                    System.out.print("Ingresa un numero: ");
                    int numero = sc.nextInt();
                    int suma = 0;
                    for (int i = 1; i < numero; i++) {
                        if (numero % i == 0) {
                            suma += i;
                        }
                    }
                    if (suma == numero) {
                        System.out.println(numero + " es un numero perfecto.");
                    } else {
                        System.out.println(numero + " no es un numero perfecto.");
                    }
                    perfecto++;
                    break;

                case 3:
                    
                    int Aleatorio = info.nextInt(100) + 1;
                    int Divisores = 0;
                    System.out.println("Numero generado: " + Aleatorio);
                    System.out.print("Divisores de " + Aleatorio + ": ");
                    for (int i = 1; i <= Aleatorio; i++) {
                        if (Aleatorio % i == 0) {
                            System.out.print(i + " ");
                            Divisores++;
                        }
                    }
                    System.out.println();
                    if (Divisores == 2) {
                        System.out.println("El numero " + Aleatorio + " es primo.");
                    } else {
                        System.out.println("El numero " + Aleatorio + " no es primo.");
                    }
                    primo++;
                    break;

                case 4:
                    
                    System.out.print("Ingrese el numero de votantes: ");
                    int votantes = sc.nextInt();
                    sc.nextLine(); 

                    int Azul = 0, votosRojo = 0, votosNegro = 0, votosAmarillo = 0, votosNulos = 0;
                    for (int i = 1; i <= votantes; i++) {
                        System.out.print("Voto " + i + " (AZUL, ROJO, NEGRO, AMARILLO): ");
                        String voto = sc.nextLine().toUpperCase();

                        switch (voto) {
                            case "AZUL":
                                Azul++;
                                break;
                            case "ROJO":
                                votosRojo++;
                                break;
                            case "NEGRO":
                                votosNegro++;
                                break;
                            case "AMARILLO":
                                votosAmarillo++;
                                break;
                            default:
                                votosNulos++;
                        }
                    }
                    
        int Rojo = 0;
        int Negro = 0;
        int Amarillo = 0;

                    int votosValidos = Azul + Rojo + Negro + Amarillo;
                    double porcentajeValidos = (double) votosValidos / votantes * 100;

                    if (porcentajeValidos >= 60) {
                        System.out.println("Resultados de la votacion:");
                        System.out.println("AZUL: " + Azul + " votos");
                        System.out.println("ROJO: " + Rojo + " votos");
                        System.out.println("NEGRO: " + Negro + " votos");
                        System.out.println("AMARILLO: " + Amarillo + " votos");
                        System.out.println("NULOS: " + votosNulos + " votos");

                         String ganador;
                        if (Azul > Rojo && Azul > Negro && Azul > Amarillo) {
                            ganador = "AZUL";
                        } else if (Rojo > Azul && Rojo > Negro && Rojo > Amarillo) {
                            ganador = "ROJO";
                        } else if (Negro > Azul && Negro > Rojo && Negro > Amarillo) {
                            ganador = "NEGRO";
                        } else {
                            ganador = "AMARILLO";
                        }
                        System.out.println("La planilla ganadora es: " + ganador);
                    } else {
                        System.out.println("Voto fracasado");
                    }
                    votos++;
                    break;

                case 5:
                    
                    System.out.println("Veces ingresada cada opcion:");
                    System.out.println("1 - Palabra al reves: " + reversa + " veces");
                    System.out.println("2 - Numero perfecto: " + perfecto + " veces");
                    System.out.println("3 - Numero Primos: " + primo + " veces");
                    System.out.println("4 - Votaciones: " + votos + " veces");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 5);

       
    }
}

    
