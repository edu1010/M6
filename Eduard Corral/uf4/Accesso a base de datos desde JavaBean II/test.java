package javabeanNeodatis;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class test {
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		baseDeDatos datos = new baseDeDatos();
		System.out.println("Introduce el identificador del producto");
		int id= Integer.parseInt(reader.readLine());

		System.out.println("introduce la cantidad");
		int cantidad= Integer.parseInt(reader.readLine());

		Producto solicitado=null;

		Pedido pedido =new Pedido();
		//Venta venta = new Venta();


		try{
			for(Producto producto : datos.getProducto()) {
				if(producto.getId() == id) {
					solicitado = producto;

					java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					Venta venta = new Venta(datos.autoincrementVenta(),id,fecha, cantidad,"Sin observación");
					//int numeroVenta, int id, Date fechaVenta, int cantidad, String observaciones
					datos.insertarVenta(venta);

					pedido.setProducto(solicitado);
					solicitado.addPropertyChangeListener (pedido);
					solicitado.addPropertyChangeListener(venta);
					solicitado.setStockActual(1);

				}
			}
		}catch(Exception e) {
			System.out.println(solicitado);
			if(solicitado ==null) {
				System.out.println("Este producto no existe");
			}
		}
		datos.cerrar();//Hay que cerrar antes porque los metodos abren otra vez una base de datos y no puede haber dos accesos simultaneos
		VerProductos.verProductos();
		VerProductos.verPedidos();
		VerProductos.verVentas();

		/*Pruebas de la parte uno y para identificar que todo funcionara correctamente 

		//baseDeDatos datos = new baseDeDatos(); si hacemos conexion ahora, como la funcion vuelve a abrir conexion no iría, por eso no se abre aquí
		VerProductos.verProductos();
		VerProductos.verPedidos();


		//Se generara un pedido y no cambiara el stock a uno pq esta debajo del minimo

		baseDeDatos datos = new baseDeDatos();
		Producto producto = datos.getProducto(3);
		Pedido pedido = new Pedido(producto, datos);

		producto.addPropertyChangeListener(pedido);
		producto.setStockActual(1);
		//datos.cerrar();


		//datos.abrir();
		//Aqui si modificara dado que no esta debajo
		Producto producto2 = datos.getProducto(6);
		Pedido pedido2 = new Pedido(producto2, datos);
		producto2.addPropertyChangeListener(pedido2);

		Venta venta = new Venta();
		producto2.addPropertyChangeListener(venta);

		producto2.setStockActual(4);
		datos.cerrar();
		VerProductos.verProductos();

		VerProductos.verPedidos();
		VerProductos.verVentas();
		//datos.cerrar();
		 */

	}
}
