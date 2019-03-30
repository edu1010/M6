package eXist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;



import net.xqj.exist.ExistXQDataSource;

/**A partir del documento universidad.xml, haz un programa que muestre los
empleados del departamento cuyo tipo es elegido por el usuario. Si no hay
empleados o el tipo de departamento aportado por el usuario no existe, se
debe de informar al usuario.**/

public class Ex1 {
	public static void main(String[] args){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String texto="";
		int contador=0;
		try {
			System.out.println("Introduce el tipo");
			texto=reader.readLine();
			while (!texto.equals("A") && !texto.equals("B") ) {
				System.out.println("No existe este tipo, introduce otro");
				texto=reader.readLine();
			}
			
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
					("for $z in doc('nueva/universidad.xml')//departamento[@tipo ='"+texto+"'"+"]/empleado/nombre return $z");
			
			resultado = consulta.executeQuery();
			
			
			while (resultado.next()) {
				System.out.println(resultado.getItemAsString(null));
				contador=contador+1;
			}
			if (contador ==0) {
				System.out.println("No hay usuarios");
			}
			conn.close();
		} catch (XQException ex) {
			System.out.println("Error al operar"+ex.getMessage());
			}
	}

}
