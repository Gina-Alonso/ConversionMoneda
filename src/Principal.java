import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int opcion= 0;
        while (opcion!= 7) {
            System.out.println("_______________Conversor de Monedas________________");
            System.out.println("""
                    1. MXN(PESO MEXICANO) -> JPY(YEN JAPONES)
                    2. MXN(PESO MEXICANO)-> CAD(DOLAR CANADIENSE)
                    3. MXN(PESO MEXICANO -> KRW(WON COREANO)
                    4. MXN(PESO MEXICANO) -> EUR(EURO)
                    5. MXN(PESO MEXICANO) -> RUB(RUBLO RUSO)
                    6. MXN(PESO MEXICANO) -> USD(DOLAR ESTADOUNIDENSE)
                    7. SALIR""");

            try {
                System.out.println("Elija una opcion del 1 al 6 para hacer la conversion o 7 para salir: ");
                opcion = sc.nextInt();
                sc.nextLine();
                CambioMoneda cambioMoneda = new CambioMoneda();
                Moneda moneda = cambioMoneda.buscarCambio(System.getenv("api_key"));

                switch (opcion){
                    case 1:
                        System.out.println("○ "+cambioMoneda.conversion(moneda.conversion_rates().get("JPY"))+ "JPY");
                        break;
                    case 2:
                        System.out.println("○ "+cambioMoneda.conversion(moneda.conversion_rates().get("CAD"))+ "CAD");
                        break;
                    case 3:
                        System.out.println("○ "+cambioMoneda.conversion(moneda.conversion_rates().get("KRW"))+ "KRW");
                        break;
                    case 4:
                        System.out.println("○ "+cambioMoneda.conversion(moneda.conversion_rates().get("EUR"))+ "EUR");
                        break;
                    case 5:
                        System.out.println("○ "+cambioMoneda.conversion(moneda.conversion_rates().get("RUB"))+ "RUB");
                        break;
                    case 6:
                        System.out.println("○ "+cambioMoneda.conversion(moneda.conversion_rates().get("USD"))+ "USD");
                    case 7:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida del 1 al 7");
                }

            }catch (InputMismatchException e){
                System.out.println("Solo ingrese numeros ");
                sc.nextLine();
            }



        }
    }
}
