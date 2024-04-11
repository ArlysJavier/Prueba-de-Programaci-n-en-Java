package org.example;

class Libro {
    private int anoPublicacion;
    private String titulo;
    private String autor;


    public Libro(String titulo, String autor, int anoPublicacion) {
        this.titulo = titulo;
        this.anoPublicacion = anoPublicacion;
        this.autor = autor;

    }
    public int getAnoPublicacion() {
        return anoPublicacion;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }


}
