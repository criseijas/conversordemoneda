public class Principal {
    public static void main(String[] args) {

        int opcionUsuario = 0;
        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("*****************************************");
        System.out.println("*** Bienvenid@ al conversor de moneda ***");
        System.out.println("*****************************************\n");

        while (opcionUsuario != 2) {

            Menu menu = new Menu();
            menu.mostrarMenu();
            opcionUsuario = menu.leerMenu();

            switch (opcionUsuario) {

                case 1:
                    menu.mostrarMenuMonedas("inicial:");
                    String monedaBase = menu.leerMenuMonedas();
                    menu.mostrarMenuMonedas("final:");
                    String monedaFinal = menu.leerMenuMonedas();
                    menu.mostrarCantidadACambiar();
                    double cantidad = menu.leerCantidadACambiar();
                    Conversor conversor = consulta.buscaMoneda(monedaBase);
                    Double tasaConversion = conversor.getTasaDeConversion(monedaFinal.toUpperCase());
                    Double resultadoFinal = menu.resultadoConversion(monedaBase, monedaFinal, cantidad, tasaConversion);
                    break;

                case 2:
                    System.out.println("¡Gracias por utilizar el conversor de moneda!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú");
            }


        }

    }
}
