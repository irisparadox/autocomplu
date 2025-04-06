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
	
	public int comprarClases(Alumno alumno) {
		alumno.setNumClasesPendientes(alumno.getNumClasesPendientes() + 10);
		return saAlumnos.editarAlumno(alumno);
	}
	
	public int editarPerfilNoAdmin(Alumno alumno, String nuevoTlf, String nuevaContra) {
		alumno.setTelefono(nuevoTlf);
		alumno.setContrasenha(nuevaContra);
		return saAlumnos.editarAlumno(alumno);
	}
}
