import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        int opcion;

        do {
            System.out.println("\n===== PLAYLIST CIRCULAR =====");
            System.out.println("1. Agregar cancion al inicio");
            System.out.println("2. Agregar cancion al final");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Seleccionar actual por ID");
            System.out.println("5. Eliminar por ID");
            System.out.println("6. Eliminar cancion actual");
            System.out.println("7. Consultar cancion actual");
            System.out.println("8. Avanzar");
            System.out.println("9. Retroceder");
            System.out.println("10. Mostrar todas");
            System.out.println("11. Cantidad de canciones");
            System.out.println("12. Simular reproduccion (k canciones)");
            System.out.println("0. Salir");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    Cancion c1 = leerCancion();
                    if (c1 != null) {
                        lista.agregarInicio(c1);
                        System.out.println("Agregada: " + c1);
                    }
                    break;
                case 2:
                    Cancion c2 = leerCancion();
                    if (c2 != null) {
                        lista.agregarFinal(c2);
                        System.out.println("Agregada: " + c2);
                    }
                    break;
                case 3:
                    if (vacia(lista)) break;
                    Cancion enc = lista.buscarPorId(leerEntero("ID a buscar: "));
                    System.out.println(enc != null ? "Encontrada: " + enc : "No existe una cancion con ese ID.");
                    break;
                case 4:
                    if (vacia(lista)) break;
                    if (lista.seleccionarActualPorId(leerEntero("ID a seleccionar: "))) {
                        System.out.println("Actual: " + lista.consultarActual());
                    } else {
                        System.out.println("No existe una cancion con ese ID.");
                    }
                    break;
                case 5:
                    if (vacia(lista)) break;
                    System.out.println(lista.eliminarPorId(leerEntero("ID a eliminar: "))
                            ? "Cancion eliminada." : "No existe una cancion con ese ID.");
                    break;
                case 6:
                    if (vacia(lista)) break;
                    Cancion antes = lista.consultarActual();
                    lista.eliminarActual();
                    System.out.println("Eliminada: " + antes);
                    if (lista.getCantidad() > 0) {
                        System.out.println("Nueva actual: " + lista.consultarActual());
                    }
                    break;
                case 7:
                    if (vacia(lista)) break;
                    System.out.println("Actual: " + lista.consultarActual());
                    break;
                case 8:
                    if (vacia(lista)) break;
                    lista.avanzar();
                    System.out.println("Actual: " + lista.consultarActual());
                    break;
                case 9:
                    if (vacia(lista)) break;
                    lista.retroceder();
                    System.out.println("Actual: " + lista.consultarActual());
                    break;
                case 10:
                    lista.mostrarTodos();
                    break;
                case 11:
                    System.out.println("Cantidad: " + lista.getCantidad());
                    break;
                case 12:
                    if (vacia(lista)) break;
                    int k = leerEntero("Cuantas canciones reproducir (k): ");
                    if (k <= 0) {
                        System.out.println("k debe ser mayor que 0.");
                    } else {
                        lista.simularReproduccion(k);
                    }
                    break;
                case 0:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static boolean vacia(ListaCircular lista) {
        if (lista.getCantidad() == 0) {
            System.out.println("La lista esta vacia.");
            return true;
        }
        return false;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    private static Cancion leerCancion() {
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Artista: ");
        String artista = sc.nextLine();
        int duracion = leerEntero("Duracion (segundos): ");
        try {
            return new Cancion(titulo, artista, duracion);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
