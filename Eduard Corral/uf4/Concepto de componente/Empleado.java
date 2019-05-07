package javabean;

import java.beans.*;
import java.io.Serializable;
@SuppressWarnings("serial")
public class Empleado implements Serializable {
	String NIF;
	String nombre;
	String cargo;
	int sueldo;
	private PropertyChangeSupport propertySupport;

	public Empleado() {
		cargo="junior";
		sueldo=1000;
		propertySupport= new PropertyChangeSupport(this);

	}
	public Empleado(String nif, String name) {
		this();
		this.setNIF(nif);
		this.setNombre(name);
		propertySupport= new PropertyChangeSupport(this);

	}

	public void addPropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}


	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargoNuevo) {
		try {
			if(!(cargoNuevo.equals("NULL") || cargoNuevo.equals("") || cargoNuevo.equals(""))) {
				propertySupport.firePropertyChange("cargo", this.cargo, cargoNuevo);
				this.cargo = cargoNuevo;
			}
		}catch(Exception e) {
			System.out.println("Cargo no valido");
		}
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldoNuevo) {
		try{if(sueldoNuevo>0) {
			propertySupport.firePropertyChange("sueldo", this.sueldo, sueldoNuevo);
			this.sueldo = sueldoNuevo;
			}
		}catch(Exception e){
			System.out.println("El sueldo supera el valor de porcentaje permitido");
		}
	}




}
