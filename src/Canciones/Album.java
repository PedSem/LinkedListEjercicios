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
            for(Cancion cancion:canciones){
                if(cancion.getTitulo().equals(titulo)){
                    return cancion;
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
        int index=numeropista-1;
        if(index>=0 && index<canciones.size()){
            cancions.add(canciones.get(index));
            return true;
        }else{
            return false;
        }

    }
    public boolean addToPLayList(String titulo,LinkedList<Cancion>cancions){
        Cancion cancion=findSong(titulo);
        if(cancion!=null){
                cancions.add(cancion);
                return true;

        }else{
            return false;
        }

    }
}
