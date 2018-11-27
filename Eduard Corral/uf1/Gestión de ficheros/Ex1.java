import java.io.*;
public class Ex1 {
    public static void main(String[] args) {
        String dir = "/home/edu/Descargas";//directorio descargas
        File f = new File(dir);
        String[] archivos = f.list();
        System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
        for (i  nt i = 0; i < archivos.length; i++) {
            File f2 = new File(f, archivos[i]);
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i],
                    f2.isFile(), f2.isDirectory());
        }
    }
}