package Canciones;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    protected String nombre;
    protected String artista;
    protected ArrayList<Cancion>canciones=new ArrayList<>();

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones=new ArrayList<>();
    }
    private Cancion findSong(String titulo){
        for(Cancion cancion:canciones){
            if(cancion.getTitulo().equals(titulo)){
                return cancion;
            }
        }
        return null;
    }
    public boolean addSong(String titulo,double duracion){
        Cancion cancion=findSong(titulo);
        for(Cancion cancion1:canciones){

            if(!cancion1.equals(cancion)){
                return false;
            }
        }
        canciones.add(new Cancion(titulo,duracion));
        return true;

    }
    public boolean addToPlayList(int numeropista, LinkedList<Cancion>cancions){
        for(Cancion cancion:canciones){
            cancions.add(numeropista,cancion);
            return true;
        }
        return false;

    }
    public boolean addToPLayList(String titulo,LinkedList<Cancion>cancions){
        Cancion cancion1=findSong(titulo);
        for(Cancion cancion:canciones){
            if(cancion.equals(cancion1)){
                cancions.add(cancion);
                return true;
            }
        }
        return false;

    }
}
