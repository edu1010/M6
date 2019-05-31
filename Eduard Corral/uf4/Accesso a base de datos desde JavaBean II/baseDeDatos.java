package javabeanNeodatis;

import java.math.BigDecimal;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class baseDeDatos {

	private org.neodatis.odb.ODB odb;

	public baseDeDatos() {
		this.odb = ODBFactory.open("Producto_Ped.BD");
	}

	public void cerrar() {
		odb.close();

	}
	public void abrir() {
		this.odb = ODBFactory.open("pedidos_productos.DB");
	}
	public void insertarProducto(Producto producto) {
		this.odb.store(producto);
		this.odb.commit();
	}

	public void insertarPedido(Pedido pedido) {
		odb.store(pedido);
		this.odb.commit();
	}
	public void insertarVenta(Venta venta) {
		odb.store(venta);
		this.odb.commit();

	}

	public org.neodatis.odb.ODB getOdb() {
		return odb;
	}

	public void setOdb(org.neodatis.odb.ODB odb) {
		this.odb = odb;
	}

	public int autoincrement() {
		Values values = odb.getValues(new ValuesCriteriaQuery(Pedido.class).max("numeroPedido"));
		BigDecimal idasumar = (BigDecimal) values.getFirst().getByAlias("numeroPedido");
		return idasumar.intValue();
	}
	public int autoincrementVenta() {
		Values values = odb.getValues(new ValuesCriteriaQuery(Venta.class).max("numeroVenta"));
		BigDecimal idasumar = (BigDecimal) values.getFirst().getByAlias("numeroVenta");
		return idasumar.intValue();
	}
	
	public Objects<Producto> getProducto() {
		return odb.getObjects(Producto.class);
	}

	public Objects<Pedido> getPedido() {
		return odb.getObjects(Pedido.class);
	}
	public Objects<Venta> getVenta() {
		return odb.getObjects(Venta.class);
	}

	public Producto getProducto(int productoEncontrar) {
		ICriterion condicion = Where.equal("id", productoEncontrar);
		CriteriaQuery query = new CriteriaQuery(Producto.class, condicion);
		Objects<Producto> productos = odb.getObjects(query);
		if (productos.hasNext()) {
			return productos.getFirst();
		}
		System.out.print("No existe");
		return null;
	}


	/*Propiedad de tipo org.neodatis.odb.ODB
○ Un constructor que abrirá la base de datos:
○ Un método para cerrar la base de datos
○ Un método para insertar un producto
○ Un método para insertar un pedido
○ Un método parar insertar una venta.*/


}
