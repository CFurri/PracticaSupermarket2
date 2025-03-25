import java.util.Scanner;

public class Main{
//comprovació commit
    public static void menuPrincipal(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in); //Per llegir l'entrada de l'usuari

        //Mostra les opcions del Menú Principal
        System.out.println("Benvingut al Menú Principal"); //Salutació
        System.out.println("1. Gestió de productes"); // Per navegar al menú gestió de productes
        System.out.println("2. Gestió de compres i vendes"); // Per navegar al menú de compres i vendes
        System.out.println("9. Acabar"); // Per acabar el programa

        int navegacio = scanner.nextInt();
        //Navegació del menú
        switch (navegacio) {
            case 1:
                menuDeGestioDeProductes(productes, estocs, numProductes);
                break;
            case 2:
                menuDeGestioDeCompresIVendes(productes, estocs, numProductes);
                break;
            case 9:
                acabarPrograma();
                break;
            default:
                System.out.println("Opció incorrecta. Torna-ho a provar.");
                menuPrincipal(productes, estocs, numProductes);
                break;
        }
    }

    //MENÚ DE GESTIÓ DE PRODUCTES///
    public static void menuDeGestioDeProductes(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvingut al Menú de Gestió de Productes");
        System.out.println("1. Afegir");
        System.out.println("2. Eliminar");
        System.out.println("3. Llistar productes");
        System.out.println("9. Tornar");
        int navegacio = scanner.nextInt();
        switch(navegacio){
            case 1:
                numProductes = afegirProducte(productes, estocs, numProductes);
                break;
            case 2:
                numProductes = eliminarProducte(productes, estocs, numProductes);
                break;
            case 3:
                llistarProductes(productes, estocs, numProductes);
                break;
            case 9:
                tornar(productes, estocs, numProductes);
            default:
                System.out.println("Opció incorrecta. Torna-ho a provar.");
                menuDeGestioDeProductes(productes, estocs, numProductes);
                break;
        }
    }
    public static int afegirProducte(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom del producte: "); //Input per demanar el nom
        String nomNouProducte = scanner.nextLine();
        //Condició per afegir el nou producte
        if (numProductes < productes.length){
            productes[numProductes] = nomNouProducte;
            estocs[numProductes] = 0;
            System.out.println("Producte " + nomNouProducte + " afegit correctament.");
            numProductes++; //Incrementem
        }
        menuDeGestioDeProductes(productes, estocs, numProductes); //Tornem a cridar perquè no acabi el programa
        return numProductes; // Per retornar el valor/índex de productes afegits i que la taula vaig sent coherent

    }
    public static int eliminarProducte(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu el nom del producte que vols eliminar: ");
        String producteAEliminar = scanner.nextLine();
        //Bucle per buscar el producte especificat i eliminar-lo:
        for(int i = 0; i <numProductes; i++){
            if (productes[i].equals(producteAEliminar)){
                for(int j = i; j <numProductes - 1; j++){ //Moure els elements un espai cap a l'esquerra de la taula
                    productes[j] = productes[j+1];
                    estocs[j] = estocs[j + 1];
                }
                productes[numProductes - 1] = null;
                estocs[numProductes - 1] = 0;

                System.out.println(producteAEliminar + " eliminat.");

                numProductes--;

                menuDeGestioDeProductes(productes, estocs, numProductes);
                return numProductes;
            }
        }
        return numProductes;
    }

    public static void llistarProductes(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in);

        if (numProductes == 0) {
            System.out.println("Encara no hi ha productes.");
            return;
        }
        System.out.println("Escriu el número: ");
        int posicio = scanner.nextInt();

        if (posicio == 0) {
            System.out.println("Operació cancel·lada.");
        } else if (posicio >= 1 && posicio <= numProductes) {
            // Aquí podries fer alguna acció amb el producte seleccionat
            System.out.println("Has seleccionat el producte: " + productes[posicio - 1] + " amb " + estocs[posicio - 1] + " unitats en estoc.");
        } else {
            System.out.println("Posició incorrecta. Torna-ho a provar.");
        }
        menuDeGestioDeProductes(productes, estocs, numProductes); //Per tornar directament al menú
    }

    //MENÚ DE GESTIÓ DE COMPRES I VENDES///
    public static void menuDeGestioDeCompresIVendes(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvingut al Menú de Gestió de Compres i Vendes");
        System.out.println("1. Compra");
        System.out.println("2. Venda");
        System.out.println("3. Llistar estocs");
        System.out.println("9. Tornar");
        int navegacio = scanner.nextInt();
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
                break;
            default:
                System.out.println("Opció incorrecta. Torna-ho a provar.");
                menuDeGestioDeCompresIVendes(productes, estocs, numProductes);
                break;
        }
    }
    public static void comprarProducte(String[] productes, int[]estocs, int numProductes){
        String producteAComprar;
        int quantitatProducteAComprar;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quin producte vols comprar?");
        producteAComprar = scanner.nextLine();
        System.out.print("Introdueix la quantitat que vols comprar-ne: ");
        quantitatProducteAComprar = scanner.nextInt();

        int i = 0;
        while (i < numProductes){
            if (productes[i].equals(producteAComprar)){
                estocs[i] += quantitatProducteAComprar;
                System.out.println("Compra realitzada amb èxit.");
                break;
            }
            i++;
        }
        if (i == numProductes){
        System.out.println("El producte que has especificat, no existeix");
        }
        System.out.println("Tornant al menú de Gestió de Compres i Vendes...");
        menuDeGestioDeProductes(productes, estocs, numProductes);

    }
    public static void vendaProducte(String[] productes, int[] estocs, int numProductes){
        Scanner scanner = new Scanner(System.in);
        String productePerVendre;
        int quantitatPerVendre;

        System.out.print("Producte que vols vendre: ");
        productePerVendre = scanner.nextLine();
        System.out.println("Quina quantitat vols vendre del producte " + productePerVendre);
        quantitatPerVendre = scanner.nextInt();

        int i = 0;
        while (i < numProductes){
            if (productes[i].equals(productePerVendre)){
                if (estocs[i] >= quantitatPerVendre){
                    estocs[i] -= quantitatPerVendre;
                    System.out.println("Venta realitzada amb èxit.");
                } else {
                    System.out.println("No hi ha prou estoc per vendre d'aquest producte");
                }
                break;
            }
            i++;
        }
        if (i == numProductes){
            System.out.println("El producte que has especificat, no existeix");
        }
        System.out.println("Tornant al menú de Gestió de Compres i Vendes...");
        menuDeGestioDeProductes(productes, estocs, numProductes);
    }
    public static void llistarEstocs(String[] productes, int[] estocs, int numProductes){
        int i = 0;
        if (numProductes == 0) {
            System.out.println("No hi ha cap producte a la llista.");
            return;
        }
        while (i < numProductes){
            System.out.println("Producte: " + productes[i] + "|| Unitats: " + estocs[i]);
            i++;
        }
    }

    // FUNCIONALITATS DE NAVEGACIÓ//

    public static void tornar(String[] productes, int[] estocs, int numProductes){
        menuPrincipal(productes, estocs, numProductes);
    }
    public static void acabarPrograma(){
        System.out.println("Adeu-siau, quan tornis continuarem fent negocis!");
    }

    // MAIN //
    public static void main (String[] args){
        String[] productes = new String[100];
        int[] estocs = new int[100];
        int numProductes = 0; //Inicialitzem variable numProductes pel control d'índexs i el passem arreu

        //NAVEGACIÓ MENÚ PRINCIPAL///
        menuPrincipal(productes, estocs, numProductes);

    }
}


