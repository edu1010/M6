package javabeanNeodatis;

import java.util.ArrayList;

public class LlenarProductos {
	public static void main(String[] args) {
		baseDeDatos datos = new baseDeDatos();
		ArrayList<Producto> productos = new ArrayList<Producto>();

		Producto p1 = new Producto(1, "Duruss Cobalt", 10, 3, 220);
		System.out.println(p1.getId()+"");
		Producto p2 = new Producto(2, "Varlion Avant Carbon", 5, 2, 176);
		Producto p3 = new Producto(3, "Star Vie Pyramid R50", 20, 5, 193);
		Producto p4 = new Producto(4, "Dunlop Titan", 8, 3, 85);
		Producto p5 = new Producto(5, "Vision King", 7, 1, 159); 
		Producto p6 = new Producto(6, "Slazenger Reflex Pro", 5, 2, 80);

		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		productos.add(p5);
		productos.add(p6);
		
		for (Producto producto : productos) {
			datos.insertarProducto(producto);
			System.out.println("insertado");
		}





//Ver si se ha insertado realmente
		for(Producto producto : datos.getProducto()) {
			System.out.println("id: "+producto.getId() + " nombre: "+ producto.getNombre() +
					" Stock actual: "+ producto.getStockActual() +" Stock minimo: "+ + producto.getSotckMinimo() + " precio: "+ producto.getPrecio());
		}	
		datos.cerrar();


	}

}
