package saclases;

import java.sql.Date;
import java.util.List;

import dominio.Alumno;
import dominio.Clase;
import dominio.Profesor;

public interface IFSAClases {

	
	public int createClase(Alumno idAlumno, String idClase, Date fecha,Profesor prof);
	public int eliminarClase(String idClase);
	public Clase consultarClase(String idClase);
	public List<Clase> consultarClasesAlumno(String idAlumno);
	public List<Clase> consultarClasesProfesor(String idProfesor);
	public int editarClase(Clase clas);
	
}
