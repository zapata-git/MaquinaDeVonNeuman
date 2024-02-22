/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinadevonneuman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Memoria memoria;
    UnidadControl unidadControl;
    UnidadAritmeticoLogica unidadAritmeticoLogica;
    TextArea seguimientoTextArea;
    TextArea resultadoTextArea;
    StringBuilder numerosSumados;

 @Override
public void start(Stage primaryStage) {
    memoria = new Memoria();
    unidadControl = new UnidadControl(memoria);
    unidadAritmeticoLogica = new UnidadAritmeticoLogica();

    Button ejecutarButton = new Button("Ejecutar");
    ejecutarButton.setOnAction(e -> ejecutarPrograma());

    seguimientoTextArea = new TextArea();
    seguimientoTextArea.setWrapText(true);

    resultadoTextArea = new TextArea();
    resultadoTextArea.setEditable(false);
    resultadoTextArea.setWrapText(true);
    resultadoTextArea.setMaxHeight(50); // Establecer la altura máxima
    resultadoTextArea.setPrefHeight(50); // Establecer la altura preferida

    Button resultadosButton = new Button("Mostrar Resultado");
    resultadosButton.setOnAction(e -> mostrarResultado());

    VBox root = new VBox(10);
    root.getChildren().addAll(ejecutarButton, seguimientoTextArea, resultadosButton, resultadoTextArea);
    root.setStyle("-fx-padding: 20px");

    Scene scene = new Scene(root, 400, 400);

    primaryStage.setTitle("Maquina de Von Neumann");
    primaryStage.setScene(scene);
    primaryStage.show();
}


    private void ejecutarPrograma() {
    StringBuilder seguimiento = new StringBuilder();
    numerosSumados = new StringBuilder();
    String direccionActual = unidadControl.contador_programa;
    String instruccionActual;
    String operandoActual;

    for (int i = 0; i < memoria.registro_direcciones.length; i++) {
        instruccionActual = memoria.leerDireccion(direccionActual);
        operandoActual = instruccionActual.substring(4);

        unidadControl.contador_programa = direccionActual;

        String codigoOperacion = instruccionActual.substring(0, 4);

        seguimiento.append("Instrucción actual: ").append(instruccionActual).append("\n");
        
        // Agregar labels para el código de operación
        switch (codigoOperacion) {
            case "0000":
                seguimiento.append("Código de operación: suma\n");
                break;
            case "0110":
                seguimiento.append("Código de operación: escribir en memoria\n");
                break;
            case "0111":
                seguimiento.append("Código de operación: fin del programa\n");
                break;
            default:
                seguimiento.append("Código de operación: desconocido\n");
                break;
        }
        
        seguimiento.append("Operando en memoria: ").append(operandoActual).append("\n");
        seguimiento.append("Acumulador antes de la operación: ").append(unidadAritmeticoLogica.acumulador).append("\n");

        if (codigoOperacion.equals("0000")) {
            String operandoMemoria = memoria.leerDireccion(operandoActual);
            numerosSumados.append(Integer.parseInt(operandoMemoria, 2)).append(" + ").append(Integer.parseInt(unidadAritmeticoLogica.acumulador, 2)).append("\n");
            int resultadoSuma = Integer.parseInt(operandoMemoria, 2) + Integer.parseInt(unidadAritmeticoLogica.acumulador, 2);
            unidadAritmeticoLogica.acumulador = String.format("%8s", Integer.toBinaryString(resultadoSuma)).replace(' ', '0');
            seguimiento.append("Resultado de la suma: ").append(unidadAritmeticoLogica.acumulador).append("\n");
        } else if (codigoOperacion.equals("0110")) {
            memoria.escribirDireccion(operandoActual, unidadAritmeticoLogica.acumulador);
        } else if (codigoOperacion.equals("0111")) {
            break;
        }

        seguimiento.append("Acumulador después de la operación: ").append(unidadAritmeticoLogica.acumulador).append("\n");
        seguimiento.append("------------------------------------------------------\n");

        direccionActual = Integer.toBinaryString((Integer.parseInt(direccionActual, 2) + 1) % memoria.registro_direcciones.length);
        direccionActual = String.format("%4s", direccionActual).replace(' ', '0');
    }

    seguimientoTextArea.setText(seguimiento.toString());
}

private void mostrarResultado() {
        int resultadoFinal = Integer.parseInt(unidadAritmeticoLogica.acumulador, 2);
        String resultadoFinalBinario = String.format("%8s", Integer.toBinaryString(resultadoFinal)).replace(' ', '0');
        resultadoTextArea.setText("El resultado de la suma es " + resultadoFinalBinario);
    }



    public static void main(String[] args) {
        launch(args);
    }
}








