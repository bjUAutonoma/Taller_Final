package nekkhris.taller_final_2;
import java.util.Stack;
import java.util.Scanner;

public class Prestamos {
    
    private Stack<Libro> disponibles;
    private Stack<Libro> prestados;
    
    public Prestamos(Stack disponibles, Stack prestados){
        this.disponibles = disponibles;
        this.prestados = prestados;
    }
    public void add_disponibles(Libro libro){
        this.disponibles.add(libro);
    }
    public void prestar(String nombre){
        if (!disponibles.isEmpty()){
            for (int i=0;i<disponibles.size();i++){
                String name = disponibles.get(i).getNombre();
                if (name.equals(nombre.toUpperCase())){
                    prestados.add(disponibles.get(i));
                System.out.printf("Se presto '%s'\n",disponibles.get(i).getNombre());
                disponibles.remove(i);
                }
            }
        }
        else{
            System.out.println("NO HAY LIBROS DISPONIBLES");
        }
        //if (disponibles.contains(libro)){
        //    prestados.add(libro);
        //    System.out.printf("Se presto %s\n",libro);
        //}
    }
    public void devolver(String nombre){
        if (!prestados.isEmpty()){
            for (int i=0;i<prestados.size();i++){
                String name = prestados.get(i).getNombre();
                if (name.equals(nombre.toUpperCase())){
                    disponibles.add(prestados.get(i));
                    System.out.printf("Se devolvio '%s'\n",prestados.get(i).getNombre());
                    prestados.remove(i);
                }
            }
        }
        else{
            System.out.println("NO HAY LIBROS PRESTADOS");
        }
    }
    public void show_disponibles(){
        if (disponibles.isEmpty()){
            System.out.println("NO HAY LIBROS DISPONIBLES");
        }
        else{
            for (int i=0;i<disponibles.size();i++){
            //Libro a = disponibles.get(i);
            System.out.print(i+1+".\n");
            disponibles.get(i).show_book();
            }
        }
    }
    public void show_prestados(){
        if (prestados.isEmpty()){
            System.out.println("NO HAY LIBROS PRESTADOS");
        }
        else{
            for (int i=0;i<prestados.size();i++){
            //Libro a = disponibles.get(i);
            System.out.print(i+1+".\n");
            prestados.get(i).show_book();
            }
        }
    }
    public void edit_book(String name, int option, String nuevo){
        for (int i=0;i<prestados.size();i++){
            if (prestados.get(i).getNombre().equals(name)){
                Libro a = prestados.get(i);
                switch(option){
                    case 1:
                        a.setNombre(nuevo);
                        break;
                    case 2:
                        a.setAutor(nuevo);
                        break;
                    case 3:
                        a.setCategoria(nuevo);
                        break;
                }
            }
        }
        for (int i=0;i<disponibles.size();i++){
            if (disponibles.get(i).getNombre().equals(name)){
                Libro b = disponibles.get(i);
                switch(option){
                    case 1:
                        b.setNombre(nuevo);
                        break;
                    case 2:
                        b.setAutor(nuevo);
                        break;
                    case 3:
                        b.setCategoria(nuevo);
                        break;
                }
            }
        }
    }
    public void delete_book(String name){
        for (int i=0;i<prestados.size();i++){
            if (prestados.get(i).getNombre().equals(name)){
                prestados.remove(i);
            }
        }    
        for (int i=0;i<disponibles.size();i++){
            if (disponibles.get(i).getNombre().equals(name)){
                disponibles.remove(i);
            }
        }
    }
    public void show_all(){
        int count = 1;
        for (int i=0;i<prestados.size();i++){
            System.out.println(count+".");
            prestados.get(i).show_book();
            count++;
        }    
        for (int i=0;i<disponibles.size();i++){
            disponibles.get(i).show_book();
            count++;
        }
    }
}
