package nekkhris.taller_final_2;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class Taller_Final_2 {
    
    LinkedList<String> lista_autores = new LinkedList();
    LinkedList<String> lista_categorias = new LinkedList();
    ArrayList lista_libros = new ArrayList();
    Stack disponibles = new Stack();
    Stack prestados = new Stack();
    public Autores autores = new Autores(lista_autores);
    public Categorias categorias = new Categorias(lista_categorias);
    public Libros libros = new Libros(lista_libros);
    public Prestamos prestamos = new Prestamos(disponibles, prestados);
    
    //Libro libros = new Libro(null,null,null);
    
    public static void main(String[] args) {
        Taller_Final_2 temp = new Taller_Final_2();
        temp.initial();
    }
    public void initial(){//adicion rapida de categorias, autores y libros para agilizar testeo
        categorias.add_catego();
        autores.add_autor();
        if (libros.getLibros().isEmpty()){
                        Libro libro = new Libro("jujutsu kaisen".toUpperCase(),"gege akutami".toUpperCase(),"fantasia".toUpperCase());
                        Libro libro_2 = new Libro("el resplandor".toUpperCase(),"stephen king".toUpperCase(),"suspenso".toUpperCase());
                        libros.add_book(libro);
                        libros.add_book(libro_2);
                        prestamos.add_disponibles(libro);
                        prestamos.add_disponibles(libro_2);
                        //System.out.println("Se anadieron 2 libros");
                    }
        menu();
    }
    public void menu(){
        System.out.println("Como desea operar:"
                + "\n(1) Menu Categoria"
                + "\n(2) Menu Autor"
                + "\n(3) Menu Libro"
                + "\n(4) Prestamo de Libros"
                + "\n(5) Finalizar");
        try{
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            System.out.println();
            switch (option){
                case 1:
                    menu_categoria();
                    break;
                case 2:
                    menu_autor();
                    break;
                case 3:
                    menu_libro();
                    break;
                case 4:
                    menu_prestamo();
                    break;
                case 5:
                    System.exit(0);
                default:
                    throw new Exception();
            }
        }
        catch(Exception e){
            System.out.println("OPCION INVALIDA\n");
            menu();
        }
    }
    public void menu_categoria(){
        System.out.println("Que desea hacer:"
                + "\n(1) Crear Categoria"
                + "\n(2) Editar Categoria"
                + "\n(3) Eliminar Categoria"
                + "\n(4) Mostrar todas las Categorias"
                + "\n(5) Volver al menu principal");
        try{
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            switch (option){
                case 1:
                    categorias.add_catego();
                    break;
                case 2:
                    categorias.edit_catego();
                    break;
                case 3:
                    categorias.delete_catego();
                    break;
                case 4:
                    categorias.show_catego();
                    break;
                case 5:
                    System.out.println();
                    menu();
                    break;
                default:
                    throw new Exception();
            }
            menu_categoria();
        }
        catch (Exception e){
            System.out.println("OPCION INVALIDA\n");
            menu_categoria();
        }
    }
    public void menu_autor(){
        System.out.println("Que desea hacer:"
                + "\n(1) Crear Autor"
                + "\n(2) Editar Autor"
                + "\n(3) Eliminar Autor"
                + "\n(4) Mostrar todos los Autores"
                + "\n(5) Volver al menu principal");
        try{
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            System.out.println();
            switch (option){
                case 1:
                    autores.add_autor();
                    break;
                case 2:
                    autores.edit_autor();
                    break;
                case 3:
                    autores.delete_autor();
                    break;
                case 4:
                    autores.show_autor();
                    break;
                case 5:
                    System.out.println();
                    menu();
                    break;
                default:
                    throw new Exception();
            }
            menu_autor();
        }
        catch (Exception e){
            System.out.println("OPCION INVALIDA\n");
            menu_autor();
        }
    }
    public void menu_libro(){
        System.out.println("Que desea hacer:"
                + "\n(1) Crear Libro"
                + "\n(2) Editar Libro"
                + "\n(3) Eliminar Libro"
                + "\n(4) Mostrar todos los Libros"
                + "\n(5) Volver al menu principal");
        try{
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            System.out.println();
            switch (option){
                case 1://crear libro
                    if (libros.getLibros().isEmpty()){
                        Libro libro = new Libro("jujutsu kaisen".toUpperCase(),"gege akutami".toUpperCase(),"fantasia".toUpperCase());
                        Libro libro_2 = new Libro("el resplandor".toUpperCase(),"stephen king".toUpperCase(),"suspenso".toUpperCase());
                        libros.add_book(libro);
                        libros.add_book(libro_2);
                        System.out.println("Se anadieron 2 libros");
                    }
                    else{
                        if (!categorias.getCategorias().isEmpty() && !autores.getAutores().isEmpty()){
                            System.out.print("Ingrese el nombre del libro: ");
                            Scanner temp = new Scanner(System.in);
                            String nombre = temp.nextLine().toUpperCase();

                            System.out.print("Ingrese el autor del libro: ");
                            String autor = temp.nextLine().toUpperCase();

                            System.out.print("Ingrese la categoria del libro:");
                            String categoria = temp.nextLine().toUpperCase();

                            if (autores.getAutores().contains(autor) && categorias.getCategorias().contains(categoria)){
                                Libro n_libro = new Libro(nombre,autor,categoria);
                                libros.add_book(n_libro);
                                prestamos.add_disponibles(n_libro);
                                System.out.println("Se ingreso el libro '"+n_libro.getNombre()+"'");
                            }
                        }
                    }
                    menu_libro();
                    break;
                case 2://editar libro
                    System.out.println("Que libro desea modificar:");
                    Scanner in = new Scanner(System.in);
                    Scanner inInt = new Scanner(System.in);
                    Scanner inStr = new Scanner(System.in);
                    String name = in.nextLine().toUpperCase();
                    System.out.println("Que desea modificar del libro:"
                            + "\n(1) NOMBRE"
                            + "\n(2) AUTOR"
                            + "\n(3) CATEGORIA");
                    int select = inInt.nextInt();
                    String a = new String();
                    switch (select){
                        case 1:
                            a = "el nuevo NOMBRE";
                            break;
                        case 2:
                            a = "el nuevo AUTOR";
                            break;
                        case 3:
                            a = "la nueva CATEGORIA";
                            break;
                    }
                    System.out.printf("Ingrese %s\n",a);
                    String nuevo = inStr.nextLine().toUpperCase();
                    switch (select){
                        case 2:
                            if (!autores.getAutores().contains(nuevo)){
                                System.out.println("EL AUTOR NO SE ENCUENTRA REGISTRADO");
                            }
                            break;
                        case 3:
                            if (!categorias.getCategorias().contains(nuevo)){
                                System.out.println("LA CATEGORIA NO SE ENCUENTRA REGISTRADA");
                            }
                            break;
                    }
                    prestamos.edit_book(name, select, nuevo);
                    break;
                case 3://eliminar libro
                    System.out.println("Que libro desea eiminar:");
                    Scanner del = new Scanner(System.in);
                    String eliminar = del.nextLine().toUpperCase();
                    prestamos.delete_book(eliminar);
                    break;
                case 4:
                    System.out.println("Los libros ingresados son:");
                    prestamos.show_all();
                    break;
                case 5:
                    menu();
                    break;
                default:
                    throw new Exception();
            }
            menu_libro();
        }
        catch (Exception e){
            System.out.println("OPCION INVALIDA\n");
            menu_libro();
        }
    }
    public void menu_prestamo(){
        System.out.println("Que desea hacer:"
                + "\n(1) Lista de Libros Prestados"
                + "\n(2) Lista de Libros Disponibles"
                + "\n(3) Prestar Libro"
                + "\n(4) Devolver Libro"
                + "\n(5) Volver al Menu Principal");
        try{
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            switch (option){
                case 1:
                    prestamos.show_prestados();
                    break;
                case 2:
                    prestamos.show_disponibles();
                    break;
                case 3:
                    System.out.println("Que libro desea pedir:");
                    Scanner ask = new Scanner(System.in);
                    String pedir = ask.nextLine();
                    prestamos.prestar(pedir);
                    break;
                case 4:
                    System.out.println("Que libro desea devolver:");
                    Scanner ask_2 = new Scanner(System.in);
                    String devolver = ask_2.nextLine();
                    prestamos.devolver(devolver);
                    break;
                case 5:
                    System.out.println();
                    menu();
                    break;
                default:
                    throw new Exception();
            }
            menu_prestamo();
        }
        catch (Exception e){
            System.out.println("OPCION INVALIDA\n");
            menu_categoria();
        }
    }
}