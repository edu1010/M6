package dao;

public interface DepartamentoDAO {
	public boolean InsertarDep(Departamento departamento);
	public boolean EliminarDep(int deptno);
	public boolean ModificarDep(int deptn, Departamento departamento);
	public Departamento ConsultarDep(int deptno);

}
