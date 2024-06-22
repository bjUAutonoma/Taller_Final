package nekkhris.taller_final_2;
import java.util.LinkedList;
import java.util.Scanner;

public class Autores {
    
    private LinkedList autores;
    
    public Autores(LinkedList<String> autores){
        this.autores = autores;
    }
    public LinkedList getAutores() {
        return autores;
    }
    public void setAutores(LinkedList autores) {
        this.autores = autores;
    }
    public void add_autor(){
        if (autores.isEmpty()){
            autores.add("stephen king".toUpperCase());
            autores.add("gege akutami".toUpperCase());
            //System.out.println("Se anadieron 2 autores");
        }
        else {
            System.out.println("Ingrese el nombre del autor:");
            Scanner temp = new Scanner(System.in);
            String autor = temp.nextLine().toUpperCase();
            if (!getAutores().contains(autor)){
                autores.add(autor);
                System.out.println("\nSe anadio el autor '"+autor+"'\n");
            }
        }
    }
    public void edit_autor(){
        System.out.println("Que autor desea modificar:");
        Scanner temp = new Scanner(System.in);
        String autor = temp.nextLine().toUpperCase();
        if (autores.contains(autor)){
            for (int i=0; i<autores.size();i++){
                if(autores.get(i).equals(autor)){
                    System.out.println("Ingrese el nuevo nombre del autor:");
                    String n_autor = temp.nextLine().toUpperCase();
                    autores.set(i, n_autor);
                    System.out.println("\nEl autor '"+autor+"' ahora es '"+n_autor+"'\n");
                }
            }
        }
    }
    public void delete_autor(){
        System.out.println("Que autor desea eliminar:");
        Scanner temp = new Scanner(System.in);
        String autor = temp.nextLine().toUpperCase();
        if (autores.contains(autor)){
            autores.remove(autor);
            System.out.println("\nSe elimino el autor '"+autor+"'\n");
        }
        else{
            System.out.println("\nEl autor '"+autor+"' no se encuentra ingresado\n");
        }
    }
    public void show_autor(){
        if (!autores.isEmpty()){
            System.out.println("Los autores ingresados son:");
            for (int i=0;i<autores.size();i++){
                System.out.println(i+1+". "+autores.get(i));
            }
        }
        else{
            System.out.println("No hay autores ingresados");
        }
    System.out.println();
    }
}
