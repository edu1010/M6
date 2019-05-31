package dao;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class DepartamentoImpl implements DepartamentoDAO {
	private static ODB odb;

	public DepartamentoImpl() {
		this.odb = ODBFactory.open("Departamento.DB");
	}




	@Override
	public boolean InsertarDep(Departamento departamento) {
		// TODO Auto-generated method stub
		try{
			odb.store(departamento);
			return true;	
		}
		catch (Exception e) {

			return false;}
	}

	@Override
	public boolean EliminarDep(int deptno) {
		// TODO Auto-generated method stub

		try {
			IQuery select = new CriteriaQuery(Departamento.class, Where.equal("deptno", deptno));
			Objects<Departamento> departamento = odb.getObjects(select);				
			Departamento departEliminar = (Departamento) departamento.getFirst();
			this.odb.delete(departEliminar);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean ModificarDep(int deptn, Departamento departamento) {
		// TODO Auto-generated method stub
		Departamento departamentoEdit = ConsultarDep(deptn);
		if (departamentoEdit!=null) {

			departamentoEdit.setDeptno(departamento.getDeptno());
			departamentoEdit.setDnombre(departamento.getDnombre());
			departamentoEdit.setLoc(departamento.getLoc());
			this.odb.store(departamentoEdit);

			return true;
		}else {
			return false;
		}
	}

	@Override
	public Departamento ConsultarDep(int deptno) {
		// TODO Auto-generated method stub
		IQuery select = new CriteriaQuery(Departamento.class,Where.equal("deptno", deptno));
		Objects<Departamento> departamento = odb.getObjects(select);	
		if(departamento!=null && departamento.size()>0) {
			Departamento departConsulta = (Departamento) departamento.getFirst();

			return departConsulta;	
		}
		else {
			System.out.println("El departamento consultado no existe");
			return null;
		}
	}

	public static ODB getOdb() {
		return odb;
	}

	public static void setOdb(ODB odb) {
		DepartamentoImpl.odb = odb;
	}
}
