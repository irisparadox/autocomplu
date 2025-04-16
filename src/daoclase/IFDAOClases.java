package daoclase;

import java.sql.Date;
import java.util.List;

import dominio.Clase;

public interface IFDAOClases {
	public Clase consultarClase(String idClase);
	public List<Clase> consultarClasesAlumno(String idAlumno);
	public List<Clase> consultarClasesProfesor(String idProfesor);
	public int crearClase(Clase nuevaClase);
	public int existeClase(String idCorreo);
	public int editarClase(Clase clase);
	public int eliminarClase(String idClase);
	public int hayAlumno(String idClase);
	public int hayProfesor(String idClase);
	public int hayClaseAlumnoHora(String idAlumno,Date fecha);
	public int hayClaseProfesorHora(String idProfesor,Date fecha); 
}
