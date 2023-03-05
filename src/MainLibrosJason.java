
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
        
        System.out.println(gestora.crearFicheroJson());
        
    }
    
}
