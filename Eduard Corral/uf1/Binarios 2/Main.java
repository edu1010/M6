package Binarios;
import java.io.*;
/**Crea un programa en java que genere un objeto EstadoPartida, modifique la
 posición de algunas fichas del tablero, guarde en un archivo el estado de la
 partida, recupere el estado desde el archivo y lo muestre por pantalla.**/
public class Main {
    public static void Guardar(EstadoPartida estado){
        GuardarYRecuperarEstado.GuardarEstado(estado);
    }
    public static void main(String[] args) throws IOException {
        int[][] tablero=new int [1][2];
        EstadoPartida estadoPartida = new EstadoPartida(tablero,"jugador1");
        estadoPartida.setTablero(tablero);
        Guardar(estadoPartida);
        try{
            GuardarYRecuperarEstado.RecuperarEstado();
        }catch (ClassNotFoundException e){

        }




    }
}
