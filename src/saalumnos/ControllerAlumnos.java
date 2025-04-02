package saalumnos;

import dominio.Alumno;

public class ControllerAlumnos {
	private IFSAAlumnos saAlumnos = new FSAAlumnos();
	public Alumno consultarAlumno(String idCorreo) {
		return saAlumnos.consultarAlumno(idCorreo);
	}
}
