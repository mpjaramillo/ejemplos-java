/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejericio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author SALAS
 */
public class LeerDatos {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("calificaciones2.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {

        try // lee registros del archivo, usando el objeto Scanner
        {
            double promedio;
            double[] arr = new double[4];
            double mayor = 0;
            while (entrada.hasNext()) {

                for (int i = 0; i < arr.length; i++) {
                    String linea = entrada.nextLine();
                    //System.out.println(linea);
                    ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";")));
                    System.out.println(linea_partes);
                    double valor1 = Double.parseDouble(linea_partes.get(2));
                    double valor2 = Double.parseDouble(linea_partes.get(3));
                    promedio = (valor1 + valor2) / 2;
                    System.out.printf("Promedio de calificaciones de %s %s es %.2f\n",
                            linea_partes.get(0), linea_partes.get(1), promedio);
                    arr[i] = promedio;
                    for (int j = 1; j < arr.length; j++) {
                        if (arr[j] > arr[i]) {
                            mayor = arr[j];
                            arr[j] = arr[i];
                            arr[i] = mayor;
                        }
                    }

                }
                System.out.println("Promedio mayor: " + mayor);
            }
            //for (int i = 0; i < arr.length; i++) {
            // arr[i] = promedio;
            // } // fin de while

        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo leerRegistros
// cierra el archivo y termina la aplicación

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
}
