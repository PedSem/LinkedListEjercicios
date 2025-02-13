package Canciones;

import java.util.*;

public class MainCanciones {
    private static LinkedList<Cancion>canciones=new LinkedList<>();
    public static ArrayList<Album>albumes=new ArrayList<>();


    public static void main(String[] args) {
       Album album1=new Album("Skillet","John Cooper");
       Album album2=new Album("Evanescence","Amy Lee");
       album1.addSong("Monster",3);
       album1.addSong("Hero",3);
       album1.addSong("Salvation",3);
       albumes.add(album1);

       album2.addSong("Bring me to life",4);
       album2.addSong("Going Under",4);
       album2.addSong("My Immortal",4);
       albumes.add(album2);

       album1.addToPlayList(1,canciones);
       album1.addToPLayList("Hero",canciones);
       album1.addToPLayList("Salvation",canciones);
       album2.addToPLayList("Bring me to life",canciones);
       album2.addToPLayList("Going Under",canciones);
       album2.addToPlayList(3,canciones);
        play(canciones);
    }
    public static void printList(LinkedList<Cancion>cancions){
        Iterator<Cancion>it=cancions.iterator();
        while (it.hasNext()){
            System.out.println("Nodo: " + it.next());

        }
        System.out.println("-----");

    }
    public static void printListAlbum(ArrayList<Album>albumes){
        for(Album album:albumes){
            System.out.println(album);
        }

    }
    public static void addInOrder(LinkedList<Cancion>canciones){
        LinkedList<Cancion>linkedListOrdenado=new LinkedList<>(canciones);
        Collections.sort(linkedListOrdenado);
        for(Cancion cancion:linkedListOrdenado){
            System.out.println(cancion);
        }





    }
    public static void play(LinkedList<Cancion>cancions){
        Scanner scanner=new Scanner(System.in);
        boolean continuar=true;
        ListIterator<Cancion>cancionListIterator=cancions.listIterator();
        if(cancions.isEmpty()){
            System.out.println("No hay canciones disponible");
            return;
        }else{
            System.out.println("Cancion " + cancionListIterator.next());
            imprimirmenu();


        }
        boolean haciaAdelante=true;
        while (continuar){
                int opcion= scanner.nextInt();
                scanner.nextLine();
            switch (opcion){
                case 0:
                    System.out.println("Se acabaron las canciones");
                    continuar=false;
                    break;
                case 1:
                    if(!haciaAdelante){
                        if(cancionListIterator.hasNext())
                            cancionListIterator.next();
                        haciaAdelante=true;


                    }
                    if(cancionListIterator.hasNext()){
                        System.out.println("Cancion " + cancionListIterator.next());

                    }else{
                        System.out.println("No hay mas canciones");
                        haciaAdelante=false;
                    }
                    break;
                case 2:
                    if(haciaAdelante){
                        if(cancionListIterator.hasPrevious())
                            cancionListIterator.previous();
                        haciaAdelante=false;
                    }
                    if(cancionListIterator.hasPrevious()){
                        System.out.println("Cancion " + cancionListIterator.previous());
                    }else{
                        System.out.println("Primer cancion");
                        haciaAdelante=true;
                    }
                    break;
                case 3:
                    if(haciaAdelante && cancionListIterator.hasPrevious()){
                        System.out.println("Reproduciendo " + cancionListIterator.previous());
                        haciaAdelante=false;
                    }else if(!haciaAdelante && cancionListIterator.hasNext()){
                        System.out.println("Reproduciendo " + cancionListIterator.next());
                        haciaAdelante=true;
                    }
                    break;
                case 4:
                    printList(canciones);
                    break;
                case 5:
                    imprimirmenu();
                    break;
                case 6:
                    if(cancionListIterator.hasNext() || cancionListIterator.hasPrevious()){
                        cancionListIterator.remove();
                        if(cancionListIterator.hasNext()){
                            System.out.println("Reproduciendo " + cancionListIterator.next());

                        }else if(cancionListIterator.hasPrevious()){
                            System.out.println("Reproduciendo " + cancionListIterator.previous());


                        }else{
                            System.out.println("El album esta vacio");
                        }
                    }
                    break;
                case 7:
                    printListAlbum(albumes);
                    break;
                case 8:
                    addInOrder(canciones);
                    break;

            }
        }
    }
    public static void imprimirmenu(){
        System.out.println("0-Salir de la lista de reproduccion");
        System.out.println("1-Reproducir siguiente cancion de la lista");
        System.out.println("2-Reproducir cancion previa de la lista");
        System.out.println("3-Repetir la cancion actual");
        System.out.println("4-Imprimir la lista de canciones en la playlist");
        System.out.println("5-Volver a imprimir el menu");
        System.out.println("6-Eliminar la cancion del album");
        System.out.println("7-Imprimir Album con las canciones");
        System.out.println("8-Ordenar Canciones");
    }

}
