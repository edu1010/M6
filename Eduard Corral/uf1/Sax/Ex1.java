import java.io.*;
        import org.xml.sax.Attributes;
        import org.xml.sax.InputSource;
        import org.xml.sax.SAXException;
        import org.xml.sax.XMLReader;
        import org.xml.sax.helpers.DefaultHandler;
        import org.xml.sax.helpers.XMLReaderFactory;
        /**Crea un programa que lea el archivo “discoteca.xml” (adjunto en el moodle) y
         determine el número de discos listados en el archivo. AYUDA: contabilizando
         el número de títulos.**/
public class Ex1 {
    public static void main (String [] args) throws FileNotFoundException, IOException, SAXException {

        /* A continuación se crea objeto procesador XML - XMLReader -. Durante la creación de este objeto se puede producir una excepción SAXException. */
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        /* A continuación, mediante setContentHandler establecemos que la clase que gestiona los eventos provocados por la lectura del XML será GestionContenido */
        GestionContenido gestor = new GestionContenido();
        procesadorXML.setContentHandler(gestor);
/* Por último, se define el fichero que se va leer mediante InputSource y se procesa el documento XML mediante el
método parse() de XMLReader */
        InputSource fileXML = new InputSource ("discoteca.xml");
        procesadorXML.parse(fileXML);
    }
}
class GestionContenido extends DefaultHandler {
    int numeroDiscos=0;
    public GestionContenido(){
        super();
    }
    public void startDocument(){
        System.out.println("Comienzo del documento XML");
    }
    public void endDocument(){
        System.out.println("Final del documento XML, el numero de discos es:"+numeroDiscos);
    }
    public void startElement (String uri, String nombre, String nombreC, Attributes atts) {
        System.out.printf("\tPrincipio Elemento: %s %n", nombre);
        if (nombre.equals("CD")) {numeroDiscos=numeroDiscos+1;}
    }


}
