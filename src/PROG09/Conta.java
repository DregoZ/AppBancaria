/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG09;

import static PROG09.ContaAforro.crearCAforro;

/**
 *
 * @author Dregoth
 */
public abstract class Conta implements Interfaz {

    Persona persona;
    double saldo;
    NumeroCCC numCuenta;

//    public abstract boolean crearNovaConta();
//    public abstract void mostrarContas();

        
    public Conta(Persona persona, double saldo, NumeroCCC numCuenta) {
        this.persona = persona;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
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
        return "Conta{" + "persona=" + persona + ", saldo=" + saldo + ", numCuenta=" + numCuenta + '}';
    }

}
