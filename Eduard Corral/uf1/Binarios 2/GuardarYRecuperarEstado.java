package Binarios;
import java.io.*;
/**Diseña una clase que llamarás GuardarYRecuperarEstado que disponga de
 dos métodos: guardarEstado que permitirá guardar en un archivo el estado
 de la partida y otro, recuperarEstado, que permitirá recuperar el estado de
 una partida desde archivo**/
public class GuardarYRecuperarEstado {
    private EstadoPartida estadoPartida;
    public GuardarYRecuperarEstado(EstadoPartida estadoPartida) {
        this.estadoPartida=estadoPartida;
    }

    public static void GuardarEstado(EstadoPartida estado) {
        try {
            File fichero = new File ("partida.dat");
            FileOutputStream fileout = new FileOutputStream (fichero);
            ObjectOutputStream dataOS = new ObjectOutputStream (fileout);

            dataOS.writeObject (estado) ;
            dataOS.close();
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }

    public static void RecuperarEstado() throws IOException, ClassNotFoundException {
        EstadoPartida estadoPartida;
        File file = new File ("partida.dat");
        FileInputStream filein = new FileInputStream (file);
        ObjectInputStream dataIS = new ObjectInputStream (filein) ;
        try {
            while (true) {
                estadoPartida = (EstadoPartida) dataIS.readObject ();
                System.out.printf("Turno de: %s Posicion fichas:%d", estadoPartida.getTablero(), estadoPartida.getTurno());
            }
        }
        catch (EOFException e) {
            System.out.println ("Fin de Lectura");
        }
        dataIS.close();
    }


}
