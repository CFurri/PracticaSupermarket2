import java.util.Scanner;
public class Main{

    public static void menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        //Per llegir l'entrada de l'usuari

        //Mostra les opcions del Menú Principal
        System.out.println("Benvingut al Menú Principal"); //Salutació
        System.out.println("1. Gestió de productes"); // Per navegar al menú gestió de productes
        System.out.println("2. Gestió de compres i vendes"); // Per navegar al menú de compres i vendes
        System.out.println("9. Acabar"); // Per acabar el programa

        int navegacio = scanner.nextInt();
        //Navegació del menú
        switch (navegacio) {
            case 1:
                menuDeGestioDeProductes();
                break;
            case 2:
                menuDeGestioDeCompresIVendes();
                break;
            case 9:
                acabarPrograma();
                break;
        }
    }

    //MENÚ DE GESTIÓ DE PRODUCTES///
    public static void menuDeGestioDeProductes(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvingut al Menú de Gestió de Productes");
        System.out.println("Introdueix el número per dir on vols navegar: ");
        System.out.println("1. Afegir");
        System.out.println("2. Eliminar");
        System.out.println("3. Llistar productes");
        System.out.println("9. Tornar");
        int navegacio = scanner.nextInt();
        switch(navegacio){
            case 1:
                afegirProducte();
                break;
            case 2:
                eliminarProducte();
                break;
            case 3:
                llistarProductes();
                break;
            case 9:
                tornar();
                break;
        }
    }
    public static void afegirProducte(){

    }
    public static void eliminarProducte(){

    }
    public static void llistarProductes(){

    }

    //MENÚ DE GESTIÓ DE COMPRES I VENDES///
    public static void menuDeGestioDeCompresIVendes(){

    }
    public static void compraProducte(){

    }
    public static void vendaProducte(){

    }
    public static void llistarEstocs(){

    }

    // FUNCIONALITATS //

    public static void tornar(){
        menuPrincipal();
    }
    public static void acabarPrograma(){
        System.out.println("Adéu Siau, quan tornis farem negocis!");
        return;
    }
    public static void main (String[] args){

        //MENÚ PRINCIPAL///
        menuPrincipal();

    }
}


