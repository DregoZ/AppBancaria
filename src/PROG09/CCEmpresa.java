package PROG09;

import java.util.ArrayList;

public class CCEmpresa extends ContaCorriente {

    // protected static ArrayList<CCEmpresa> listadoCEmpresa = new ArrayList<CCEmpresa>();
    double interesDesc; // empresa
    double maxDesc; // empresa
    double comisionDesc;

    //contas empresa
    protected static ArrayList<Conta> listarEmpresa() {
        return PROG09.listadoEmpresa;
    }

    protected static void engadirEmpresa(CCEmpresa contaEmpresa) {
        PROG09.listadoEmpresa.add(contaEmpresa);
    }

    // método encargado de crear unha conta de empresa: pide os datso, valídaos etc
    public static void crearCEmpresa() throws Exception {

        double interesDesc = 0;
        double maxDesc = 0;
        double comisionDesc = 0;
        double saldo = 0;
        Pagos entidadesAutorizadas;
        Persona persona;
        NumeroCCC numCuenta = null;

        //double comisionMant, Hashtable entidadesAutorizadas, Persona persona, double saldo, String numCuenta
        do {
            System.out.println("---- Conta EMPRESA ----");
            System.out.println("---- Introduce os datos ----");

            try {
                numCuenta = NumeroCCC.crearCCC();
            } catch (Exception e) {
                System.out.print("ERRO: *** " + e.getMessage() + " ***");
                Erros.errosCC();
                return;
            }

            persona = Persona.crearPersoa();

            if (Pagos.engadirPagos()) {
                entidadesAutorizadas = Pagos.crearEntidade();
            } else {
                entidadesAutorizadas = null;
            }

            // bloque de posibles datos numericos
            try {
//                System.out.print("\nSaldo total: ");
//                saldo = Ferramentas.seleccionNumeros();
//                if (saldo < 0 || saldo > 100000000) {
//                    throw new Exception("O saldo debe comprender un número entre 0 e 100.000.000 (€).");
//                }

                System.out.print("Interés por descuberto: ");
                interesDesc = Ferramentas.seleccionNumeros();

                System.out.print("Máximo descuberto permitido: ");
                maxDesc = Ferramentas.seleccionNumeros();

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
            PROG09.mostrarConta(PROG09.listadoEmpresa, "EMPRESA");

        } while (PROG09.crearNovaConta("EMPRESA") == true);
        System.out.println("Volvendo ó menú anterior...\n");

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
