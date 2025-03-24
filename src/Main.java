import java.util.Scanner;
public class Main{
//comprovació commit
    public static void menuPrincipal(String[] productes, int[] estocs){
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
                menuDeGestioDeProductes(productes, estocs);
                break;
            case 2:
                menuDeGestioDeCompresIVendes(productes, estocs);
                break;
            case 9:
                acabarPrograma();
                break;
            default:
                System.out.println("Opció incorrecta. Torna-ho a provar.");
                menuPrincipal(productes, estocs);
                break;
        }
    }

    //MENÚ DE GESTIÓ DE PRODUCTES///
    public static void menuDeGestioDeProductes(String[] productes, int[] estocs){
        Scanner scanner = new Scanner(System.in);
        int numProductes = 0; //L'índex de la taula String[]

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
                eliminarProducte(productes, estocs, numProductes);
                break;
            case 3:
                llistarProductes(productes, estocs, numProductes);
                break;
            case 9:
                tornar(productes, estocs);
                break;
            default:
                System.out.println("Opció incorrecta. Torna-ho a provar.");
                menuDeGestioDeProductes(productes, estocs);
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
        menuDeGestioDeProductes(productes, estocs); //Tornem a cridar perquè no acabi el programa
        return numProductes; // Per retornar el valor/índex de productes afegits i que la taula vaig sent coherent

    }
    public static void eliminarProducte(String[] productes, int[] estocs, int numProductes){
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
                return; //Per retornar a la funció que ha fet la crida
            }
        }
    }

    public static void llistarProductes(String[] productes, int[] estocs, int numProductes){
        if (numProductes == 0) {
            System.out.println("Encara no hi ha productes.");
            return;
        }
        for (int i = 0; i < numProductes; i++){
            System.out.println("Producte: " + productes[i] + "|| Estoc: " + estocs[i]);
        }
    }

    //MENÚ DE GESTIÓ DE COMPRES I VENDES///
    public static void menuDeGestioDeCompresIVendes(String[] productes, int[] estocs){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvingut al Menú de Gestió de Compres i Vendes");
        System.out.println("1. Compra");
        System.out.println("2. Venda");
        System.out.println("3. Llistar estocs");
        System.out.println("9. Tornar");
        int navegacio = scanner.nextInt();
        switch(navegacio){
            case 1:
                comprarProducte();
                break;
            case 2:
                vendaProducte();
                break;
            case 3:
                llistarEstocs();
                break;
            case 9:
                tornar(productes, estocs);
                break;
            default:
                System.out.println("Opció incorrecta. Torna-ho a provar.");
                menuDeGestioDeCompresIVendes(productes, estocs);
                break;
        }
    }
    public static void comprarProducte(){

    }
    public static void vendaProducte(){

    }
    public static void llistarEstocs(){

    }

    // FUNCIONALITATS //

    public static void tornar(String[] productes, int[] estocs){
        menuPrincipal(productes, estocs);
    }
    public static void acabarPrograma(){
        System.out.println("Adéu Siau, quan tornis farem negocis!");
    }

    // MAIN //
    public static void main (String[] args){
        String[] productes = new String[100];
        int[] estocs = new int[100];
        //NAVEGACIÓ MENÚ PRINCIPAL///
        menuPrincipal(productes, estocs);

    }
}


