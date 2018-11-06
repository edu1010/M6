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