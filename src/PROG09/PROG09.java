package PROG09;

import static PROG09.Ferramentas.seleccion;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Dregoth
 */
public class PROG09 {

    static ArrayList<Conta> listadoPersoal = new ArrayList<>();
    static ArrayList<Conta> listadoEmpresa = new ArrayList<>();
    static ArrayList<Conta> listadoAforro = new ArrayList<>();
    public static ArrayList<String> listadoNumerosCC = new ArrayList<String>();

    public static void menu() throws Exception {
        String seleccion;

        do {

            System.out.println("\n---- Xestión de contas v0.1 ----");
            System.out.println("");
            System.out.println("Elixa unha opción: ");
            System.out.println("1. Crear conta CORRIENTE.");
            System.out.println("2. Crear conta AFORRO.");
            System.out.println("3. Xestión de contas.");
            System.out.println("X. Saír do programa.");
            System.out.print("Selección: ");
            seleccion = Ferramentas.seleccion();

            switch (seleccion) {
                case "1":
                    ContaCorriente.crearCC();
                    break;
                case "2":
                    ContaAforro.crearCAforro();
                    break;
                case "3":
                    xestionContas();
                    break;
                default:
                    break;
            }

        } while (!"x".equals(seleccion));
        System.out.println("\nCerrando programa...");
        System.exit(0);
    }

    static void xestionContas() throws Exception {

        String seleccion;
        do {
            System.out.println("\n---- Xestión de contas almacenadas ----");
            System.out.println("");
            System.out.println("Elixa unha opción: ");
            System.out.println("1. Mostrar todo.");
            System.out.println("2. Mostrar contas PERSONALES.");
            System.out.println("3. Mostrar contas de EMPRESA.");
            System.out.println("4. Mostrar contas de AFORRO.");
            System.out.println("X. Volver.");
            System.out.print("Selección: ");
            seleccion = seleccion();

            switch (seleccion) {
                case "1":
                    System.out.println("\n---- Listado de tódalas contas almacenadas ----\n");
                    mostrarConta(listadoPersoal, "PERSONALES");
                    mostrarConta(listadoEmpresa, "EMPRESA");
                    mostrarConta(listadoAforro, "AFORRO");
                    break;

                case "2":
                    mostrarConta(listadoPersoal, "PERSONALES");
                    break;

                case "3":
                    mostrarConta(listadoEmpresa, "EMPRESA");
                    break;

                case "4":
                    mostrarConta(listadoAforro, "AFORRO");
                    break;
                default:
                    break;
            }
        } while (!"x".equals(seleccion));
        System.out.println("Volvendo ó menú principal...\n");

    }

    protected static void mostrarConta(ArrayList<Conta> listadoContas, String tipoConta) {

        System.out.println("\n-- Contas " + tipoConta + " almacenadas: ");
        for (int i = 0; i < listadoContas.size(); i++) {
            System.out.println("Conta " + (i + 1) + ". ");
            System.out.println(listadoContas.get(i).getNumCuenta());
            System.out.println(listadoContas.get(i).getPersona());
            System.out.println(listadoContas.get(i).getSaldo());
            System.out.println("");
        }
    }
    
    // método que devolve true ou false, condición da que depende si continuamos engadindo contas
    public static boolean crearNovaConta(String tipoConta) {
        String resposta;
        System.out.print("Desexa introducir outra conta " + tipoConta + "? ");

        do {
            System.out.print("(s/n)");
            resposta = Ferramentas.seleccion().toLowerCase();
        } while (!"s".equals(resposta) && !"n".equals(resposta));

        return "s".equals(resposta);
    }

    // introduce datos dunha ou máis entidades nun Hashtable
    public static void main(String[] args) throws Exception {

        System.out.println("Creando contas de proba...");
        Hashtable<String, Double> entidadesTest1 = new Hashtable<String, Double>();
        Hashtable<String, Double> entidadesTest2 = new Hashtable<String, Double>();
     
        entidadesTest1.put("Fenosa", 50.0);
        entidadesTest2.put("Movistar", 30.0);

        Pagos pagos1 = new Pagos(entidadesTest1);
        Pagos pagos2 = new Pagos(entidadesTest2);

        Persona personaTest1 = new Persona("PACO", "YUBAS", "12/12/18");
        Persona personaTest2 = new Persona("maría", "patiño", "14/2/99");
        Persona personaTest3 = new Persona("Manolo", "O do Bombo", "17/01/2001");

        NumeroCCC numCTest1 = new NumeroCCC("00491500051234567892");
        NumeroCCC numCTest2 = new NumeroCCC("00302053091234567895");
        NumeroCCC numCTest3 = new NumeroCCC("20805801101234567891");

        // creo unha conta de cada para que quede almacenada por defecto
        CCPersonal personal1 = new CCPersonal(10, pagos1, personaTest1, 1000, numCTest1);
        CCPersonal.engadirPersonal(personal1);

        CCEmpresa empresa1 = new CCEmpresa(10, 15, 20, pagos2, personaTest2, 2000, numCTest2);
        CCEmpresa.engadirEmpresa(empresa1);

        ContaAforro aforro1 = new ContaAforro(30, personaTest3, 3000, numCTest3);
        ContaAforro.engadirAforro(aforro1);

        System.out.println("");

        System.out.println("Números CCC almacenados: " + listadoNumerosCC);

        
        menu();

    }

}
