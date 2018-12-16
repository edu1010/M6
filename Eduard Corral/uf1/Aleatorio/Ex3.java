package Aleatorio;

import java.io.*;
import java.util.Scanner;

/**INSERCION. Crea un programa Java que inserte datos en el fichero
 aleatorio. El programa ejecutará desde la línea de comandos y debe recibir 4
 parámetros: identificador de empleado, apellido, departamento y salario.
 Antes de insertar se comprobará si el identificador existe, en ese caso se
 debe visualizar un mensaje indicándolo; si no existe se deberá insertar.**/
public class Ex3 {
    public static void main (String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String texto;
        System.out.println("Introduce el id");
        texto = reader.readLine();
        int identificador =Integer.parseInt(texto);

        System.out.println("Introduze el apellido");
        String apellidoS = reader.readLine();

        System.out.println("Introduze el departamento");
        texto = reader.readLine();
        int departamento = Integer.parseInt(texto);

        System.out.println("Introduce el salario");
        texto = reader.readLine();
        double salarioDouble =Double.parseDouble(texto);


        File fichero = new File ("AleatorioEmpleado.dat");
        RandomAccessFile file = new RandomAccessFile (fichero , "rw");
        char apellido[]= new char[10], aux;
        int  dep,id;
        int esta = 0;
        Double salario;


        int posicion =0;
        for ( ; ; ){
            file.seek (posicion); // Nos posicionamos en posicion
            id = file.readInt(); // Obtengo identificar de Empleado
            for ( int i =0; i<apellido.length; i++) {
                aux = file.readChar(); // Voy leyendo carácter a carácter el apellido y lo guardo
                apellido[i]=aux; // en el array apellido
            }
            String apellidos = new String (apellido);
            dep = file.readInt(); //Lectura de departamento y salario
            salario = file.readDouble();
            if (id >0){
                if(id == identificador){
                    System.out.printf("Este identificador ya existe");
                    esta=1;
                    break;
                }
            }
            posicion = posicion + 36;
            if (file.getFilePointer() ==file.length()) break; // Si he recorrido todo el fichero, salgo
        }
        //identificador, apellidoS, departamento, salarioDouble
        if(esta !=1) {
            StringBuffer buffer = null; //Buffer para almacenar apellido

            StringBuffer bufferApellido = null; //Buffer para almacenar apellido
            String apellidoA[] = {apellidoS};
            int n = apellidoA.length; //Número de elementos en el array
            for (int i = 0; i<n; i++) { //Recorro los arrays
                file.seek(file.length());
                file.writeInt (identificador);
                bufferApellido = new StringBuffer (apellidoA[i]);
                bufferApellido.setLength(10);
                file.writeChars(bufferApellido.toString());
                file.writeInt(departamento);
                 file.writeDouble(salarioDouble);
                System.out.println("Insertado");
            }
        }
        file.close(); // No olvidarse de cerrar el fichero

    }

}

