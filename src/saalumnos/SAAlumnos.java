package saalumnos;

import java.util.Date;
import java.util.List;

import daoalumnos.*;
import dominio.Alumno;

public class SAAlumnos implements ISAAlumnos{
	
	private final IFDAOAlumnos daoAlumnos = new FDAOAlumnos();

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
		if (daoAlumnos.existeAlumno(nuevoAlumno.getIdCorreo()) == 0x1 ) {
			return 0x1;
		}
		return daoAlumnos.crearAlumno(nuevoAlumno);
	}

	@Override
	public int borrarAlumno(String idCorreo) {
		if (daoAlumnos.consultarAlumno(idCorreo) == null) {
			return 0x1;
		}
		return daoAlumnos.borrarAlumno(idCorreo);
	}

	@Override
	public int existeAlumno(String idCorreo) {
		return daoAlumnos.existeAlumno(idCorreo);
	}

	@Override
	public int editarAlumno(Alumno alumno) {
		if (daoAlumnos.existeAlumno(alumno.getIdCorreo()) == 0x1) {
			return 0x1;
		}
		return daoAlumnos.editarAlumno(alumno);
	}

	@Override
	public int consultarHorario(String idCorreo, Date horario) {
		if (daoAlumnos.existeAlumno(idCorreo) == 0x1) {
			return 0x1;
		}
		return daoAlumnos.consultarHorario(idCorreo, horario);
	}

}
