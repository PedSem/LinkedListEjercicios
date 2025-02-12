package Canciones;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    protected String nombre;
    protected String artista;
    protected ArrayList<Cancion>canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones=new ArrayList<>();
    }
    private Cancion findSong(String titulo){
        for(int i=0;i<this.canciones.size();i++){
            for(Cancion cancion:canciones){
                if(this.canciones.get(i).getTitulo().equals(titulo)){
                    return cancion;
                }
            }
        }
        return null;
    }
    public boolean addSong(String titulo,double duracion){
        Cancion cancion=findSong(titulo);
        if(cancion==null){
            this.canciones.add(new Cancion(titulo,duracion));
            return true;
        }
       return false;

    }
    public boolean addToPlayList(int numeropista, LinkedList<Cancion>cancions){
        for(Cancion cancion1:canciones){
            cancions.add(numeropista,cancion1);
            return true;
        }
        return false;

    }
    public boolean addToPLayList(String titulo,LinkedList<Cancion>cancions){
        Cancion cancion=findSong(titulo);
        return true;

    }
}
