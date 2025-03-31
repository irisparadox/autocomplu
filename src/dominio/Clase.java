package dominio;

import java.util.Date;

public class Clase {
	private String idClase;
	private Date fecha;
	private Alumno alumno;
	private Profesor profesor;
	public String getIdClase() {
		return idClase;
	}
	public void setIdClase(String idClase) {
		this.idClase = idClase;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
}
