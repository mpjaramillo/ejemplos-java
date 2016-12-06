/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author SALAS
 */
public class GenerarFactura {

    private Formatter salida; // objeto usado para enviar texto al archivo

    // permite al usuario abrir el archivo
    public void abrir_archivo() {
        try {
            salida = new Formatter("factura.txt");
        } // fin de try
        catch (SecurityException securityException) {
            System.err.println(
                    "No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } // fin de catch
        catch (FileNotFoundException filesNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrir_archivo

    public void agregar_informacion() {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> producto = new ArrayList<String>();
        int rta, cantidad;
        double precio;
        double subtotal = 0;

        try // envía valores al archivo
        {
            System.out.println("Ingrese nombre del Cliente: ");
            String nombre = entrada.nextLine();
            System.out.println("Ciudad: ");
            String ciudad = entrada.next();
            salida.format("\tComercial Ventas y Reventas\n\n"
                    + "Nombre: %s\nCiudad: %s\n"
                    + "----------------------------\n", nombre, ciudad);
            salida.format("Producto\tCantidad\tPrecio\t\n");
            System.out.println("MENÚ DE OPCIONES");

            System.out.println("Arroz; costo del kilo $2.50");
            System.out.println("Desea comprarlo? 1.(SI) 2.(No)");
            rta = entrada.nextInt();
            if (rta == 1) {
                System.out.println("Cuantos kilos desea? ");
                cantidad = entrada.nextInt();
                precio = (2.5) * cantidad;
                salida.format("Arroz\t\t%d\t\t\t%.2f\n", cantidad, precio);
                subtotal += precio;
            }
            System.out.println("Azúcar; costo del kilo $1.50");
            System.out.println("Desea comprarlo? 1.(SI) 2.(No)");
            rta = entrada.nextInt();
            if (rta == 1) {
                System.out.println("Cuantos kilos desea? ");
                cantidad = entrada.nextInt();
                precio = (1.5) * cantidad;
                salida.format("Azucar\t\t%d\t\t\t%.2f\n", cantidad, precio);
                subtotal += precio;
            }
            System.out.println("Aceite; costo $ 1.30 por unidad");
            System.out.println("Desea comprarlo? 1.(SI) 2.(No)");
            rta = entrada.nextInt();
            if (rta == 1) {
                System.out.println("Cuantos unidades desea? ");
                cantidad = entrada.nextInt();
                precio = (1.3) * cantidad;
                salida.format("Aceite\t\t%d\t\t\t%.2f\n", cantidad, precio);
                subtotal += precio;
            }
            System.out.println("Tallarines; costo $ 1.50 por unidad");
            System.out.println("Desea comprarlo? 1.(SI) 2.(No)");
            rta = entrada.nextInt();
            if (rta == 1) {
                System.out.println("Cuantas unidades desea? ");
                cantidad = entrada.nextInt();
                precio = (1.5) * cantidad;
                salida.format("Tallarines\t%d\t\t\t%.2f\n", cantidad, precio);
                subtotal += precio;
            }
            System.out.println("Sal; costo del kilo $1.00");
            System.out.println("Desea comprarlo? 1.(SI) 2.(No)");
            rta = entrada.nextInt();
            if (rta == 1) {
                System.out.println("Cuantos kilos desea? ");
                cantidad = entrada.nextInt();
                precio = (1) * cantidad;
                salida.format("Sal\t\t\t%d\t\t\t%.2f\n", cantidad, precio);
                subtotal += precio;
            }
            
            double iva = subtotal * (0.14);
            double total = subtotal + iva;
            salida.format("-----------------------\n" +
                    "\t\tSubtotal: %.2f\n"+
                    "\t\tIva 14: %.2f\n"+
                    "\t\tTotal: %.2f", subtotal, iva, total);
            

        } // fin de try
        catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir en el archivo.");
            return;
        } // fin de catch
        catch (NoSuchElementException elementException) {
            System.err.println("Entrada invalida. Intente de nuevo.");
        } // fin de catch

    } // fin de while
    // fin del método agregarRegistros

    // cierra el arrchivo
    public void cerrar_archivo() {
        if (salida != null) {
            salida.close();
        }
    } // fin del método cerrarArchivo
}
