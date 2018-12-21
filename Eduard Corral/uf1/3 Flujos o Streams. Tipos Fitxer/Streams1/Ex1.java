package Flujos;
import java.io.*;
/**Modifica el código anterior para que el programa vaya leyendo caracteres de 20 en 20.**/

public class Ex1 {
    public static void main ( String [] args) throws IOException {
        File fichero = new File ("/home/edu/IdeaProjects/m6/out/production/m6/Flujos/LeerFicheroTexto.java"); // declaración fichero
        FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
        char buf [] = new char[20];
        while ((flu.read(buf))!=-1)  //Vamos leyendo de 20 en 20
            System.out.print (buf);  //hacemos cast a char del entero leído
        flu.close();
    }
}
