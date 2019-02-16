import primero.*;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**Para modificar un objeto, igual que para borrarlo, primero hemos de cargarlo,
a continuación realizamos la modificaciones y, por último, utilizamos el
método update(). Realiza un programa que modifique el salario y el
departamento del empleado 7369, sumando 1000 al salario y asignándole el
departamento 30..**/
public class Main {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		//System.out.println("Inserto una fila en emple");
		
		
		//Creamos un nuevo objeto Depart y damos valor a sus atributos
		//dep es una instancia permanente de Depart
		Depart dep = (Depart)session.get(Depart.class, 30);
		
		Emple emp = new Emple();
		emp = (Emple)session.get(Emple.class, 7369);
		System.out.println("Salario Antes del cambio:"+emp.getSalario());
		emp.setDepart(dep);
		emp.setSalario(emp.getSalario()+1000);
		session.update(emp);
		System.out.println("Salario nuevo:"+emp.getSalario());
		
		
		/**Emple emp = new Emple();
		Depart dep = new Depart();
		dep.setDeptNo(10);
		Date date = new Date(20191009);
		emp.setApellido("Apellido");
		emp.setComision(700);
		emp.setDepart(dep);
		emp.setDir(111);
		emp.setEmpNo(99);
		emp.setFechaAlt(date);
		emp.setOficio("EMPLEADO");
		emp.setSalario(1500);
		**/
		
		//Guardamos en la base de datos y comprometemos la información
		session.save(emp);
		tx.commit();
		session.close();
		System.exit(0);
	}
}	