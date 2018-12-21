import java.io.*;
/**Realiza un programa Java que muestre la siguiente información de un fichero
cualquiera: Nombre, ruta relativa, ruta absoluta, permisos y tamaño.**/
public class Ex5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Introdueze la ruta");
            String texto = reader.readLine();
            String dir = texto; //directorio
            File f = new File(dir);
            //Nombre,ruta relativa,ruta absoluta,permisos y tamaño
            String nombre = f.getName();
            String rutaR = f.getPath();
            String rutaA = f.getAbsolutePath();
            System.out.println("El nombre es:" + nombre);
            System.out.println("La ruta relativa es:" + rutaR);
            System.out.println("La ruta absoluta es:" + rutaA);
            System.out.println("Puede ejecutar:" + f.canExecute());
            System.out.println("Puede ejecutar:" + f.canWrite());
            System.out.println("Puede ejecutar:" + f.canRead());
            System.out.println("La aplicacion pesa:" + f.length());
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
