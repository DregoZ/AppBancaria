/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG09;

import java.util.Hashtable;
import java.util.Set;

/**
 *
 * @author Dregoth
 */
public class Pagos {

    Hashtable entidadesAutorizadas;
    
    
    // pregunta si se quere engadir un pago recurrente
    protected static boolean engadirPagos() {
        String resposta;
        
        System.out.print("\n¿Engadir pagos recurrentes? ");
        do {
        System.out.print("(s/n)");
            resposta = Ferramentas.seleccion();  
        } while (!"s".equals(resposta) && !"n".equals(resposta));
        
         if ("s".equals(resposta)) {
            return true;
        } else return false;
    }

    
    // crea unha entidade + pago recurrente
    public static Pagos crearEntidade() throws Exception {
        
        String nomeE;
        double pagoE = 0;
        Hashtable<String, Double> entidadesAutorizadas = new Hashtable<String, Double>();
        String continuar;

        do {
            System.out.println("\n--> Entidades autorizadas: ");
            System.out.print("\tNome da entidade: ");
           try {
            nomeE = Ferramentas.truncarString(Ferramentas.seleccion().toUpperCase());
           } catch (Exception e) {
                System.out.print("ERRO: ***" + e + "***");
                nomeE = Erros.errosCampoVacio();
           }
            try {
                System.out.print("\tPago recurrente a " + nomeE + ": ");
                pagoE = Ferramentas.seleccionNumeros();

                while (pagoE < 0 || pagoE > 10000) {
                    System.out.println("Un pago recurrente debe estar comprendido entre 0 e 10000.");
                    System.out.print("\tPago recurrente a " + nomeE + ": ");
                    pagoE = Ferramentas.seleccionNumeros();
                }

            } catch (Exception e) {
                System.out.print("ERRO: ***" + e + "***");
                pagoE = 0;
                Erros.errosDatosNumericos();
            }

            entidadesAutorizadas.put(nomeE, pagoE);
            System.out.print("¿Engadir outra entidade? (s/n): ");
            continuar = Ferramentas.seleccion().toLowerCase();
        } while (continuar.equals("s"));

        System.out.println("Entidades engadidas: ");

        Set<String> keys = entidadesAutorizadas.keySet();

        for (String key : keys) {
            System.out.println("Entidade:  " + key + " --- Pago: " + entidadesAutorizadas.get(key) + "€");
        }

        Pagos pagos = new Pagos(entidadesAutorizadas);

        return pagos;
    }

    // constructor
    public Pagos(Hashtable entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
    }
    
    // getter setter toStr
    public Hashtable getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

    public void setEntidadesAutorizadas(Hashtable entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

    @Override
    public String toString() {
        return "Pagos{" + "entidadesAutorizadas=" + entidadesAutorizadas + '}';
    }

}
