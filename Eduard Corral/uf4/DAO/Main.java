package dao;

import java.io.IOException;

public class Main {
	public static void main(String[] args)throws IOException {
	DepartamentoDAO depDAO =  new DepartamentoImpl( );
	/* 1-- Inserta un nuevo departamento */
	/* 2-- Consulta el nuevo departamento */
	/* 3-- Modifica algunos valores del nuevo departamento*/
	/* 4-- Elimina el departamento creado */
	
	//1
	Departamento departamento = new Departamento(1, "Departamento", "Cataluña");
	depDAO.InsertarDep(departamento);
	
	//2
	Departamento consulta = depDAO.ConsultarDep(1);
	System.out.println("Departamento: "+consulta.getDeptno()+
			", nombre: "+consulta.getDnombre()+
			", lugar: "+consulta.getLoc());
	//3
	departamento.setDnombre("Departamento 1");
	departamento.setLoc("barcelona");
	depDAO.ModificarDep(departamento.getDeptno(), departamento);
	System.out.println("Modificado");
	System.out.println("Departamento: "+consulta.getDeptno()+
			", nombre: "+consulta.getDnombre()+
			", lugar: "+consulta.getLoc());	
	//4
	depDAO.EliminarDep(departamento.getDeptno());
	System.out.println("Eliminado");
	}
}
