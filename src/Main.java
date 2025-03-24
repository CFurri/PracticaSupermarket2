import java.util.Scanner;
public class Main{

    public static void menuPrincipal(){

    }
    public static void gestioDeProductes(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Gestió de productes");
        System.out.println("2. Gestió de compres i vendes");
        System.out.println("9. Acabar");

        int navegacio = scanner.nextInt();
        switch(navegacio){
            case 1:
                menuDeGestioDeProductes();
                break;
            case 2:
                menuDeGestioDeCompresIVendes();
                break;
            case 9:
                acabar();
        }
    }
    public static void gestioDeCompresIVendes(){

    }

    //MENÚ DE GESTIÓ DE PRODUCTES///
    public static void menuDeGestioDeProductes(){

    }
    public static void afegir(){

    }
    public static void eliminar(){

    }
    public static void llistarProductes(){

    }
    public static void tornar(){

    }

    //MENÚ DE GESTIÓ DE COMPRES I VENDES///
    public static void menuDeGestioDeCompresIVendes(){

    }
    public static void compra(){

    }
    public static void venda(){

    }
    public static void llistarEstocs(){

    }
    public static void acabar(){

    }
    public static void main (String[] args){

        //MENÚ PRINCIPAL///
        menuPrincipal();
        gestioDeProductes();
        gestioDeCompresIVendes();

        //MENÚ DE GESTIÓ DE PRODCUTES///
        menuDeGestioDeProductes();
        afegir();
        eliminar();
        llistarProductes();
        tornar();

        //MENÚ DE GESTIÓ DE COMPRES I VENDES///
        menuDeGestioDeCompresIVendes();
        compra();
        venda();
        llistarEstocs();
        tornar();


        // MOC acabar(); per fer una sortida més simple
        acabar();


    }

}


