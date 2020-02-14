/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG09;

import java.util.Scanner;

/**
 *
 * @author Dregoth
 */
public class NumeroCCC {

    final int CTRL_ENTIDADE_OFICINA[] = {4, 8, 5, 10, 9, 7, 3, 6};
    final int CTRL_NUM_CONTA[] = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
    String ccc;
    String entidade;
    String oficina;
    String dc1;
    String dc2;
    String numConta;

    protected static NumeroCCC crearCCC() throws Exception {
        System.out.print("\n-->Introduza o número CCC: ");
        String ccc = Ferramentas.seleccion();
        //String ccc = "00491500051234567892";

        NumeroCCC numeroCCC = new NumeroCCC(ccc);
        System.out.println("Conta creada correctamente: " + numeroCCC);

        return numeroCCC;
    }

    // verifica si o ccc é correcto, de selo engádeo a unha lista de CCC
    protected boolean verificarCCC(String ccc) throws Exception {

        if (ccc.length() != 20) //{
        {
            return false;
        }
        
        for (int i=0; i<Ferramentas.listadoNumerosCC.size(); i++) {
            if (ccc.equals(Ferramentas.listadoNumerosCC.get(i)))
                return false;
                
        }

        if (verificarDC1(ccc) == Integer.parseInt(ccc.substring(8, 9))) {
            if (verificarDC2(ccc) == Integer.parseInt(ccc.substring(9, 10))) {
                Ferramentas.listadoNumerosCC.add(ccc);
                return true;
            } else {
                return false;
                
            }
        }

        return false;
    }

    // verifica o dc1
    protected int verificarDC1(String ccc) {
        int suma = 0;
        int resto = 0;
        int dc1 = 0;
        System.out.println("Verificando: " + ccc);

        for (int i = 0; i < 8; i++) {
            int a = Integer.parseInt(ccc.substring(i, i + 1));
            //System.out.println("a: " + a);
            suma += a * CTRL_ENTIDADE_OFICINA[i];
        }
        //System.out.println("suma1: " + suma);
        resto = suma % 11;
        dc1 = 11 - resto;
        if (dc1 == 10) {
            dc1 = 1;
        } else if (dc1 == 11) {
            dc1 = 0;
        }
        //System.out.println("dc1: " + dc1);
        return dc1;
    }

    // verifica o dc2
    protected int verificarDC2(String ccc) {
        int suma = 0;
        int resto = 0;
        int dc2 = 0;

        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(ccc.substring(i + 10, i + 11));
            // System.out.println("b: " + a);
            suma += a * CTRL_NUM_CONTA[i];
        }
        // System.out.println("suma2: " + suma);
        resto = suma % 11;
        dc2 = 11 - resto;
        if (dc2 == 10) {
            dc2 = 1;
        } else if (dc2 == 11) {
            dc2 = 0;
        }
        // System.out.println("dc2: " + dc2);
        return dc2;
    }

    // constructor q verifica a validez do CCC
    public NumeroCCC(String ccc) throws Exception {

        if (!verificarCCC(ccc)) {
            throw new Exception("Numéro erróneo ou repetido.");
        }

        this.entidade = ccc.substring(0, 4);
        this.oficina = ccc.substring(4, 8);
        this.dc1 = ccc.substring(8, 9);
        this.dc2 = ccc.substring(9, 10);
        this.numConta = ccc.substring(9, 19);
    }

    // getters setters tostr
    public String getCcc() {
        return ccc;
    }

    public String getEntidade() {
        return entidade;
    }

    public String getOficina() {
        return oficina;
    }

    public String getDc1() {
        return dc1;
    }

    public String getDc2() {
        return dc2;
    }

    public String getNumConta() {
        return numConta;
    }

    @Override
    public String toString() {
        return "Numero CCC {" + entidade + "-" + oficina + "-" + dc1 + "" + dc2 + "-" + numConta + '}';
    }

}
