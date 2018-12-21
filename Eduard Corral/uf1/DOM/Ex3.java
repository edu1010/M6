import java.io.File;
        import javax.xml.parsers.*;
        import org.w3c.dom.*;
        /**5.Crea un programa Java que lea el documento anterior y muestre toda la
         información que contenga.**/
public class Ex3 {
    public static void main (String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File ("canciones.xml"));
            System.out.printf ("Elemento raíz : %s %n", document.getDocumentElement().getNodeName());

            NodeList albums = document.getElementsByTagName("album");

            System.out.printf ("Nodos empleado a recorrer: %d %n", albums.getLength());

            for (int i = 0; i <= albums.getLength()-1; i++) {
                Node album = albums.item(i);
                if (album.getNodeType() == Node.ELEMENT_NODE){
                    Element elemento = (Element) album;

                    //System.out.printf("album = %s %n", elemento.getElementsByTagName("album").item(0).getTextContent());
                    System.out.printf("autor = %s %n", elemento.getElementsByTagName("autor").item(0).getTextContent());
                    System.out.printf("titulo = %s %n", elemento.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.printf("formato = %s %n", elemento.getElementsByTagName("formato").item(0).getTextContent());
                }
            }
        }catch (Exception e) {e.printStackTrace();}
    }
}
