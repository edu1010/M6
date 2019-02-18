import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**Visualiza el apellido y salario de los empleados del departamento 20. (Ayuda:
la consulta HQL necesaria es: “from Emple as e where e.depart.deptNo=20”)**/
public class Ex1 {
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple as e where e.depart.deptNo=20");
		List <Emple> lista =q.list();
		Iterator <Emple> iter = lista.iterator();
		
		while (iter.hasNext()){
			Emple emple = (Emple) iter.next();
			System.out.printf("Apellido %s,salario %s%n", emple.getApellido(), emple.getSalario());
		}		session.close();
		System.exit(0);
	}
}