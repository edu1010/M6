import java.io.*;
import java.util.ArrayList;

public class Projecto {
    public static void abrirXml(PrintWriter pw, int numero){
        pw.println("<elem nr=\""+numero+"\">");

    }
    public static int numeroLineas()throws IOException{
        int numeroLineas=0;
        FileReader fr = new FileReader("datosProjecto.txt");
        BufferedReader bf = new BufferedReader(fr);
        String sCadena;
        while ((sCadena = bf.readLine())!=null) {
            numeroLineas++;
        }

        return numeroLineas;
    }
    public static ArrayList<String> elemento() throws IOException{
        ArrayList<String> elemento = new ArrayList<String>();
        FileReader fr = new FileReader("elementosProjecto.txt");
        BufferedReader bf = new BufferedReader(fr);
        String sCadena;
        while ((sCadena = bf.readLine())!=null) {
            elemento.add(sCadena);
        }
        return elemento;
    }
    public static void main(String[] args)throws IOException {
        int contador=0;
        PrintWriter pw = new PrintWriter(new FileWriter("resultado.xml"));

        File elementos = new File("elementosProjecto.txt");
        File datos = new File("datosProjecto.txt");

        FileReader fr = new FileReader("datosProjecto.txt");
        BufferedReader bf = new BufferedReader(fr);
        String sCadena;
        FileInputStream FileInput = new FileInputStream(elementos);
        DataInputStream lector = new DataInputStream(FileInput);

        FileInputStream FileInput2 = new FileInputStream(datos);
        DataInputStream lector2 = new DataInputStream(FileInput);
        ArrayList<String> elemento = elemento();
        int numeroLineas=numeroLineas();
        pw.println("<doc>");
        for(int i=0;i<numeroLineas;i++){
            abrirXml(pw,i);
            for( int x = 0 ; x < elemento.size() ; x++ ){
                pw.println("<"+elemento.get( x )+">");
                            if( bf.readLine()!=null){
                                pw.println(bf.readLine());
                            }


                pw.println("</"+elemento.get( x )+">");
            }


            pw.println("</elem>");
            }
        pw.println("</doc>");
        pw.close();
        lector.close();
        lector2.close();
        FileInput.close();

    }

}
