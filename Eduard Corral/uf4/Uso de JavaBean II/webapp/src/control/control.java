package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeanNeodatis.Producto;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public control() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String op = request.getParameter("accion");
		if (op.equals("alta")) {
			System.out.println("depurando");
			response.sendRedirect("alta.jsp");     		
		}
		 if (op.equals("insertar")) {
			 control.Departamentos dep = (control.Departamentos) request.getAttribute("depart");
				BaseDEdatos datos = new BaseDEdatos();
				datos.insertarDep(dep);
				datos.cerrar();
		 }else if(op.equals("ver")) {
			 control.Departamentos dep = (control.Departamentos) request.getAttribute("depart");
				BaseDEdatos datos = new BaseDEdatos();
			
				
				System.out.println("Comprovación inserción:");
				for(Departamentos dep : datos.getProducto()) {
					System.out.println("id: "+dep.getDeptno() + " nombre: "+ dep.getDnombre() +
							" lugar: "+ dep.getLoc() +" Stock minimo: ");
				}		
				datos.cerrar();
				
				
				
	
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
