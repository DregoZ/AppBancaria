/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG09;

public abstract class ContaCorriente extends Conta {

    Pagos entidadesAutorizadas;

    public static void crearCC() throws Exception {

        String seleccion;
        do {

            System.out.println("\n---- Creando Conta CORRIENTE ----");
            System.out.println("");
            System.out.println("Elixa unha opción: ");
            System.out.println("1. Crear conta PERSOAL.");
            System.out.println("2. Crear conta EMPRESA.");
            System.out.println("X. Volver.");
            System.out.print("Selección: ");
            seleccion = Ferramentas.seleccion();

            switch (seleccion) {
                case "1":
                    CCPersonal.crearCPersoal();
                    break;
                case "2":
                    CCEmpresa.crearCEmpresa();
                    break;
                default:
                    break;
            }

        } while (!"x".equals(seleccion));

        System.out.println("\nAtrás...\n");
        
        

    }

    //constructor, getters, setters
    public ContaCorriente(Pagos entidadesAutorizadas, Persona persona, double saldo, NumeroCCC numCuenta) {
        super(persona, saldo, numCuenta);
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

    public Pagos getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

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
        return "ContaCorriente{" + "entidadesAutorizadas=" + entidadesAutorizadas + '}';
    }

}
