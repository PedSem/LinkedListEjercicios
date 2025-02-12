package Canciones;

import java.util.*;

public class MainCanciones {
    private static LinkedList<Cancion>canciones=new LinkedList<>();
    private static Album album=new Album("Hola","P");
    public static ArrayList<Album>albumes=new ArrayList<>();

    public static void main(String[] args) {

        Cancion cancion1=new Cancion("Monster",3);
       Cancion cancion2=new Cancion("Bring me to life",4);
       Cancion cancion3=new Cancion("Monster",3);
       Album album1=new Album("SKillet","John Cooper");
       Album album2=new Album("Evanescence","Amy Lee");
       album1.addSong("Monster",3);
       album2.addSong("Bring me to life",4);
       album1.addToPlayList(0,canciones);
       album2.addToPLayList("Bring me to life",canciones);
        canciones.add(cancion1);
        canciones.add(cancion2);
        canciones.add(cancion3);



       albumes.add(0,album);
        albumes.add(1,album);
        albumes.add(2,album);
        boolean anyadir1=album.addSong("Monster",3);
        boolean anyadir2=album.addSong("Bring me to life",4);
        boolean anyadir3=album.addSong("Monster",3);
        System.out.println(anyadir3);
        //System.out.println(anyadir1);
        System.out.println(anyadir2);
        boolean anyadirplaylistpista1=album.addToPlayList(1,canciones);
           System.out.println(anyadirplaylistpista1);
     // boolean anyadirplaylistpista2=album.addToPLayList("Bring me to life",canciones);
     //   System.out.println(anyadirplaylistpista2);
       // boolean anyadirplaylistpista3= album.addToPlayList(1,canciones);
        play(canciones);
    }
    public static void printList(LinkedList<Cancion>cancions){
        Iterator<Cancion>it=cancions.iterator();
        while (it.hasNext()){
            System.out.println("Nodo: " + it.next());

        }
        System.out.println("-----");

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
                    if(cancionListIterator.hasNext() && cancionListIterator.hasPrevious()){
                        System.out.println("Cancion " + cancionListIterator);
                    }else{
                        System.out.println("No hay ninguna cancion");
                    }
                    break;
                case 4:
                    printList(canciones);
                    break;
                case 5:
                    imprimirmenu();
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
    }

}
