/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author SALAS
 */
public class Ejecutor {

    public static void main(String args[]) {
        LecturaPais aplicacion = new LecturaPais();

        aplicacion.abrirArchivo();
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    } // fin de main
}
