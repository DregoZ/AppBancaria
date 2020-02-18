package PROG09;

import java.util.ArrayList;

/**
 *
 * @author Dregoth
 */
public class ContaAforro extends Conta {

    //protected static ArrayList<Conta> listadoCAforro = new ArrayList<Conta>();
    double interesAnual;   // ahorro 

    // contas aforro
    protected static ArrayList<Conta> listarAforro() {
        return PROG09.listadoAforro;
    }

    static void engadirAforro(ContaAforro contaAforro) {
        PROG09.listadoAforro.add(contaAforro);
    }

//    private static boolean crearNovaConta() {
//        String resposta;
//        System.out.print("Desexa introducir outra conta de aforro? ");
//
//        do {
//            System.out.print("(s/n)");
//            resposta = Ferramentas.seleccion().toLowerCase();
//        } while (!"s".equals(resposta) && !"n".equals(resposta));
//
//        return "s".equals(resposta);
//    }
    // metodo encargado de crear conta aforro
    public static void crearCAforro() throws Exception {

        double interesAnual = 0;
        double saldo = 0;
        Persona persona;
        NumeroCCC numCuenta = null;

        do {
            System.out.println("\n---- Conta AFORRO ----");
            System.out.println("---- Introduce os datos ----");

            try {
                numCuenta = NumeroCCC.crearCCC();
            } catch (Exception e) {
                System.out.print("ERRO: *** " + e.getMessage() + " ***");
                Erros.errosCC();
                return;
            }

            persona = Persona.crearPersoa();

            try {
//                System.out.print("\nSaldo total: ");
//                saldo = Ferramentas.seleccionNumeros();
//                if (saldo < 0 || saldo > 100000000) {
//                    throw new Exception("O saldo debe comprender un número entre 0 e 100.000.000 (€).");
//                }
                System.out.print("Interés anual: ");
                interesAnual = Ferramentas.seleccionNumeros();
            } catch (Exception e) {
                System.out.print("ERRO: *** " + e.getMessage() + " ***");
                Erros.errosDatosNumericos();
            }

            ContaAforro ccAforro = new ContaAforro(interesAnual, persona, saldo, numCuenta);

            System.out.println("\nConta creada: " + ccAforro);
            engadirAforro(ccAforro);
            System.out.println("");
            PROG09.mostrarConta(PROG09.listadoAforro, "AFORRO");

        } while (PROG09.crearNovaConta("AFORRO") == true);
        System.out.println("Volvendo ó menú anterior...\n");

    }

    public ContaAforro(double interesAnual, Persona persona, double saldo, NumeroCCC numCuenta) {
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
