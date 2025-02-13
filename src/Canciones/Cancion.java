package Canciones;

public class Cancion {
    protected String titulo;
    protected double duracion;

    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "\ntitulo:'" + titulo + '\'' +
                "duracion " + duracion;

    }

}
