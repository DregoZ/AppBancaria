/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Dregoth
 */
class Persona {

    String nombre;
    String apellidos;
    String fnacimiento;

// crea obxecto da clase Persona
    protected static Persona crearPersoa() {

        String nomeC = null;
        String apelidosC = null;
        String dataC = null;

        String continuar;
        do {
            System.out.println("\n-- Datos do cliente: ");

            try {
                System.out.print("-- Nome: ");
                nomeC = Ferramentas.truncarString(Ferramentas.seleccion()).toUpperCase();
            } catch (Exception e) {
                System.out.print("ERRO: ***" + e + "***");
                nomeC = Erros.errosCampoVacio();
            }

            try {
                System.out.print("-- Apelidos: ");
                apelidosC = Ferramentas.truncarString(Ferramentas.seleccion()).toUpperCase();
            } catch (Exception e) {
                System.out.print("ERRO: ***" + e + "***");
                apelidosC = Erros.errosCampoVacio();
            }

            System.out.print("-- Data de nacemento (DD/MM/AAAA): ");
            dataC = Ferramentas.seleccion();

            if (!comprobarData(dataC)) {
                Erros.errosData();
                dataC = "** Data non inicializada **";
            }
            System.out.print("¿Confirmar cliente? (s/n): ");
            continuar = Ferramentas.seleccion();

        } while (!continuar.equals("s"));

        Persona persona = new Persona(nomeC, apelidosC, dataC);
        System.out.println("Persona creada!\n" + persona);
        return persona;
    }

    // comproba si o formato da data é correcto, coloca data por defecto si non
    public static boolean comprobarData(String dataC) {

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(dataC);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    // constructor
    public Persona(String nombre, String apellidos, String fnacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fnacimiento = fnacimiento;
    }

// getter setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(String fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    @Override
    public String toString() {
        return "{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", fnacimiento=" + fnacimiento + '}';
    }

}
