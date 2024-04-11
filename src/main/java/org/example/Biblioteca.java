package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    List<Libro> librosDisponibles;
    Map<Libro, Usuario> librosPrestados;

    public Biblioteca() {
        librosDisponibles = new ArrayList<>();
        librosPrestados = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }

    public void prestarLibro(String nombreUsuario, int idUsuario, String tituloLibro) throws Exception {
        Usuario usuario = new Usuario(nombreUsuario, idUsuario);
        Libro libro = null;
        for (Libro l : librosDisponibles) {
            if (l.getTitulo().equals(tituloLibro)) {
                libro = l;
                break;
            }
        }
        if (libro != null) {
            librosDisponibles.remove(libro);
            librosPrestados.put(libro, usuario);
        } else {
            throw new Exception("El libro no está disponible para prestamo.");
        }
    }

    public void devolverLibro(Libro libro) throws Exception {
        if (librosPrestados.containsKey(libro)) {
            librosPrestados.remove(libro);
            librosDisponibles.add(libro);
        } else {
            throw new Exception("El libro no está prestado.");
        }
    }

    public void mostrarCatalogoCompleto() {
        System.out.println("Catálogo completo de la biblioteca de Libros:");
        for (Libro libro : librosDisponibles) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getAnoPublicacion());
        }
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros prestados a la Fecha:");
        for (Map.Entry<Libro, Usuario> entry : librosPrestados.entrySet()) {
            Libro libro = entry.getKey();
            Usuario usuario = entry.getValue();
            System.out.println(libro.getTitulo() + " - " + usuario.getNombre());
        }
    }
}
