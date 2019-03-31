package XQuery;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;

import net.xqj.exist.ExistXQDataSource;
/**Realiza un programa que añada un departamento nuevo al fichero
departamentos.xml. **/
public class Ex2 {
	public static void main(String[] args) {
		try {
			// Configuramos conexión como hemos hecho en ocasiones anteriores
			XQDataSource server = new ExistXQDataSource();
			server.setProperty ("serverName", "192.168.56.102");
			server.setProperty ("port","8080");
			server.setProperty ("user","admin");
			server.setProperty ("password","austria");
			XQConnection conn = server.getConnection();
			//XQPreparedExpression consulta;
		

			XQExpression consulta = conn.createExpression();
			
			// Ejecutamos la expresión XQuery: actualiza el apellido del empleado con EMP_NO=7369 a 1009
			String actualitzacio ="update insert <DEP_ROW>\n <DEPT_NO>50</DEPT_NO>\n <DNOMBRE>INORMATICA</DNOMBRE>\n   <LOC>VALENCIA</LOC>\n  </DEP_ROW> into /departamentos";
			
			//insert node (attribute { 'a' } { 5 }, 'text', <e/>) into /n
			consulta.executeCommand(actualitzacio);
		} catch (XQException e) {
			e.printStackTrace();
		}
	}

}
