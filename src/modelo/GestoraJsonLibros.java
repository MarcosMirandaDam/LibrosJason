
package modelo;

import java.io.FileWriter;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

/**
 *
 * @author Marcos Miranda
 */
public class GestoraJsonLibros {
    
    
    public boolean crearFicheroJson() throws IOException{
        boolean creado=false;
        JsonObject libroJason1 = Json.createObjectBuilder()          //creamos objeto principal
                .add("titulo", "Sueños IA")
                .add("totalPaginas", 210)
                .add("precio", 10)
                .add("autores", Json.createArrayBuilder()                   //creamos array de autores
                        .add(Json.createObjectBuilder()                     // creamos el objectBuilder       
                        .add("nombre","Javier")                             //añadimos los objetos de autores
                        .add("apellido", "Perez"))
                        .add(Json.createObjectBuilder()                     // otro objeto mas añadir
                        .add("nombre", "Maria")
                        .add("apellido", "Rodriguez")))
                .add("generos", Json.createArrayBuilder()                   //ahora el array de generos
                        .add(Json.createObjectBuilder()                     // otro objeto mas añadir
                        .add("genero", "novela"))                            //añadimos los objetos de generos
                        .add(Json.createObjectBuilder()                     // otro objeto mas añadir
                        .add("genero", "ficcion")))
                        
                .build();
        
        
        //añadimos la creación del fichero y añadimos los objetos creados
        FileWriter ficheroSalida=new FileWriter("salidaLibros.json");
        JsonWriter createWriter = Json.createWriter(ficheroSalida);
        createWriter.writeObject(libroJason1);
        ficheroSalida.flush();
        ficheroSalida.close();
                   
        creado=true;
        return creado;
    }
}
