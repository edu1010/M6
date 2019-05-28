package javabeanNeodatis;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class Venta implements Serializable,PropertyChangeListener {
	private int numeroVenta;
	private int id;
	private Date fechaVenta;
	private int cantidad;
	private String observaciones;

	private PropertyChangeSupport propertySupport;

	public Venta() {
		propertySupport = new PropertyChangeSupport (this);
	}


	public Venta(int numeroVenta, int id, Date fechaVenta, int cantidad, String observaciones) {
		super();
		this.numeroVenta = numeroVenta;
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.observaciones = observaciones;
	}



	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		baseDeDatos datos = new baseDeDatos();
		ODB odb = datos.getOdb();

		if(evt.getPropertyName().equals("stockActual")) {
			//setObservaciones("Pendiente de pedido por falta de stock");
			//this.observaciones="Pendiente de pedido por falta de stock";	
			int ultimaVenta = datos.autoincrementVenta();
			Objects<Venta> ventas = odb.getObjects(Venta.class);
			for(Venta venta : ventas) {
				if(venta.getNumeroVenta() == ultimaVenta) {
					venta.setObservaciones("Pendiente de pedido por falta de stock");
					odb.store(venta);
				}
			}





		}



	}



	public int getNumeroVenta() {
		return numeroVenta;
	}



	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getFechaVenta() {
		return fechaVenta;
	}



	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public String getObservaciones() {
		return observaciones;
	}



	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
