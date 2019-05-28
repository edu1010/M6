package javabeanNeodatis;
import java.beans.*;
import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable,PropertyChangeListener {
	private int numeroPedido;
	private Producto producto;
	private Date date;
	private int unidades;
	private PropertyChangeSupport propertySupport;	
	private baseDeDatos datos;

	public Pedido() {
		propertySupport = new PropertyChangeSupport (this);
	}


	public Pedido(Producto producto, baseDeDatos datos) {
		this.producto = producto;
		this.datos=datos;
	}


	public Pedido(int numeroPedido, Producto producto, Date date, int unidades) {
		super();
		this.numeroPedido = numeroPedido;
		this.producto = producto;
		this.date = date;
		this.unidades = unidades;
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

		if(evt.getPropertyName().equals("stockActual")) {
			java.util.Date fechaActual = new Date();

			//baseDeDatos datos = new baseDeDatos();
			int autoincre =datos.autoincrement()+1;
			int cant2=(int)evt.getNewValue();
			Pedido pedido= new Pedido(autoincre ,this.producto,fechaActual,cant2);
			datos.insertarPedido(pedido);
			//datos.cerrar();
			System.out.println("Pedido inserta");


		}


	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public PropertyChangeSupport getPropertySupport() {
		return propertySupport;
	}

	public void setPropertySupport(PropertyChangeSupport propertySupport) {
		this.propertySupport = propertySupport;
	}




}
