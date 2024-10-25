/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labsemana3;
import java.util.Scanner;




/**
 *
 * @author adrianaguilar
 */
public class LabSemana3 {

    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);
        int opcion = 0;

       while (opcion != 4) {
            
            System.out.println("***Menú de Ejercicios***");
            System.out.println("1. CADENA - Encontrar el carácter más repetido");
            System.out.println("2. NOTAS - Ingresar y procesar notas");
            System.out.println("3. CLASES - Procesar observaciones de clases");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = info.nextInt();
            info.nextLine(); 

            if (opcion == 1) {
                // Ejercicio 1 - CADENA
                System.out.print("Ingrese una cadena: ");
                String cadena = info.nextLine();

                int[] cantidad = new int[256]; 
                int i = 0;
                int maxCantidad = 0;
                char maxCaracter = ' ';

               
                while (i < cadena.length()) {
                    char caracter = cadena.charAt(i);
                    cantidad[caracter]++; 
                    if (cantidad[caracter] > maxCantidad) {
                        maxCantidad = cantidad[caracter];
                        maxCaracter = caracter; 
                    }
                    i++;
                }

                System.out.println("El carácter que más se repite es '" + maxCaracter + "' con " + maxCantidad + " repeticiones.");
            }

            if (opcion == 2) {
                // Ejercicio 2 - NOTAS
                int notasCantidad = 0;
                while (notasCantidad <= 0) {
                    System.out.print("Ingrese la cantidad de notas (positivo): ");
                    notasCantidad = info.nextInt();
                }

                double[] notas = new double[notasCantidad];
                int i = 0;

               
                while (i < notasCantidad) {
                    System.out.print("Ingrese la Nota " + (i + 1) + ": ");
                    double nota = info.nextDouble();

                    if (nota >= 0 && nota <= 100) {
                        notas[i] = nota;
                        i++;
                    } else {
                        System.out.println("La nota debe estar entre 0 y 100.");
                    }
                }

             
                double suma = 0;
                double maxNota = notas[0];
                double minNota = notas[0];

                for (i = 0; i < notas.length; i++) {
                    suma += notas[i];
                    if (notas[i] > maxNota) {
                        maxNota = notas[i];
                    }
                    if (notas[i] < minNota) {
                        minNota = notas[i];
                    }
                }

                double promedio = suma / notas.length;
                System.out.printf("Promedio: %.2f %%\n", promedio);
                System.out.printf("Nota mayor: %.2f\n", maxNota);
                System.out.printf("Nota menor: %.2f\n", minNota);
            }

            if (opcion == 3) {
                // Ejercicio 3 - CLASES
                System.out.print("Ingrese la fecha actual (día, dia/mes): ");
                String fecha = info.nextLine().toLowerCase();
                String[] partesFecha = fecha.split(", ");
                if (partesFecha.length != 2 || partesFecha[1].length() != 5) {
                    System.out.println("Error! Formato de fecha incorrecto.");
                    break;
                }

                String diaSemana = partesFecha[0];
                String diaMes = partesFecha[1].substring(0, 2);
                String mes = partesFecha[1].substring(3, 5);

                int diaNumerico = Integer.parseInt(diaMes);
                int mesNumerico = Integer.parseInt(mes);

                
                if (diaNumerico > 31 || mesNumerico > 12) {
                    System.out.println("Error: Fecha inválida.");
                    break;
                }

                // Procesar según el día de la semana
                if (diaSemana.equals("lunes") || diaSemana.equals("martes") || diaSemana.equals("miercoles")) {
                    System.out.print("¿Se tomaron exámenes hoy? (si/no): ");
                    String respuestaExamen = info.nextLine().toLowerCase();
                    if (respuestaExamen.equals("si")) {
                        System.out.println("Ingrese la cantidad de alumnos que aprobaron: ");
                        int aprobados = info.nextInt();
                        System.out.println("Ingrese la cantidad de alumnos que no aprobaron: ");
                        int noAprobados = info.nextInt();
                        int total = aprobados + noAprobados;
                        if (total > 0) {
                            double porcentajeAprobados = (double) aprobados / total * 100;
                            System.out.printf("Porcentaje de aprobados: %.2f %%\n", porcentajeAprobados);
                        }
                    }
                } else if (diaSemana.equals("jueves")) {
                    System.out.print("Ingrese el porcentaje de asistencia: ");
                    double asistencia = info.nextDouble();
                    if (asistencia > 50) {
                        System.out.println("Asistieron bastantes.");
                    } else {
                        System.out.println("Asistieron pocos.");
                    }
                } else if (diaSemana.equals("Viernes")) {
                    if (diaNumerico == 1 && (mesNumerico == 1 || mesNumerico == 7)) {
                        System.out.println("Comienzo de nuevo ciclo.");
                        System.out.print("Ingrese la cantidad de alumnos del nuevo ciclo: ");
                        int alumnos = info.nextInt();
                        System.out.print("Ingrese el precio por cada alumno: ");
                        double precio = info.nextDouble();
                        double ingresoTotal = alumnos * precio;
                        System.out.printf("Ingreso total: $%.2f\n", ingresoTotal);
                    }
                } else {
                    System.out.println("Error: Día de la semana no válido.");
                }
            }

            if (opcion != 4) {
                
                System.out.println("Saliendo del sistema...");
            }
        }

        System.exit(0);
    }
}