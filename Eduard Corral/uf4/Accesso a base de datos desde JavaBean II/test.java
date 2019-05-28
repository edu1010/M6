package javabeanNeodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class test {
	public static void main(String[] args) {
		//baseDeDatos datos = new baseDeDatos(); si hacemos conexion ahora, como la funcion vuelve a abrir conexion no iría, por eso no se abre aquí
		VerProductos.verProductos();
		VerProductos.verPedidos();


		//Se generara un pedido y no cambiara el stock a uno pq esta debajo del minimo
		
		baseDeDatos datos = new baseDeDatos();
		Producto producto = datos.getProducto(3);
		Pedido pedido = new Pedido(producto, datos);

		producto.addPropertyChangeListener(pedido);
		producto.setStockActual(1);
//		datos.cerrar();


	//	datos.abrir();
		//Aqui si modificara dado que no esta debajo
		Producto producto2 = datos.getProducto(6);
		Pedido pedido2 = new Pedido(producto2, datos);
		producto2.addPropertyChangeListener(pedido2);
		producto2.setStockActual(4);
		datos.cerrar();
		VerProductos.verProductos();
		
		VerProductos.verPedidos();

		//datos.cerrar();


	}
}
