/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinadevonneuman;

/**
 *
 * @author Carlos
 */
class Memoria {
    String[] registro_direcciones = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111"};
    String[] registro_datos = {"00000100", "00000101", "01100111", "01110000", "00001000", 
        "00000111", "00000000", "00000000"};

    String leerDireccion(String direccion) {
        int indice = Integer.parseInt(direccion, 2);
        return registro_datos[indice];
    }

    void escribirDireccion(String direccion, String dato) {
        int indice = Integer.parseInt(direccion, 2);
        registro_datos[indice] = dato;
    }
}
