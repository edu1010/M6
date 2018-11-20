package Flujos;

import java.io.*;
    public class ex1_3 {
        public static void main ( String [] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introdueze la ruta");
            String ruta = reader.readLine();
            File fichero = new File (ruta); // declaración fichero
            FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
            char buf [] = new char[20];
            while ((flu.read(buf))!=-1)  //Vamos leyendo de 20 en 20
                System.out.print (buf);  //hacemos cast a char del entero leído
            flu.close();
        }
    }


