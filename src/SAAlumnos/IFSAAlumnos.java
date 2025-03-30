package SAAlumnos;

public interface IFSAAlumnos {
	public Alumno consultarAlumno(String idCorreo);
	public List<Alumno> consultarAlumnos(String nombre, String apellidos);
	public int crearAlumno(Alumno nuevoAlumno);
	public int borrarAlumno(String idCorreo);
	public int existeAlumno(String idCorreo);
	public int editarAlumno(Alumno alumno);
	public int consultarHorario(String idCorreo, Date horario);
}
