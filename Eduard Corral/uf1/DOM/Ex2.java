import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;

/**
Vas a realizar exactamente lo mismo que en el programa anterior pero en vez
de utilizar un fichero de acceso aleatorio (como era el caso de
AleatorioEmpleado.dat) vas a utilizar un fichero de texto con los datos de los
empleados. Es decir:
a. Generar un archivo de texto que contendrá la información de cada empleado. Cada línea del
archivo se asociará al id, apellido, departamento y salario de cada empleado. Cada uno de
estos campos irá separado por el carácter “:” (Ejemplo: 1:Fernandez:10:1000.45). Llamarás al
archivo “Empleados.txt”
b. Generar el programa Java que genere el archivo XML correspondiente a los datos contenidos
en Empleados.txt
**/

public class Ex2 {
    public static void main (String args[]) throws IOException {
        ArrayList<String> Empleado = new ArrayList<String>();
        BufferedReader file = new BufferedReader (new FileReader ("Empleados.txt"));

        int id, dep, i=0;
        Double salario;
        char apellido[] = new char[10], aux;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


        String linea="";
        while ((linea = file.readLine()) != null){Empleado.add(linea);

            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                Document document = implementation.createDocument (null,"Empleados", null);
                document.setXmlVersion("1.0");

                for (i=0;i<Empleado.size();i++){

                    String[] DifEmpleados = Empleado.get(i).split(":");

                    id = Integer.parseInt(DifEmpleados[0]);
                    apellido = DifEmpleados[1].toCharArray();

                    String apellidos = new String (apellido);

                    dep = Integer.parseInt(DifEmpleados[2]);
                    salario =Double.parseDouble(DifEmpleados[3]);

                    if (id>0) {

                        Element raiz = document.createElement ("empleado");
                        document.getDocumentElement().appendChild(raiz);
                        CrearElemento ("id", Integer.toString(id), raiz, document);
                        CrearElemento ("apellido",apellidos.trim(), raiz, document);
                        CrearElemento ("dep", Integer.toString(dep), raiz, document);
                        CrearElemento ("salario", Double.toString(salario),raiz, document);

                    }

                }

                Source source = new DOMSource (document);
                Result result = new StreamResult (new java.io.File ("Empleados.xml"));
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform (source, result);

            } catch (Exception e ) { e.printStackTrace();}

        }
    }

    static void CrearElemento (String datoEmpleado, String valor, Element raiz, Document document) {
        Element elem = document.createElement (datoEmpleado);
        Text text = document.createTextNode(valor);
        raiz.appendChild (elem);
        elem.appendChild (text);

    }
}