import java.io.*;
/**Escribe un programa en java que muestre por pantalla un fichero de texto
 que le pasamos como argumento (o utilizando scanner) utilizando la clase
 BufferedReader**/
public class ex1 {
    public static void main (String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el nombre del fichero: ");
        String fichero = reader.readLine();

        String file = fichero;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

    }
}