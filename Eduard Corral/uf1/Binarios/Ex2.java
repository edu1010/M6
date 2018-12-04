import java.io.* ;
public class Ex2 {
    public static void main (String [] args) throws IOException
    {
        String []Personas ={"Jesus","Oscar","Xavi","Jordi"};
        int []Edades ={18,22,19,20};
        File fichero = new File ("FicheroDatos.dat");
        //FileOutputStream fileout = new FileOutputStream (fichero);
        //FileInputStream filein = new FileInputStream(fichero);

        DataOutputStream DataOut = new DataOutputStream(new FileOutputStream(fichero));
        int i;
        for (i=0; i<Personas.length; i++) {//Bucle escritura
            DataOut.writeUTF(Personas[i] + " ");//Escribimos el nombre de la persona
            DataOut.writeInt(Edades[i]);//Escribimos la edad
        }
            DataOut.close();
    }
}
