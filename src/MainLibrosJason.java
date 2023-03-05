
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import modelo.GestoraJsonLibros;

/**
 *
 * @author Marcos Miranda
 */
public class MainLibrosJason {

    public static void main(String[] args) {
       
        GestoraJsonLibros gestora=new GestoraJsonLibros();
        
        try {
            //Cree un fichero con una salida como la del fichero libros.json
            System.out.println(gestora.crearFicheroJson());
        } catch (IOException ex) {
            Logger.getLogger(MainLibrosJason.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // Lea el fichero libros.json y cuente el total de libros.

            System.out.println(gestora.totalLibros());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainLibrosJason.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //Lea el fichero libros.json y muestre el título de todos los libros.
            System.out.println(gestora.mostrarTituloLibros());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainLibrosJason.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
        //Lea el fichero libros.json y muestre el nombre del autor 1 del libro 2.
        
        System.out.println(gestora.mostrarNombreAutorDeterminado());
        } catch (FileNotFoundException ex) {
        Logger.getLogger(MainLibrosJason.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // retorna el valor de los libros en stock

            System.out.println("El valor total de los libros es stock es de --->"+gestora.calcularValorLibrosStock()+ " €");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainLibrosJason.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
