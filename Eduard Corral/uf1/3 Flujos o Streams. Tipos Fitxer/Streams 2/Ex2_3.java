package Flujos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex2_3 {
    public static void main (String [] args) throws IOException {
        String prov[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jaen",
                "Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};

        File fichero = new File("/home/edu/IdeaProjects/m6/out/production/m6/Flujos/fichero.txt");
        FileWriter fic = new FileWriter (fichero);

        for (int i=0;i<prov.length;i++){
            fic.write(prov[i]);
            fic.append (' ');
        }

        fic.close (); // cerramos fichero
    }
}