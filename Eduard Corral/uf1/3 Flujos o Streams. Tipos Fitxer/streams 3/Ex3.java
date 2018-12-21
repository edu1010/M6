

import java.io.*;
/**3. Repite el ejercicio anterior pero ahora utilizando la clase PrintWriter**/
public class Ex3 {
    public static void main (String [] args) throws IOException {

        PrintWriter pw = new PrintWriter(new FileWriter("ex2.txt"));
        for (int i=0;i<10;i++) {
            pw.write("Fila:"+i);
            pw.println();
        }
        pw.close();
    }
}
