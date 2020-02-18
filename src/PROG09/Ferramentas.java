package PROG09;

import java.util.ArrayList;
import java.util.Scanner;

public class Ferramentas {

   // public static ArrayList<String> listadoNumerosCC = new ArrayList<String>();

    // metodo para seleccion de caracteres e números (Strings)
    protected static String seleccion() {
        Scanner input = new Scanner(System.in);
        String seleccion;
        seleccion = input.nextLine().toLowerCase();
        return seleccion;
    }

    // metodo para seleccion de numeros (saldos, comisions etc)
    protected static double seleccionNumeros() {
        Scanner input = new Scanner(System.in);
        double seleccionNumeros;
        seleccionNumeros = input.nextDouble();
        input.nextLine();

        return seleccionNumeros;
    }

    // método para truncar lonxitude de Strings (para evitar nomes moi largos)
    protected static String truncarString(String cadena) throws Exception {
        if (cadena != null && cadena.length() > 20) {
            cadena = cadena.substring(0, 20);
        } else if (cadena.equals("")) {
            throw new Exception("O campo non pode estar baleiro");
        }

        return cadena;
    }

}
