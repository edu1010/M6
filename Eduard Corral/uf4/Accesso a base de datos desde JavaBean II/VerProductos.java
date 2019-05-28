package javabeanNeodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class VerProductos {
	public static void verProductos() {
		baseDeDatos datos = new baseDeDatos();
		
		System.out.println("Lista de productos:");
		for(Producto producto : datos.getProducto()) {
			System.out.println("id: "+producto.getId() + " nombre: "+ producto.getNombre() +
					" Stock actual: "+ producto.getStockActual() +" Stock minimo: "+ + producto.getSotckMinimo() + " precio: "+ producto.getPrecio());
		}		
		datos.cerrar();
	}
	
	public static void verPedidos() {
		baseDeDatos datos = new baseDeDatos();
		
		System.out.println("Lista de pedidos:");

		for(Pedido pedido : datos.getPedido()) {
			System.out.println("Numero pedido:"+pedido.getNumeroPedido() + " producto: "+  pedido.getProducto() +
					" fecha: "+  pedido.getDate() + " unidades: "+ pedido.getUnidades());
		}
		datos.cerrar();
	}
	public static void verVentas() {
		baseDeDatos datos = new baseDeDatos();
		
		System.out.println("Lista de ventas:");


		for(Venta venta : datos.getVenta()) {
			System.out.println(venta.getNumeroVenta() + 
					" Id venta" + venta.getId() +
					" Cantidad: "+ venta.getCantidad() + 
					" Observaciones: "+ venta.getObservaciones());
	}
		
		datos.cerrar();
		
		
		
		
		
	}


	public static void main(String[] args) {
		baseDeDatos datos = new baseDeDatos();
		ODB odb = datos.getOdb();

		Objects<Producto> productos = odb.getObjects(Producto.class);
		Objects<Pedido> pedidos = odb.getObjects(Pedido.class);


		System.out.println("Lista de productos:");

		for(Producto producto : productos) {
			System.out.println("id: "+producto.getId() + " nombre: "+ producto.getNombre() +
					" Stock actual: "+ producto.getStockActual() +" Stock minimo: "+ + producto.getSotckMinimo() + " precio: "+ producto.getPrecio());
		}

		System.out.println("Lista de pedidos:");

		for(Pedido pedido : pedidos) {
			System.out.println("Numero pedido:"+pedido.getNumeroPedido() + " producto: "+  pedido.getProducto() +
					" fecha: "+  pedido.getDate() + " unidades: "+ pedido.getUnidades());
		}


		datos.cerrar();
	}



}
