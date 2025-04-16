package saclases;

import java.sql.Date;
import java.util.List;

import dominio.Alumno;
import dominio.Clase;
import dominio.Profesor;

public class FSAClases implements IFSAClases {

	
	private ISAClases saClases = new SAClases();	
	
	@Override
	public int createClase(Alumno idAlumno, String idClase, Date fecha, Profesor prof) {
		return saClases.createClase(idAlumno, idClase, fecha, prof);
	}

	@Override
	public int eliminarClase(String idClase) {
		return saClases.eliminarClase(idClase);
	}

	@Override
	public Clase consultarClase(String idClase) {
		
		return saClases.consultarClase(idClase);
	}

	@Override
	public List<Clase> consultarClasesAlumno(String idAlumno) {
		return saClases.consultarClasesAlumno(idAlumno);
	}

	@Override
	public List<Clase> consultarClasesProfesor(String idProfesor) {
		return saClases.consultarClasesProfesor(idProfesor);
	}

	@Override
	public int editarClase(Clase clas) {
		return saClases.editarClase(clas);
	}

}

