package DAOAlumnos;

import java.util.Date;
import java.util.List;

import Dominio.Alumno;

public interface IFDAOAlumnos {
	public Alumno consultarAlumno(String idCorreo);
	public List<Alumno> consultarAlumnos(String nombre, String apellidos);
	public boolean crearAlumno(Alumno nuevoAlumno);
	public boolean borrarAlumno(String idCorreo);
	public boolean existeAlumno(String idCorreo);
	public boolean editarAlumno(Alumno alumno);
	public boolean consultarHorario(String idCorreo, Date horario);
}
