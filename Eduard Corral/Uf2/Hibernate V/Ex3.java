import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**Visualiza los nombres de los empleados junto con el departamento al que
pertenecen**/
public class Ex3 {
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple as emp inner join emp.depart as dep");
		List <Object> lista =q.list();
		Iterator <Object> iter = lista.iterator();
		
		
		while (iter.hasNext()){
			Object[] arrayObjetos = (Object[]) iter.next();
			Emple emple = (Emple) arrayObjetos[0];
			Depart dep =(Depart) arrayObjetos[1];
					
			System.out.printf("Apellido %s,Departamento %s%n", emple.getApellido(), dep.getDnombre());
		}		session.close();
		System.exit(0);
	}
}