package DAOAlumnos;

import java.util.Date;
import java.util.List;

import Dominio.Alumno;

public class FDAOAlumnos implements IFDAOAlumnos {
	private IDAOAlumnos daoAlumnos;
	public Alumno consultarAlumno(String idCorreo) {
		return daoAlumnos.consultarAlumno(idCorreo);
	}
	
	public List<Alumno> consultarAlumnos(String nombre, String apellidos) {
		return daoAlumnos.consultarAlumnos(nombre, apellidos);
	}
	
	public boolean crearAlumno(Alumno nuevoAlumno) {
		return daoAlumnos.crearAlumno(nuevoAlumno);
	}
	
	public boolean borrarAlumno(String idCorreo) {
		return daoAlumnos.borrarAlumno(idCorreo);
	}
	
	public boolean existeAlumno(String idCorreo) {
		return daoAlumnos.existeAlumno(idCorreo);
	}
	
	public boolean editarAlumno(Alumno alumno) {
		return daoAlumnos.editarAlumno(alumno);
	}
	
	public boolean consultarHorario(String idCorreo, Date horario) {
		return daoAlumnos.consultarHorario(idCorreo, horario);
	}
}
