package PROG09;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Dregoth
 */
public class ContaAforro extends Conta {

    protected static ArrayList<ContaAforro> listadoCAforro = new ArrayList<ContaAforro>();

    double interesAnual;   // ahorro 

    
    // contas aforro
    protected static ArrayList<ContaAforro> listarAforro() {
        return listadoCAforro;
    }

    protected static void engadirAforro(ContaAforro contaAforro) {
        listadoCAforro.add(contaAforro);
    }
    
    public static void mostrarContas(ArrayList<ContaAforro> listadoCAforro) {

        System.out.println("\n-- Contas AFORRO: ");
        for (int i = 0; i < listadoCAforro.size(); i++) {
            System.out.println("Conta " + (i + 1) + ". ");
            System.out.println(listadoCAforro.get(i).getNumCuenta());
            System.out.println(listadoCAforro.get(i).getPersona());
            System.out.println(listadoCAforro.get(i).getSaldo());
            System.out.println("");
        }
    }

    public static boolean crearNovaConta() {
        String resposta;
        System.out.print("Desexa introducir outra conta de aforro? ");

        do {
            System.out.print("(s/n)");
            resposta = Ferramentas.seleccion().toLowerCase();
        } while (!"s".equals(resposta) && !"n".equals(resposta));

        return "s".equals(resposta);
    }

    // metodo encargado de crear conta aforro
    public static void crearCAforro() throws Exception {

        double interesAnual = 0;
        double saldo = 0;
        Pagos entidadesAutorizadas;
        Persona persona;
        NumeroCCC numCuenta = null;

        System.out.println("---- Conta AFORRO ----");
        System.out.println("---- Introduce os datos ----");

        do {
            try {
                numCuenta = NumeroCCC.crearCCC();
            } catch (Exception e) {
                System.out.print(e);
                Erros.errosCC();

            }
        } while (numCuenta == null);

        persona = Persona.crearPersoa();

        try {
            System.out.print("\nSaldo total: ");
            saldo = Ferramentas.seleccionNumeros();
        } catch (Exception e) {
            System.out.print(e);
            Erros.errosDatosNumericos();
        }

        try {
            System.out.print("Interés anual: ");
            interesAnual = Ferramentas.seleccionNumeros();
        } catch (Exception e) {
            System.out.print(e);
            Erros.errosDatosNumericos();
        }

        if (Pagos.engadirPagos()) {
            entidadesAutorizadas = Pagos.crearEntidade();
        } else {
            entidadesAutorizadas = null;
        }

        ContaAforro ccAforro = new ContaAforro(interesAnual, persona, saldo, numCuenta, entidadesAutorizadas);

        System.out.println("\nConta creada: " + ccAforro);
        ContaAforro.engadirAforro(ccAforro);
        System.out.println("");
       ContaAforro.mostrarContas(listadoCAforro);

        if (crearNovaConta()) {
            crearCAforro();
        } else {
            System.out.println("Volvendo ó menú principal...\n");
            Ferramentas.menu();
        }
//        System.out.print("Desexa introducir outra conta de aforro? ");
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
//            PROG09.menu();
//        }

        ///ContasAlmacenadas.mostrarContasAforro();
    }

    public ContaAforro(double interesAnual, Persona persona, double saldo, NumeroCCC numCuenta, Pagos entidadesAutorizadas) {
        super(persona, saldo, numCuenta);
        this.interesAnual = interesAnual;

    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public NumeroCCC getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(NumeroCCC numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public String toString() {

        return "ContaAforro{" + " Persona= " + persona + " NumeroCCC= " + numCuenta + " saldo= " + saldo + " interesAnual=" + interesAnual + '}';

    }

}
