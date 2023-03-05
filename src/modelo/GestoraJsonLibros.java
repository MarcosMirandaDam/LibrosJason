package modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

/**
 *
 * @author Marcos Miranda
 */
public class GestoraJsonLibros {

    /**
     * método que crea un Json con sus objetos
     *
     * @return
     * @throws IOException
     */
    public boolean crearFicheroJson() throws IOException {
        boolean creado = false;
        JsonObject libroJson1 = Json.createObjectBuilder()                      //creamos objeto principal
                .add("titulo", "Sueños IA")
                .add("totalPaginas", 210)
                .add("precio", 10)
                .add("autores", Json.createArrayBuilder()                        //creamos array de autores
                        .add(Json.createObjectBuilder()                         // creamos el objectBuilder       
                                .add("nombre", "Javier")                        //añadimos los objetos de autores
                                .add("apellido", "Perez"))
                        .add(Json.createObjectBuilder()                         // otro objeto mas añadir
                                .add("nombre", "Maria")
                                .add("apellido", "Rodriguez")))
                .add("generos", Json.createArrayBuilder()                       //ahora el array de generos
                        .add(Json.createObjectBuilder()                         // otro objeto mas añadir
                                .add("genero", "novela"))                       //añadimos los objetos de generos
                        .add(Json.createObjectBuilder()                         // otro objeto mas añadir
                                .add("genero", "ficcion")))
                .build();

        JsonObject libroJson2 = Json.createObjectBuilder()                      //creamos objeto principal
                .add("titulo", "JSON para todos")
                .add("totalPaginas", 3210)
                .add("precio", 20)
                .add("autores", Json.createArrayBuilder()                       //creamos array de autores
                        .add(Json.createObjectBuilder()                         // creamos el objectBuilder       
                                .add("nombre", "Ana")                           //añadimos los objetos de autores
                                .add("apellido", "Cota"))
                        .add(Json.createObjectBuilder()                         // otro objeto mas añadir
                                .add("nombre", "Mar")
                                .add("apellido", "Fernandez")))
                .add("generos", Json.createArrayBuilder()                        //ahora el array de generos
                        .add(Json.createObjectBuilder()                         // otro objeto mas añadir
                                .add("genero", "informatica"))                  //añadimos los objetos de generos
                        .add(Json.createObjectBuilder()                         // otro objeto mas añadir
                                .add("genero", "json")))
                .build();

        // Crear un Array de Json añadiendo los values deseados     
        JsonArray arrayJson = Json.createArrayBuilder().add(libroJson1)
                .add(libroJson2)
                .build();

        //añadimos la creación del fichero y añadimos los objetos creados
        FileWriter ficheroSalida = new FileWriter("salidaLibros.json");
        JsonWriter createWriter = Json.createWriter(ficheroSalida);
        createWriter.writeArray(arrayJson);                                     //escribimos el array completo
        ficheroSalida.flush();
        ficheroSalida.close();

        creado = true;
        return creado;
    }

    /**
     * retorna el total de libros en el Json
     *
     * @return
     * @throws FileNotFoundException
     */
    public int totalLibros() throws FileNotFoundException {
        int total = 0;
        FileReader entrada = new FileReader("salidaLibros.json");
        JsonReader jsonReader = Json.createReader(entrada);
        JsonArray readArray = jsonReader.readArray();                   // objeto reader , para leer el array
        for (int i = 0; i < readArray.size(); i++) {                    //recorremos el array 
            total = readArray.size();
        }
        return total;
    }

    /**
     * retorna el título de todos los libros.
     *
     * @return
     * @throws java.io.FileNotFoundException
     */
    public String mostrarTituloLibros() throws FileNotFoundException {
        String datos = "";
        FileReader entrada = new FileReader("salidaLibros.json");
        JsonReader jsonReader = Json.createReader(entrada);
        JsonArray readArray = jsonReader.readArray();                                                // objeto reader , para leer el array
        for (int i = 0; i < readArray.size(); i++) {
            datos += "\n" + readArray.getJsonObject(i).getString("titulo");
        }
        return datos;
    }

    /**
     * retorna el nombre del autor 1 del libro 2
     *
     * @return
     * @throws java.io.FileNotFoundException
     */
    public String mostrarNombreAutorDeterminado() throws FileNotFoundException {
        String datos = "";
        FileReader entrada = new FileReader("salidaLibros.json");
        JsonReader jsonReader = Json.createReader(entrada);
        JsonArray readArray = jsonReader.readArray();                                                // objeto reader , para leer el array
        for (int i = 0; i < readArray.size(); i++) {                                                 //recorremos array Principal
            JsonArray jsonArrayAutoresLibro2 = readArray.getJsonObject(1).getJsonArray("autores");   //creamos array determinado con la pos i=1 para coger el libro 2
            for (int j = 0; j < jsonArrayAutoresLibro2.size(); j++) {                                //recorremos el array creado
                datos = jsonArrayAutoresLibro2.getJsonObject(0).getString("nombre");                  //vamos al dato determinado, j=0 pos 1 del libro 2.
            }
        }

        return datos;

    }

    /**
     * retorna el valor de los libros en stock
     * @return
     * @throws java.io.FileNotFoundException
     */
    public double calcularValorLibrosStock() throws FileNotFoundException {
        double costeTotal = 0;
        FileReader entrada = new FileReader("salidaLibros.json");
        JsonReader jsonReader = Json.createReader(entrada);
        JsonArray readArray = jsonReader.readArray();                                       // objeto reader , para leer el array
        for (int i = 0; i < readArray.size(); i++) {
            JsonNumber precioLibro = readArray.getJsonObject(i).getJsonNumber("precio");     //creamos el JNumber para acceder al precio
            costeTotal += precioLibro.doubleValue();
        }

        return costeTotal;

    }

}
