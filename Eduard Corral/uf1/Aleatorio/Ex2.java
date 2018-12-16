package Aleatorio;

import java.io.*;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) throws IOException {


        System.out.println("Introduce el ID: ");
        Scanner read = new Scanner(System.in);
        int identificador = read.nextInt();
        int esta=0;

        File fichero = new File ("AleatorioEmpleado.dat");
        RandomAccessFile file = new RandomAccessFile (fichero, "r");
        int id, dep ,posicion;
        Double salario;
        char apellido[]= new char[10], aux;

        file.seek (posicion=0);
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
            if (id >0)
                if(id == identificador){
                    System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(), dep, salario);
                    esta=1;
                }

            posicion = posicion + 36;
            if (file.getFilePointer() ==file.length()) break; // Si he recorrido todo el fichero, salgo
        } // del for
        file.close();
        if(esta == 0) {
                System.out.println("El identificador introducido no existe");
        }
    }
}