import java.io.*;
/**MODIFICACION. Crea un programa Java que reciba desde la línea de
 comandos un identificador de empleado y un importe. Se debe realizar la
 modificación del salario. La modificación consistirá en sumar al salario del
 empleado el importe introducido. El programa debe visualizar el apellido, el
 salario antiguo y el nuevo. Si el identificador no existe se visualizará mensaje
 indicándolo.**/
public class Ex4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String texto;
        System.out.println("Introduce el id");
        texto = reader.readLine();
        int identificador = Integer.parseInt(texto);

        System.out.println("Introduce el aumento de salario");
        texto = reader.readLine();
        double aumento = Double.parseDouble(texto);
        File fichero = new File ("AleatorioEmpleado.dat");
        RandomAccessFile file = new RandomAccessFile (fichero , "rw");
        char apellido[]= new char[10], aux;
        int  dep,id;
        int esta = 0;
        Double salario;
        long a=0;
        long b =0;
        long c = 0;
        long d =0;
        int posicion =0;
        for ( ; ; ){
            file.seek (posicion); // Nos posicionamos en posicion
            c=file.getFilePointer();
            id = file.readInt(); // Obtengo identificar de Empleado
            for ( int i =0; i<apellido.length; i++) {
                aux = file.readChar(); // Voy leyendo carácter a carácter el apellido y lo guardo
                apellido[i]=aux; // en el array apellido
            }
            String apellidos = new String (apellido);
            dep = file.readInt(); //Lectura de departamento y salario
            a = file.getFilePointer();
            salario = file.readDouble();

            if (id >0){
                if(id == identificador){
                    d=c;
                    b=a;
                    System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(), dep, salario);
                    esta=1;
                    break;
                }
            }
            posicion = posicion + 36;
            if (file.getFilePointer() ==file.length()) break; // Si he recorrido todo el fichero, salgo
        }
        if(esta == 0){
            System.out.println("El identificador no se encuentra");
        }
        if(esta == 1) {
            file.seek(b);
            file.writeDouble(salario+aumento);
            System.out.println("Insertado");
            file.seek(d);//En d se ha guardado la posicion desde la cual tendremos que leer

            id = file.readInt(); // Obtengo identificar de Empleado
            for ( int i =0; i<apellido.length; i++) {
                aux = file.readChar(); // Voy leyendo carácter a carácter el apellido y lo guardo
                apellido[i]=aux; // en el array apellido
            }
            String apellidos = new String (apellido);
            dep = file.readInt(); //Lectura de departamento y salario
            a = file.getFilePointer();
            salario = file.readDouble();

            System.out.printf("ID: %s, Departamento: %d, Salario: %.2f %n", id, dep, salario);
        }


    }
}
