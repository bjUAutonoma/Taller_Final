package nekkhris.taller_final_2;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

class TreeNode{
        private int root;
        TreeNode left;
        TreeNode right;
}

public class Categorias extends TreeNode{
    
    private LinkedList<String> categorias;
    
    public Categorias(LinkedList<String> categorias){
        this.categorias = categorias;
    }
    public LinkedList<String> getCategorias() {
        return categorias;
    }
    public void add_catego(){
        if (!categorias.isEmpty()){
            System.out.println("Ingrese el nombre de la categoria:");
            Scanner temp = new Scanner(System.in);
            String categoria = temp.nextLine().toUpperCase();
            if (!categorias.contains(categoria)){
                categorias.add(categoria);
                System.out.println("\nSe anadio la categoria '"+categoria+"'\n");
            }
        }
        else{
            categorias.add("terror".toUpperCase());
            categorias.add("fantasia".toUpperCase());
            categorias.add("suspenso".toUpperCase());
            //System.out.println("Se anadieron 3 categorias");
        }
    }
    public void edit_catego(){
        System.out.println("Que categoria desea modificar:");
        Scanner temp = new Scanner(System.in);
        String categoria = temp.nextLine().toUpperCase();
        if (categorias.contains(categoria)){
            for (int i=0; i<categorias.size();i++){
                if(categorias.get(i).equals(categoria)){
                    System.out.println("Ingrese el nuevo nombre de la categoria:");
                    String n_categoria = temp.nextLine().toUpperCase();
                    categorias.set(i, n_categoria);
                    System.out.println("\nLa categoria '"+categoria+"' ahora es '"+n_categoria+"'\n");
                }
            }
        }
    }
    public void delete_catego(){
        System.out.println("Que categoria desea eliminar:");
        Scanner temp = new Scanner(System.in);
        String categoria = temp.nextLine().toUpperCase();
        if (categorias.contains(categoria)){
            categorias.remove(categoria);
            System.out.println("\nSe elimino la categoria '"+categoria+"'\n");
        }
        else{
            System.out.println("\nEl autor '"+categoria+"' no se encuentra ingresado\n");
        }
    }
    public void show_catego(){
        if (!categorias.isEmpty()){
            System.out.println("Las categorias ingresados son:");
            for (int i=0;i<categorias.size();i++){
                System.out.println(i+1+". "+categorias.get(i));
            }
        }
        else{
            System.out.println("No hay categorias ingreadas");
        }
        System.out.println();
    }
}
