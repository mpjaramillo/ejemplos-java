/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author SALAS
 */
public class Ejecutor {
     public static void main( String args[] )
   {
      GenerarFactura aplicacion = new GenerarFactura();

      aplicacion.abrir_archivo();
      aplicacion.agregar_informacion();
      aplicacion.cerrar_archivo();
} // fin de main
}
