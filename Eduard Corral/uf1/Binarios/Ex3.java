import java.io.* ;
public class Ex3 {
/**Ahora escribe un programa que permita visualizar los datos grabados
anteriormente en el fichero FicheroDatos.dat. Se deben obtener en el mismo
orden en el que se escribieron, es decir, primero obtenemos el nombre y
luego la edad**/
    public static void main (String [] args) throws IOException {
        File fichero = new File("FicheroDatos.dat");
        FileInputStream FileInput = new FileInputStream(fichero);
        DataInputStream lector = new DataInputStream(FileInput);
        try {
            while (true)//Para controlar el final de la lectura del ficher lo hacemos mediante la excepcion
                System.out.println(lector.readUTF() + lector.readInt()+" ");//Mostramos el nombre y la edad en cada vuelta
        }catch (IOException e){

        }


    }
}
