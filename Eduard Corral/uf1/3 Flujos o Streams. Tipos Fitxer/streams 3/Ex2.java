package Binarios;

import java.io.*;
/**Escribe un programa que, utilizando la clase BufferedWriter, escriba 10 filas
 de caracteres en un fichero de texto y después de escribir cada fila salta una
 línea con el método newLine()**/
public class Ex2 {
    public static void main (String [] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("ex2.txt"));

        for (int i=0;i<10;i++) {
            bw.write("Fila:"+i);
            bw.newLine();
        }
        bw.close();
    }
}