/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG09;

import static PROG09.ContaAforro.crearCAforro;
import static PROG09.ContaAforro.crearNovaConta;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class CCEmpresa extends ContaCorriente {

    protected static ArrayList<CCEmpresa> listadoCEmpresa = new ArrayList<CCEmpresa>();

    double interesDesc; // empresa
    double maxDesc; // empresa
    double comisionDesc;

    //contas empresa
    protected static ArrayList<CCEmpresa> listarEmpresa() {
        return listadoCEmpresa;
    }

    protected static void engadirEmpresa(CCEmpresa contaEmpresa) {
        listadoCEmpresa.add(contaEmpresa);
    }

    protected static void mostrarContas(ArrayList<CCEmpresa> listadoCEmpresa) {

        System.out.println("\n-- Contas EMPRESA: ");
        for (int i = 0; i < listadoCEmpresa.size(); i++) {
            System.out.println("Conta " + (i + 1) + ". ");
            System.out.println(listadoCEmpresa.get(i).getNumCuenta());
            System.out.println(listadoCEmpresa.get(i).getPersona());
            System.out.println(listadoCEmpresa.get(i).getSaldo());
            System.out.println("");
        }
    }

    public static boolean crearNovaConta() {
        String resposta;
        System.out.print("Desexa introducir outra conta de empresa? ");

        do {
            System.out.print("(s/n)");
            resposta = Ferramentas.seleccion().toLowerCase();
        } while (!"s".equals(resposta) && !"n".equals(resposta));

        return "s".equals(resposta);
    }

    // método encargado de crear unha conta de empresa: pide os datso, valídaos etc
    public static void crearCEmpresa() throws Exception {
        Scanner input = new Scanner(System.in);

        double interesDesc = 0;
        double maxDesc = 0;
        double comisionDesc = 0;
        double saldo = 0;
        Pagos entidadesAutorizadas;
        Persona persona;
        NumeroCCC numCuenta = null;

        String resposta;

        //double comisionMant, Hashtable entidadesAutorizadas, Persona persona, double saldo, String numCuenta
        System.out.println("---- Conta EMPRESA ----");
        System.out.println("---- Introduce os datos ----");

        do {
            try {
                numCuenta = NumeroCCC.crearCCC();
            } catch (Exception e) {
                System.out.print(e.getMessage());
                Erros.errosCC();

            }
        } while (numCuenta == null);

        persona = Persona.crearPersoa();

        if (Pagos.engadirPagos()) {
            entidadesAutorizadas = Pagos.crearEntidade();
        } else {
            entidadesAutorizadas = null;
        }

        try {
            System.out.print("Saldo total: ");
            saldo = Ferramentas.seleccionNumeros();

        } catch (Exception e) {

            System.out.print(e);
            Erros.errosDatosNumericos();
        }
        input.nextLine();

        try {
            System.out.print("Interés por descuberto: ");
            interesDesc = Ferramentas.seleccionNumeros();
        } catch (Exception e) {
            System.out.print(e);
            Erros.errosDatosNumericos();
        }

        try {
            System.out.print("Máximo descuberto permitido: ");
            maxDesc = Ferramentas.seleccionNumeros();
        } catch (Exception e) {
            System.out.print(e);
            Erros.errosDatosNumericos();
        }

        try {
            System.out.print("Comisión por descuberto: ");
            comisionDesc = Ferramentas.seleccionNumeros();
        } catch (Exception e) {
            System.out.print(e);
            Erros.errosDatosNumericos();
        }

        CCEmpresa ccEmpresa = new CCEmpresa(interesDesc, maxDesc, comisionDesc, entidadesAutorizadas, persona, saldo, numCuenta);
        System.out.println("\nConta creada: " + ccEmpresa);
        engadirEmpresa(ccEmpresa);
        System.out.println("");
        mostrarContas(listadoCEmpresa);

        if (crearNovaConta()) {
            crearCEmpresa();
        } else {
            System.out.println("Volvendo ó menú principal...\n");
            Ferramentas.menu();
        }
        
//        System.out.print("Desexa introducir outra conta de empresa? ");
//
//        do {
//            System.out.print("(s/n)");
//            resposta = Ferramentas.seleccion().toLowerCase();
//        } while (!"s".equals(resposta) && !"n".equals(resposta));
//
//        if ("s".equals(resposta)) {
//            crearCAforro();
//        } else {
//            System.out.println("Volvendo ó menú principal...\n");
//            Ferramentas.menu();
//        }
//
    }

    // constructor
    public CCEmpresa(double interesDesc, double maxDesc, double comisionDesc, Pagos entidadesAutorizadas, Persona persona, double saldo, NumeroCCC numCuenta) {
        super(entidadesAutorizadas, persona, saldo, numCuenta);
        this.interesDesc = interesDesc;
        this.maxDesc = maxDesc;
        this.comisionDesc = comisionDesc;
    }

    // getters setters
    public double getInteresDesc() {
        return interesDesc;
    }

    public void setInteresDesc(double interesDesc) {
        this.interesDesc = interesDesc;
    }

    public double getMaxDesc() {
        return maxDesc;
    }

    public void setMaxDesc(double maxDesc) {
        this.maxDesc = maxDesc;
    }

    public double getComisionDesc() {
        return comisionDesc;
    }

    public void setComisionDesc(double comisionDesc) {
        this.comisionDesc = comisionDesc;
    }

    @Override
    public Pagos getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

    @Override
    public void setEntidadesAutorizadas(Pagos entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

    @Override
    public Persona getPersona() {
        return persona;
    }

    @Override
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public NumeroCCC getNumCuenta() {
        return numCuenta;
    }

    @Override
    public void setNumCuenta(NumeroCCC numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public String toString() {
        return "CCEmpresa{" + " Persona= " + persona + " NumeroCCC= " + numCuenta + " Saldo= " + saldo + " Pagos= " + entidadesAutorizadas + "  interesDesc=" + interesDesc + ", maxDesc=" + maxDesc + ", comisionDesc=" + comisionDesc + '}';
    }

}
