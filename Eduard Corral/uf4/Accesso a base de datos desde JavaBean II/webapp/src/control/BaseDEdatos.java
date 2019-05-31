package control;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;




public class BaseDEdatos {
	private org.neodatis.odb.ODB odb;

	public BaseDEdatos() {
		odb = ODBFactory.open("dep.DB");
	}

	public void insertarDep(Departamentos departamento) {
		odb.store(departamento);
		odb.commit();
	}
	public Objects<Departamentos> getProducto() {
		return odb.getObjects(Departamentos.class);
	}
	public Departamentos getProducto(int deptno) {
		//ICriterion condicion = Where.equal("id", productoEncontrar); 
		//CriteriaQuery query = new CriteriaQuery(Producto.class, condicion);
		ICriterion criterio = Where.equal("deptno", deptno);
		CriteriaQuery query = new CriteriaQuery(Departamentos.class, criterio);

		Objects<Departamentos> departamentos = odb.getObjects(query);
		if (departamentos.hasNext()) {
			return departamentos.getFirst();
		}
		System.out.print("No existe");
		return null;
	}	
	public void abrir() {
		this.odb = ODBFactory.open("pedidos_productos.DB");
	}
	
	public void cerrar() {
		odb.close();

	}
	public org.neodatis.odb.ODB getOdb() {
		return odb;
	}

	public void setOdb(org.neodatis.odb.ODB odb) {
		this.odb = odb;
	}

}
