/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejericio2;

/**
 *
 * @author SALAS
 */
public class Ejcutor {
    public static void main(String args[]) {
        LeerDatos aplicacion = new LeerDatos();

        aplicacion.abrirArchivo();
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    } // fin de main
}
