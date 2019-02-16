import primero.*;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**Visualiza el apellido y el salario del empleado con número: 7369**/
public class Main {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		//System.out.println("Inserto una fila en emple");
		
		
		//Creamos un nuevo objeto Depart y damos valor a sus atributos
		
		Emple emp = (Emple)session.get(Emple.class, 7369);
		try {
			System.out.println ("El pellido es: "+emp.getApellido()+",el salario es: "+emp.getSalario());
		}
		catch(Exception e){
			System.out.println ("No existe el departamento");
			e.printStackTrace();
		}
		
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