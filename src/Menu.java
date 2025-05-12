import java.util.Scanner;

public class Menu {

    private final String monedasDisponibles = """
                USD --- Dólar Estadounidense
                ARS --- Peso Argentino
                BRL --- Real Brasileño
                COP --- Peso Colombiano
                EUR --- Euro
                """;

    public void mostrarMenu() {
        //System.out.println("*****************************************");
        System.out.println("A continuación ingrese la opción que desea realizar:\n");
        String menuPrincipal = """
                1) Realizar una conversión
                2) Salir
                """;
        System.out.println(menuPrincipal);
    }

    public int leerMenu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elija una opción:");
        System.out.println("*****************************************");
        return teclado.nextInt();
    }

    public void mostrarMenuMonedas(String moneda) {
        System.out.println("*****************************************");
        System.out.println("Seleccione la moneda " + moneda + ":\n");
        System.out.println(monedasDisponibles);
        System.out.println("*****************************************");
    }

    public String leerMenuMonedas() {
        Scanner teclado = new Scanner(System.in);
        String opcion = teclado.nextLine().toLowerCase();
        while (!monedasDisponibles.toLowerCase().contains(opcion)) {
            System.out.println("La opción ingresada no está disponible");
            System.out.println("Vuelva a ingresar una opción válida");
            System.out.println("*****************************************");
            opcion = teclado.nextLine().toLowerCase();
        }
        return opcion.toUpperCase();
    }

    public void mostrarCantidadACambiar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("*****************************************");
        System.out.println("Ingrese la cantidad a cambiar:");
        System.out.println("*****************************************");
    }

    public double leerCantidadACambiar() {
        Scanner teclado = new Scanner(System.in);
        double cantidad;
        while (!teclado.hasNextDouble()) {//Sirve para validar la entrada antes de intentar leerla con nextDouble() y así evitar que tu programa se rompa con una excepción (InputMismatchException).
            System.out.println("***********************************************");
            System.out.println("La cantidad ingresada no es un número válido");
            System.out.println("Ingrese una cantidad válida");
            System.out.println("***********************************************");
            teclado.nextLine();
        }
        cantidad = teclado.nextDouble();
        teclado.nextLine();
        return cantidad;
    }

    public Double resultadoConversion(String monedaBase, String monedaFinal, double cantidad, Double tasa) {
        Double resultado = cantidad * tasa;
        System.out.println("***********************************************");
        System.out.println(cantidad + " " + monedaBase + " equivale a: " + resultado + " " + monedaFinal);
        System.out.println("***********************************************");
        return resultado;
    }

}
