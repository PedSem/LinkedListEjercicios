package Canciones;

import java.util.*;

public class MainCanciones {
    private static LinkedList<Cancion>canciones=new LinkedList<>();
    private static ArrayList<Album>albumes=new ArrayList<>();


    public static void main(String[] args) {
        Album album1=new Album("Monster","Skillet");
        Album album2=new Album("Bring me to life","Evanescence");
        albumes.add(0,album1);
        albumes.add(1,album2);
        boolean anyadir1=album1.addSong("Monster",3);
        boolean anyadir2=album1.addSong("Bring me to life",4);
        boolean anyadirplaylistpista1=album1.addToPlayList(0,canciones);
        boolean anyadirplaylistpista2=album2.addToPLayList("Bring me to life",canciones);
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
        int opcion=0;
        while (continuar){
            try{
                opcion= scanner.nextInt();
                scanner.nextLine();
                if(opcion<0 || opcion>6){
                    System.out.println("Introduce una opcion valida");
                    continuar=false;
                }

            }catch (InputMismatchException e){
                System.out.println("Error.Solo se permite numeros");
                scanner.nextLine();

            }
            switch (opcion){
                case 0:
                    System.out.println("Se acabo las canciones");
                    continuar=false;
                    break;
                case 1:
                    if(!haciaAdelante){
                        if(cancionListIterator.hasNext())
                            cancionListIterator.next();
                        haciaAdelante=true;


                    }
                    if(cancionListIterator.hasNext()){
                        System.out.println("Cancion " + cancionListIterator);

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
                        System.out.println("Cancion " + cancionListIterator);
                    }else{
                        System.out.println("Primer cancion");
                        haciaAdelante=true;
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
