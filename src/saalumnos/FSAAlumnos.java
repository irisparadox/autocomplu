package saalumnos;

import java.util.List;

import dominio.Alumno;

public class FSAAlumnos implements IFSAAlumnos {
	
	private ISAAlumnos saAlumnos = new SAAlumnos();
	
	@Override
	public Alumno consultarAlumno(String idCorreo) {
		return saAlumnos.consultarAlumno(idCorreo);
	}

	@Override
	public List<Alumno> consultarAlumnos(String nombre, String apellidos) {
		return saAlumnos.consultarAlumnos(nombre, apellidos);
	}

	@Override
	public int crearAlumno(Alumno nuevoAlumno) {
		return saAlumnos.crearAlumno(nuevoAlumno);
	}

	@Override
	public int borrarAlumno(String idCorreo) {
		return saAlumnos.borrarAlumno(idCorreo);
	}

	@Override
	public int existeAlumno(String idCorreo) {
		return saAlumnos.existeAlumno(idCorreo);
	}

	@Override
	public int editarAlumno(Alumno alumno) {
		return saAlumnos.editarAlumno(alumno);
	}
}
