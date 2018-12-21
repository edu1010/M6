import java.io.*;
/**Añade al programa anterior las instrucciones necesarias para que envíe un mensaje de error en caso de que el directorio pasado como argumento no
exista**/
public class Ex4 {
    public static void main(String[] args) throws IOException {
        try{
        String dir = (args [0]); //directorio
        File f = new File(dir);
        File[] archivos = f.listFiles();
        for(File algo:archivos){
            System.out.print(algo);
        }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
