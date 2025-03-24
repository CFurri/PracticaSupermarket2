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

        System.out.println("Benvingut al Menú de Gestió de Productes");
        System.out.println("1. Afegir");
        System.out.println("2. Eliminar");
        System.out.println("3. Llistar productes");
        System.out.println("9. Tornar");
        int navegacio = scanner.nextInt();
        switch(navegacio){
            case 1:
                afegirProducte(productes, estocs);
                break;
            case 2:
                eliminarProducte();
                break;
            case 3:
                llistarProductes();
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
    public static void afegirProducte(String[] productes, int[] estoc){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom del producte: ");
        String nomNouProducte = scanner.nextLine();

    }
    public static void eliminarProducte(){

    }
    public static void llistarProductes(){

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


