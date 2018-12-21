import java.io.* ;
/**Escribe un programa que inserte datos en “FicherosDatos.dat”. Los datos los
tomará de dos arrays definidos en el propio programa. Uno contendrá los
nombres de una serie de personas y el otro sus edades. Se irá recorriendo
los arrays e iremos escribiendo en el fichero el nombre (mediante el método
writeUTF(String str) y la edad (writeInt (int v))**/
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
