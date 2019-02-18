import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**Muestra el salario medio y el número de empleados por departamento**/
public class Ex5 {
	public static void main(String[] args){
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("select avg(salario), count(*) from Emple emp group by emp.depart");
		List <Object> lista =q.list();
		Iterator <Object> iter = lista.iterator();
		String salario,numEmple, dep;
		
		while (iter.hasNext()){
			Object[] arrayObjetos = (Object[]) iter.next();
			salario= arrayObjetos[0].toString();
			numEmple= arrayObjetos[1].toString();
			//dep= arrayObjetos[2].toString();
			System.out.println("Saliro medio: "+salario+" numero de empleados: "+numEmple);

					
		}		session.close();
		System.exit(0);
	}
}

