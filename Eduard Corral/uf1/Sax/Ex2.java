import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

public class Ex2 {
    /**Crea un programa que devuelva el número de discos registrados en
     “discoteca.xml” de un determinado autor que le pasamos por consola. Si el
     autor carece de discos en el archivo, el programa devolverá un mensaje del
     estilo: “El autor <xxxxxx> no aparece en el archivo.**/
    public static void main (String [] args) throws FileNotFoundException, IOException, SAXException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /* A continuación se crea objeto procesador XML - XMLReader -. Durante la creación de este objeto se puede producir una excepción SAXException. */
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();

        System.out.println("Introduce el nombre del autor: ");
        String autor = reader.readLine();

        /* A continuación, mediante setContentHandler establecemos que la clase que gestiona los eventos provocados por la lectura del XML será GestionContenido */
        gestionContenido gestor = new gestionContenido(autor);
        procesadorXML.setContentHandler(gestor);
/* Por último, se define el fichero que se va leer mediante InputSource y se procesa el documento XML mediante el
método parse() de XMLReader */
        InputSource fileXML = new InputSource ("discoteca.xml");
        procesadorXML.parse(fileXML);
    }
}
class gestionContenido extends DefaultHandler {
    int numeroDiscos=0;
    String autor;
    public gestionContenido(String autor){
        super();
        this.autor=autor;
    }
    public void startDocument(){
        System.out.println("Comienzo del documento XML");
    }
    public void endDocument(){
        if(numeroDiscos!=0){
            System.out.println("Final del documento XML, el numero de discos del "+autor+" es:"+numeroDiscos);
            }else{
            System.out.println("No hay libros de este autor");
                }
        }
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
        String car = new String (ch, inicio, longitud);
        car = car.replaceAll("[\t\n]","");
        if(car.equals(autor)){
            numeroDiscos=numeroDiscos+1;
        }

    }
}
