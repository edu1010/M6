package javabeanNeodatis;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Producto implements Serializable{//id,nombre,stockactual,stockminimi,precio
	private int id;
	private String nombre;
	private int stockActual;
	private int sotckMinimo;
	private int precio;
	private PropertyChangeSupport propertySupport;


	public Producto() {
		propertySupport= new PropertyChangeSupport(this);

	}


	public Producto(int id, String nombre, int stockActual, int sotckMinimo, int precio) {
		this.setId(id);
		this.setNombre(nombre);
		this.setStockActual(stockActual);
		this.setSotckMinimo(sotckMinimo);
		this.setPrecio(precio);
		propertySupport= new PropertyChangeSupport(this);

	}

	public void addPropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStockActual() {
		return stockActual;
	}
	public void setStockActual(int stockActual) {
		int stockold =this.stockActual;
		this.stockActual = stockActual;

		if(stockActual< getSotckMinimo()) {	
			propertySupport.firePropertyChange("stockActual", stockold, stockActual);
			this.stockActual=stockold;
		}			
	}







	public int getSotckMinimo() {
		return sotckMinimo;
	}
	public void setSotckMinimo(int sotckMinimo) {
		this.sotckMinimo = sotckMinimo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}



}
