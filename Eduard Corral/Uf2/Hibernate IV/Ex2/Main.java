import primero.*;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Set;
import java.util.Iterator;

/**Obtén los datos del departamento 10 y el APELLIDO y SALARIO de sus
empleados. Ayuda: para obtener los empleados usamos el método
getEmples() de la clase Depart y usamos un Iterator (java.util.Iterator) para
recorrer la lista de empleados.**/
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
		Depart dep = (Depart)session.get(Depart.class, 10);
		Set<Emple> listaemp = dep.getEmples();
		Iterator<Emple> it = listaemp.iterator();
		Emple emp = new Emple();
		try {
			while(it.hasNext()) {
				emp = it.next();
				System.out.println ("El apellido es:"+emp.getApellido()+", el salario es:"+emp.getSalario());
			}
		}
		catch(Exception e){
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