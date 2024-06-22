package nekkhris.taller_final_2;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Libro{
    
    LinkedList<String> lista_enlazada;

    Autores autores = new Autores(lista_enlazada);
    Categorias categorias = new Categorias(lista_enlazada);
    
    
    Stack disponibles = new Stack();
    Stack prestados = new Stack();
    Prestamos prestamos = new Prestamos(disponibles, prestados);
    
    //ArrayList libros = new ArrayList();
    
    private String nombre;
    private String autor;
    private String categoria;
    
    public Libro(String nombre, String autor, String categoria){
        this.nombre = nombre;
        this.autor = autor;       
        this.categoria = categoria;       
    }
    public String getNombre() {
        return nombre;
    }
    public String getAutor() {
        return autor;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    //public void add_book(){
    //    
    //    if (!categorias.getCategorias().isEmpty() && !autores.getAutores().isEmpty()){
    //        System.out.println("Ingrese el nombre del libro:");
    //        Scanner temp = new Scanner(System.in);
    //        String nombre = temp.nextLine().toUpperCase();

    //        System.out.println("Ingrese el autor del libro:");
    //        String autor = temp.nextLine().toUpperCase();

    //        System.out.println("Ingrese la categoria del libro:");
    //        String categoria = temp.nextLine().toUpperCase();

    //        if (autores.getAutores().contains(autor) && categorias.getCategorias().contains(categoria)){
    //            Libro libro = new Libro(nombre,autor,categoria);
                //prestamos.add_disponibles(libro);
                //libros(libro);
    //        }
    //    }
    //    else{
    //        System.out.println("No existen autores/categorias para el ");
    //    }
    //}
    //public void show_libros(){
    //    System.out.println("Los libros ingresados son:");
    //    for (int i=0;i<libros.size();i++){
    //        System.out.println(i+1+". "+libros.get(i));
    //    }
    //}
    public void show_book(){
        System.out.println("NOMBRE: "+getNombre()+"\nAUTOR: "+getAutor()+"\nCATEGORIA: "+getCategoria());
    }
}
