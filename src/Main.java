import java.util.Scanner;

/**
 * @author CARLES FURRIOLS FURRIOLS - PRÀCTICA 1
 * <p>Carles github<a href="https://github.com/CFurri/PracticaSupermarket2"></a></p>
 */

public class Main{
    /**
     * Menú principal: Permet la gestió entre els submenús.
     * Mostra les opcions principals i gestiona la navegació entre menús.
     *
     * @param productes Array que emmagatzema els noms dels productes
     * @param estocs Array que emmagatzema les quantitats en estoc de cada producte
     * @param numProductes Nombre de productes actual al supermercat
     */
    public static void menuPrincipal(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in); //Per llegir l'entrada de l'usuari l'Scanner local

        //Mostra les opcions del Menú Principal
        System.out.println("Benvingut al Menú Principal"); //Salutació
        System.out.println("1. Gestió de productes"); // Per navegar al menú gestió de productes
        System.out.println("2. Gestió de compres i vendes"); // Per navegar al menú de compres i vendes
        System.out.println("9. Acabar"); // Per acabar el programa

        int navegacio = scanner.nextInt();
        //Navegació del menú - Gestiona l'opció triada per l'usuari
        switch (navegacio) {
            case 1:
                menuDeGestioDeProductes(productes, estocs, numProductes);
                break;
            case 2:
                menuDeGestioDeCompresIVendes(productes, estocs, numProductes);
                break;
            case 9:
                acabarPrograma();
                return;
            default:
                System.out.println("Opció incorrecta. Torna-ho a provar.");
                menuPrincipal(productes, estocs, numProductes);
                break;
        }
    }
    /**
     *MENÚ DE GESTIÓ DE PRODUCTES: Permet afegir, eliminar i llistar els productes de l'array
     * La funció rep l'array de productes i d'estocs. A més el nombre de productes que hi ha
     */
    public static void menuDeGestioDeProductes(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in); //Scanner local

        System.out.println("Benvingut al Menú de Gestió de Productes");
        System.out.println("1. Afegir");
        System.out.println("2. Eliminar");
        System.out.println("3. Llistar productes");
        System.out.println("9. Tornar");
        int navegacio = scanner.nextInt(); //Input de l'usuari per navegar pels submenús
        switch(navegacio){
            case 1:
                afegirProducte(productes, estocs, numProductes);
                break;
            case 2:
                eliminarProducte(productes, estocs, numProductes);
                break;
            case 3:
                llistarProductes(productes, estocs, numProductes);
                break;
            case 9:
                tornar(productes, estocs, numProductes);
                return;
            default:
                System.out.println("Opció incorrecta. Torna-ho a provar.");
                menuDeGestioDeProductes(productes, estocs, numProductes); //Per tornar d'on hem vingut
                break;
        }
    }

    /** AFEGIR PRODUCTES
     * Funció per afegir un nou producte a la llista de productes String[] productes
     * La funció rep l'array de productes i d'estocs. A més el nombre de productes que hi ha
     */
    public static void afegirProducte(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in); //Scanner local

        System.out.println("Nom del producte: ");
        String nomNouProducte = scanner.nextLine(); //Input per demanar el nom
        //Condició per afegir el nou producte
        if (numProductes < productes.length){
            productes[numProductes] = nomNouProducte;
            estocs[numProductes] = 0;
            System.out.println("Producte " + nomNouProducte + " afegit correctament.");
            numProductes++; //Incrementem
        }
        menuDeGestioDeProductes(productes, estocs, numProductes); //Tornem a cridar perquè no acabi el programa
    }

    /** ELIMINAR PRODUCTES
     * Elimina un producte de la llista de productes String [] productes
     * a funció rep l'array de productes i d'estocs. A més el nombre de productes que hi ha
     * Retorna el nombre de productes després d'eliminar-lo.
     */
    public static void eliminarProducte(String[] productes, int[] estocs, int numProductes) {
        Scanner scanner = new Scanner(System.in); //Scanner local

        if (numProductes == 0) { //Torna enrere si no hi ha productes a la llista per eliminar
            System.out.println("No hi ha productes per eliminar.");
        }
        System.out.print("Introdueix el número del producte a eliminar. Va de 1 a " + numProductes + "): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Neteja el buffer
        // Per veure si l'índex existeix dins la llista
        if (index < 0 || index >= numProductes) {
            System.out.println("Índex no existeix.");

        }
        //Desplaça els productes posteriors respecte del producte eliminat
        for (int i = index; i < numProductes - 1; i++) {
            productes[i] = productes[i + 1];
            estocs[i] = estocs[i + 1];
        }

        // Esborro l'últim element per evitar duplicats
        productes[numProductes - 1] = "";
        estocs[numProductes - 1] = -1;

        System.out.println("El producte ja s'ha esborrat" );
        menuDeGestioDeProductes(productes, estocs, numProductes);
    }

    /** LLISTAR PRODUCTES
     * Per ensenyar els productes de l'array
     * La funció rep l'array de productes i d'estocs. A més el nombre de productes que hi ha
     */
    public static void llistarProductes(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in); //Scanner local
        // Si no hi ha productes a la llista, tornem enrere.
        if (numProductes == 0) {
            System.out.println("Encara no hi ha productes.");
            return;
        }
        System.out.print("Escriu la posició del producte que vols buscar: ");
        int posicio = scanner.nextInt(); //Variable per saber la posició del producte que triem buscar.

        if (posicio == 0) {
            System.out.println("Operació cancel·lada.");
        } else if (posicio >= 1 && posicio <= numProductes) {
            // Aquí podries fer alguna acció amb el producte seleccionat
            System.out.println("Has seleccionat el producte: " + productes[posicio - 1] + " amb " + estocs[posicio] + " unitats en estoc.");
        } else {
            System.out.println("Posició incorrecta. Torna-ho a provar.");
        }
        menuDeGestioDeProductes(productes, estocs, numProductes); //Per tornar directament al menú
    }

    /**
     * MENÚ DE GESTIÓ DE COMPRES I VENDES
     * La funció rep l'array de productes i d'estocs. A més el nombre de productes que hi ha
     */
    public static void menuDeGestioDeCompresIVendes(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in); //Scanner local

        System.out.println("Benvingut al Menú de Gestió de Compres i Vendes");
        System.out.println("1. Compra");
        System.out.println("2. Venda");
        System.out.println("3. Llistar estocs");
        System.out.println("9. Tornar");
        int navegacio = scanner.nextInt(); //Variable que agafa l'input de l'usuari per poder navegar on digui
        switch(navegacio){
            case 1:
                comprarProducte(productes, estocs, numProductes);
                break;
            case 2:
                vendaProducte(productes, estocs, numProductes);
                break;
            case 3:
                llistarEstocs(productes, estocs, numProductes);
                break;
            case 9:
                tornar(productes, estocs, numProductes);
                return;
            default:
                System.out.println("Opció incorrecta. Torna-ho a provar.");
                menuDeGestioDeCompresIVendes(productes, estocs, numProductes);
                break;
        }
    }

    /** COMPRAR PRODUCTES
     * comprarProducte() -> Fa una compra del producte especificat per l'usuari i incrementa l'estoc d'aquest.
     * La funció rep l'array de productes i d'estocs. A més el nombre de productes que hi ha
     */
    public static void comprarProducte(String[] productes, int[]estocs, int numProductes){
        String producteAComprar; //Variable per preguntar a l'usuari de quin producte en vol fer la compra
        int quantitatProducteAComprar; //Variable per conèixer el número d'unitats que vol comprar de producte
        Scanner scanner = new Scanner(System.in);
        System.out.println("De quin producte vols fer la compra?");
        producteAComprar = scanner.nextLine();
        System.out.print("Introdueix la quantitat que vols comprar-ne: ");
        quantitatProducteAComprar = scanner.nextInt();
        //Cerca del producte especificat
        int i = 0;
        while (i < numProductes){
            if (productes[i].equals(producteAComprar)){
                estocs[i] += quantitatProducteAComprar;
                System.out.println("Compra realitzada amb èxit.");
                menuDeGestioDeProductes(productes, estocs, numProductes);
                break;
            }
            i++;
        }

        //Si no es troba el producte...
        if (i == numProductes){
        System.out.println("El producte que has especificat, no existeix");
        menuDeGestioDeProductes(productes, estocs, numProductes);
        }
        System.out.println("Tornant al menú de Gestió de Compres i Vendes...");
        menuDeGestioDeProductes(productes, estocs, numProductes);
    }

    /**VENDA PRODUCTE
     * Funció vendaProducte() -> permet vendre producte fent que disminueixi l'estoc del producte en qüestió
     * La funció rep l'array de productes i d'estocs. A més el nombre de productes que hi ha
     */
    public static void vendaProducte(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in); //Scanner local
        String productePerVendre; //Variable que emmagatzema el producte que indiqui l'usuari
        int quantitatPerVendre; //Variable que emmagatzema la quantitat de producte que serà venut. Es restarà de l'estoc actual

        System.out.print("Producte que vols vendre: ");
        productePerVendre = scanner.nextLine();
        System.out.println("Quina quantitat vols vendre del producte " + productePerVendre);
        quantitatPerVendre = scanner.nextInt();
        //Cerca del producte
        int i = 0;
        while (i < numProductes){
            if (productes[i].equals(productePerVendre)){
                if (estocs[i] >= quantitatPerVendre){ //Indica estoc suficient
                    estocs[i] -= quantitatPerVendre;
                    System.out.println("Venta realitzada amb èxit.");
                } else {
                    System.out.println("No hi ha prou estoc per vendre d'aquest producte");
                }
                break;
            }
            i++;
        }
        //Missatge en cas de no trobar-se el producte
        if (i == numProductes){
            System.out.println("El producte que has especificat, no existeix");
        }
        System.out.println("Tornant al menú de Gestió de Compres i Vendes...");
        menuDeGestioDeProductes(productes, estocs, numProductes);
    }

    /**
     * Funció llistarEstocs() -> permet a l'usuari veure tots els productes i quantitats que hi ha a les llistes.
     * La funció rep l'array de productes i d'estocs. A més el nombre de productes que hi ha.
     */
    public static void llistarEstocs(String[] productes, int[] estocs, int numProductes){
        int i = 0;  //Variable per recórrer pels índexs
        if (numProductes == 0) { // Si no hi ha productes entrats, el programa torna a la funció que l'ha cridat.
            System.out.println("No hi ha cap producte a la llista.");
            return;
        }
        //Es llisten els estocs i es mostren per consola
        while (i < numProductes){
            System.out.println("Producte: " + productes[i] + "|| Unitats: " + estocs[i]);
            i++;
        }
        menuDeGestioDeCompresIVendes(productes, estocs, numProductes);
    }


    /** FUNCIONALITATS DE NAVEGACIÓ
     * Tornar
     * Torna al menú principal
     * La funció rep l'array de productes i d'estocs. A més, el nombre de productes que hi ha
     */
    public static void tornar(String[] productes, int[] estocs, int numProductes){
        menuPrincipal(productes, estocs, numProductes);
    }

    /** Funció acabarPrograma()
     * Finalitza el programa amb un missatge.
     */
    public static void acabarPrograma(){
        System.out.println("Adeu-siau, quan tornis continuarem fent negocis!");
    }



    /** MAIN!
     * Mètode principal que inicialitza el programa
     * S'hi defineixen 3 variables importants que seran utilitzades durant tot el programa
     * S'hi defineix la llista de productes on s'hi guardaran els noms dels productes que entri l'usuari
     * La llista d'estocs per guardar les quantitats de cada producte. També les entra l'usuari
     * Es declara la variable numProductes per conèixer el nombre de productes que hi ha guardats. Ens permetrà diferents funcionalitats.
     * A partir del menú principal es podrà navegar per tot el programa.
     */
    public static void main (String[] args){
        String[] productes = new String[100]; //Variable llista on es guardaran els noms dels productes
        int[] estocs = new int[100]; //Variable llista on es guardaran les quantitats de cada producte
        int numProductes = 0; //Inicialitzem variable numProductes pel control d'índexs i el passem arreu

        //Navegació al Menú Principal
        menuPrincipal(productes, estocs, numProductes);

    }
}


