package dao;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

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
		return false;
	}

	@Override
	public boolean ModificarDep(int deptn, Departamento departamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Departamento ConsultarDep(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}
	public static ODB getOdb() {
		return odb;
	}

	public static void setOdb(ODB odb) {
		DepartamentoImpl.odb = odb;
	}
}
