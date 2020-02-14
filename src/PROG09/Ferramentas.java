package PROG09;

import java.util.ArrayList;
import java.util.Scanner;

public class Ferramentas {

    public static ArrayList<String> listadoNumerosCC = new ArrayList<String>();

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

    public static void menu() throws Exception {

        System.out.println("\n---- Xestión de contas v0.1 ----");
        System.out.println("");
        System.out.println("Elixa unha opción: ");
        System.out.println("1. Crear conta CORRIENTE.");
        System.out.println("2. Crear conta AFORRO.");
        System.out.println("3. Xestión de contas.");
        System.out.println("X. Saír do programa.");
        System.out.print("Selección: ");
        String seleccion = seleccion();
        System.out.println("select: " + seleccion);

        while (!"1".equals(seleccion) && !"2".equals(seleccion) && !"3".equals(seleccion) && !"x".equals(seleccion)) {
            System.out.println("Selección incorrecta...");
            System.out.print("Selección: ");
            seleccion = seleccion();
        }

        switch (seleccion) {
            case "1":
                ContaCorriente.crearCC();
                break;
            case "2":
                ContaAforro.crearCAforro();
                break;
            case "3":
                Ferramentas.xestionContas();
                break;
            case "x":
                System.out.println("\nCerrando programa...");
                System.exit(0);
                break;

            default:
                break;
        }
    }

    static void xestionContas() throws Exception {

        String seleccion = "";

        System.out.println("\n---- Contas almacenadas ----");
        System.out.println("");
        System.out.println("Elixa unha opción: ");
        System.out.println("1. Mostrar todo.");
        System.out.println("2. Mostrar contas PERSONALES.");
        System.out.println("3. Mostrar contas de EMPRESA.");
        System.out.println("4. Mostrar contas de AFORRO.");
        System.out.println("X. Volver.");
        System.out.print("Selección: ");
        seleccion = seleccion();

        while (!"1".equals(seleccion) && !"2".equals(seleccion) && !"3".equals(seleccion) && !"x".equals(seleccion)) {
            System.out.println("Selección incorrecta...");
            System.out.print("Selección: ");
            seleccion = seleccion();
        }

        switch (seleccion) {
            case "1":
                System.out.println("\n---- Listado de tódalas contas almacenadas ----\n");
                CCPersonal.mostrarContas(CCPersonal.listadoCPersonal);
                CCEmpresa.mostrarContas(CCEmpresa.listadoCEmpresa);
                ContaAforro.mostrarContas(ContaAforro.listadoCAforro);
                xestionContas();
                break;

            case "2":
                CCPersonal.mostrarContas(CCPersonal.listadoCPersonal);
                xestionContas();

                break;

            case "3":
                CCEmpresa.mostrarContas(CCEmpresa.listadoCEmpresa);
                xestionContas();
                break;

            case "4":
                ContaAforro.mostrarContas(ContaAforro.listadoCAforro);
                xestionContas();

            case "x":
                System.out.println("Volvendo ó menú principal...\n");
                menu();
                break;

            default:
                break;
        }

    }

}
