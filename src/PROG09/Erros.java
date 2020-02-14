/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG09;

import java.util.Scanner;

public class Erros {

    public static NumeroCCC errosCC() throws Exception {
        
        NumeroCCC numCuenta = null;

        String resposta;

        System.out.print(" ¿Introducir os datos de novo? (s/n)");
        resposta = Ferramentas.seleccion();

        if (resposta.equals("s")) {
            numCuenta = null;
            return numCuenta;
        } else {
            System.out.println(" Número de conta non válido. Regresando ao menú principal...\n\n");
        }
        Ferramentas.menu();

        return numCuenta;
    }

    public static void errosDatosNumericos() {
        System.out.print(" Datos introducidos erróneos. O valor inicializarase en 0.\n\n");

    }
    
    public static void errosData() {
        System.out.print(" Datos introducidos erróneos. É preciso cambiar a data a un formato correcto.\n\n");
    }
    
    
    
    public static String errosCampoVacio() {
        String valorValido;
        System.out.println(" Datos introducidos erróneos.");
        do {
            System.out.print("Introduza un valor válido: ");
            valorValido = Ferramentas.seleccion();
        } while (valorValido.equals(""));
        return valorValido;
    }

}
