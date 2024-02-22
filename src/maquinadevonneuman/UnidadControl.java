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
class UnidadControl {
    Memoria decodificador;
    String contador_programa = "0000";
    String registro_instrucciones = "00000000";

    UnidadControl(Memoria decodificador) {
        this.decodificador = decodificador;
    }
}
