package nekkhris.taller_final_2;
import java.util.ArrayList;

public class Libros {
    
    private ArrayList<Libro> libros;
    public Libros(ArrayList libros){
        this.libros = libros;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
    public void add_book(Libro libros){
        this.libros.add(libros);
    }
    public void show_libros(){
        for (int i=0;i<libros.size();i++){
            Libro a = libros.get(i);
            System.out.print(i+1+".\n");
            a.show_book();
        }
        System.out.println();
    }
}
