package javabean;
import java.beans.*;
public class PruebasFinales {
	public static void main(String[] args){
		Empleado empleado = new Empleado("12345578Q","Empleado ");
		PanelEmpleado panelEmpleado = new PanelEmpleado();
		
		empleado.addPropertyChangeListener(panelEmpleado);
		empleado.setCargo("CEO");
		System.out.println(empleado.getCargo());
		empleado.setCargo("Inventado");
		System.out.println(empleado.getCargo());
		empleado.setSueldo(1100);
		System.out.println(empleado.getSueldo());
		
		empleado.setSueldo(10000000);
		System.out.println(empleado.getSueldo());
	}
}
