package daoalumnos;

import java.util.Date;
import java.util.List;

import dominio.Alumno;

public class FDAOAlumnos implements IFDAOAlumnos {
	private IDAOAlumnos daoAlumnos = new DAOAlumnos();
	
	@Override
	public Alumno consultarAlumno(String idCorreo) {
		return daoAlumnos.consultarAlumno(idCorreo);
	}
	
	@Override
	public List<Alumno> consultarAlumnos(String nombre, String apellidos) {
		return daoAlumnos.consultarAlumnos(nombre, apellidos);
	}
	
	@Override
	public int crearAlumno(Alumno nuevoAlumno) {
		return daoAlumnos.crearAlumno(nuevoAlumno);
	}
	
	@Override
	public int borrarAlumno(String idCorreo) {
		return daoAlumnos.borrarAlumno(idCorreo);
	}
	
	@Override
	public int existeAlumno(String idCorreo) {
		return daoAlumnos.existeAlumno(idCorreo);
	}
	
	@Override
	public int editarAlumno(Alumno alumno) {
		return daoAlumnos.editarAlumno(alumno);
	}
	
	@Override
	public int consultarHorario(String idCorreo, Date horario) {
		return daoAlumnos.consultarHorario(idCorreo, horario);
	}
}
