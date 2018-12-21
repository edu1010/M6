/**Realiza un programa Java que utilice el método listFiles() para mostrar la lista
de ficheros de un directorio que se pasará al programa desde los argumentos
del main**/
import java.io.*;
public class Ex3 {
    public static void main(String[] args) throws IOException {

        String dir = (args [0]); //directorio
        File f = new File(dir);
        File[] archivos = f.listFiles();
        for(File algo:archivos){
            System.out.print(algo);
        }
    }
}
