package PROG09;

import static PROG09.ContaAforro.crearCAforro;
import static PROG09.ContaAforro.crearNovaConta;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class CCPersonal extends ContaCorriente {

    protected static ArrayList<CCPersonal> listadoCPersonal = new ArrayList<CCPersonal>();

    double comisionMant; // personal

// contas personales
    protected static ArrayList<CCPersonal> listarPersonal() {
        return listadoCPersonal;
    }

    protected static void engadirPersonal(CCPersonal contaPersonal) {
        listadoCPersonal.add(contaPersonal);

    }

    protected static void mostrarContas(ArrayList<CCPersonal> listadoCPersonal) {

        System.out.println("\n-- Contas PERSONALES: ");
        for (int i = 0; i < listadoCPersonal.size(); i++) {
            System.out.println("Conta " + (i + 1) + ". ");
            System.out.println(listadoCPersonal.get(i).getNumCuenta());
            System.out.println(listadoCPersonal.get(i).getPersona());
            System.out.println(listadoCPersonal.get(i).getSaldo());
            System.out.println("");
        }

    }

    public static boolean crearNovaConta() {
        String resposta;
        System.out.print("Desexa introducir outra conta personal? ");

        do {
            System.out.print("(s/n)");
            resposta = Ferramentas.seleccion().toLowerCase();
        } while (!"s".equals(resposta) && !"n".equals(resposta));

        return "s".equals(resposta);
    }

    // metodo encargado de crear conta personal
    public static void crearCPersoal() throws Exception {

        double comisionMant = 0;
        double saldo = 0;

        Pagos entidadesAutorizadas;

        Persona persona;
        NumeroCCC numCuenta = null;
        String resposta;

        //double comisionMant, Hashtable entidadesAutorizadas, Persona persona, double saldo, String numCuenta
        System.out.println("---- Conta PERSOAL ----");
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

        try {
            System.out.print("\nSaldo total: ");
            saldo = Ferramentas.seleccionNumeros();
            if (saldo < 0 || saldo > 100000000) {
                throw new Exception("O saldo debe comprender un número entre 0 e 100.000.000 (€).");
            }
        } catch (Exception e) {
            System.out.print("ERRO: ***" + e + "***");
            saldo = 0;
            Erros.errosDatosNumericos();
        }

        try {
            System.out.print("Comisión de mantemento: ");
            comisionMant = Ferramentas.seleccionNumeros();
            if (comisionMant < 0 || comisionMant > 20) {
                throw new Exception("A comisión de mantemento debe ser un número entre 0-20 (%)");
            }
        } catch (Exception e) {
            System.out.print("ERRO: ***" + e + "***");
            comisionMant = 0;
            Erros.errosDatosNumericos();
        }

        if (Pagos.engadirPagos()) {
            entidadesAutorizadas = Pagos.crearEntidade();
        } else {
            entidadesAutorizadas = null;
        }

        CCPersonal ccPersonal = new CCPersonal(comisionMant, entidadesAutorizadas, persona, saldo, numCuenta);

        System.out.println("Conta creada: " + ccPersonal);
        CCPersonal.engadirPersonal(ccPersonal);
        System.out.println("");
        mostrarContas(listadoCPersonal);
        
        if (crearNovaConta()) {
            crearCPersoal();
        } else {
            System.out.println("Volvendo ó menú principal...\n");
            Ferramentas.menu();
        }
//        System.out.print("Desexa introducir outra conta personal? ");
//
//        do {
//            System.out.print("(s/n)");
//            resposta = Ferramentas.seleccion().toLowerCase();
//        } while (!"s".equals(resposta) && !"n".equals(resposta));
//
//        if ("s".equals(resposta)) {
//            crearCPersoal();
//        } else {
//            System.out.println("Volvendo ó menú principal...\n");
//            Ferramentas.menu();
//        }

    }

    // constructor
    public CCPersonal(double comisionMant, Pagos entidadesAutorizadas, Persona persona, double saldo, NumeroCCC numCuenta) {
        super(entidadesAutorizadas, persona, saldo, numCuenta);
        this.comisionMant = comisionMant;
    }

    // getters setters
    public double getComisionMant() {
        return comisionMant;
    }

    public void setComisionMant(double comisionMant) {
        this.comisionMant = comisionMant;
    }

    public Pagos getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

    public void setEntidadesAutorizadas(Pagos entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
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

    @Override
    public NumeroCCC getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(NumeroCCC numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public String toString() {
        return "CCPersonal{" + " Persona= " + persona + " NumeroCCC= " + numCuenta + " Saldo= " + saldo + " comisionMant=" + comisionMant + " Pagos= " + entidadesAutorizadas + '}';
    }

}
