import java.io.*;
/**Modifica el ejemplo anterior para, en vez de escribir los caracteres uno a uno,
escribir todo el array usando el método write (char [] buf)**/
    public class Ex2 {
        public static void main (String [] args) throws IOException {
            File fichero = new File("/home/edu/IdeaProjects/m6/out/production/m6/Flujos/fichero.txt");
            FileWriter fic = new FileWriter (fichero);
            String cadena = " Esto es una prueba con FileWriter ";
            char buf [] = new char[cadena.length()];
            buf = cadena.toCharArray ();
            fic.write (buf);
            fic.append ('*'); // añadimos un asterisco al final
            fic.close (); // cerramos fichero
        }
    }


