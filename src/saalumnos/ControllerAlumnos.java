package saalumnos;

import dominio.Alumno;

public class ControllerAlumnos {
	private IFSAAlumnos saAlumnos = new FSAAlumnos();
	public Alumno consultarAlumno(String idCorreo) {
		return saAlumnos.consultarAlumno(idCorreo);
	}
	
	public int editarContrasenha(Alumno alumno, String contrasenhaNueva) {
		alumno.setContrasenha(contrasenhaNueva);
		return saAlumnos.editarAlumno(alumno);
	}
}
