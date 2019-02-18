import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**Visualiza los datos del señor “ARROYO”**/
public class Ex2 {
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple as e where e.apeliido='ARROYO'");
		List <Emple> lista =q.list();
		Iterator <Emple> iter = lista.iterator();
		
		while (iter.hasNext()){
			Emple emple = (Emple) iter.next();
			System.out.printf("Apellido %s,salario %s%n", emple.getApellido(), emple.getSalario());
		}		session.close();
		System.exit(0);
	}
}