package eXist;

import java.io.*;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;
/**A partir de los documentos productos.xml y zonas.xml, haz un programa que
reciba un número de zona por parámetro y genere un documento con nombre
zonaXX.xml donde XX es la zona solicitada. El documento debe contener los
productos de esta zona y las siguientes etiquetas: <cod_prod>,
<denominación>, <precio>, <nombre_zona>, <director> y <stock>. Donde el
stock se calcula restando el stock actual y el stock mínimo.**/
public class Ex2 {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = null;
		
		String texto="";
		
		String zona="";
		
		try {
			System.out.println("Introduce la zona");
			zona=reader.readLine();
			
			 writer = new BufferedWriter(new FileWriter("zona" + zona + ".xml"));
			writer.write("<?xml version='1.0' encoding='UTF-8'?>");
			writer.newLine();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try{
			XQDataSource server = new ExistXQDataSource();
			server.setProperty ("serverName", "192.168.56.102");
			server.setProperty ("port","8080");
			server.setProperty ("user","admin");
			server.setProperty ("password","austria");
			XQConnection conn = server.getConnection();
			XQPreparedExpression consulta;
			XQResultSequence resultado;


			consulta = conn.prepareExpression 
					
					("for $z in /productos/produc[cod_zona=" + zona + "] "
							+ "let $cod_prod:=$z/cod_prod/text() "
							+ "let $denominacion:=$z/denominacion/text()"
							+ " let $precio:=$z/precio/text() "
							+ "let $stock:=$z/(stock_actual - stock_minimo) "
							+ "let $nombre:=/zonas/zona[cod_zona=" + zona + "]/nombre/text()"
									+ "let $director:=/zonas/zona[cod_zona=" + zona + "]/director/text()return "
											+ "<zona"+zona+ "><cod_prod>{$cod_prod}</cod_prod><denominacion>{$denominacion}</denominacion><precio>{$precio}</precio><stock>{$stock}</stock><nombre>{$nombre}</nombre><director>{$director}</director>"+"</zona"+zona+">");

			
			

			resultado = consulta.executeQuery();


			while (resultado.next()) {
				texto=(resultado.getItemAsString(null));
				System.out.println(texto);
				writer.write(texto);
				writer.newLine();
				
			}
			writer.close();
			conn.close();
			
		} catch (XQException ex) {
			System.out.println("Error al operar"+ex.getMessage());
		}
	}

}
