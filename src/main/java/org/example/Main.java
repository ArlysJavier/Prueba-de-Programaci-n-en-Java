package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Mostrar catálogo");
            System.out.println("5. Mostrar libros prestados");
            System.out.println("6. Salir");
            System.out.print("Por favor, Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación del libro: ");
                    int anoPublicacion = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.agregarLibro(new Libro(titulo, autor, anoPublicacion));
                    System.out.println("Libro agregado con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese el identificador del usuario: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestamo = scanner.nextLine();
                    try {
                        biblioteca.prestarLibro(nombreUsuario, idUsuario, tituloPrestamo);
                        System.out.println("Libro prestado correctamente a" + "-" + nombreUsuario);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolucion = scanner.nextLine();
                    try {
                        for (Libro libro : biblioteca.librosPrestados.keySet()) {
                            if (libro.getTitulo().equals(tituloDevolucion)) {
                                biblioteca.devolverLibro(libro);
                                System.out.println("Libro devuelto con éxito.");
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    biblioteca.mostrarCatalogoCompleto();
                    break;
                case 5:
                    biblioteca.mostrarLibrosPrestados();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    }
