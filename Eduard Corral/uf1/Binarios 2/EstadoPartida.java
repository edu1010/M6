package Binarios;
/**Diseña una clase que llamarás EstadoPartida para gestionar el estado de
 una partida de 3 en raya. Debe incluir: posición de las piezas (será una matriz
 3x3) y a quién le toca tirar (jugador1 o jugador2). **/
public class EstadoPartida {
    private int [][] tablero;
    private String turno;

    public EstadoPartida(int[][] tablero, String turno) {
        this.tablero = tablero;
        this.turno = turno;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        if(turno.equalsIgnoreCase("jugador1") ||turno.equalsIgnoreCase("jugador2")){
        this.turno = turno;}else{
            System.out.println("Incorrecto, solo valido jugador1 o jugador2");
        }
    }
}
