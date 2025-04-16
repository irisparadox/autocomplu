package saclases;

import java.sql.Date;
import java.util.List;
import daoclase.IFDAOClases;
import daoclase.FDAOClases;
import dominio.Alumno;
import dominio.Clase;
import dominio.Profesor;

public class SAClases implements ISAClases {

	
	private final IFDAOClases daoClases = new FDAOClases();
	
	@Override
	public int createClase(Alumno alumno, String idClase, Date fecha, Profesor prof) {
		if(daoClases.hayClaseAlumnoHora(alumno.getIdCorreo(), fecha) == 0x1) {
			if(daoClases.hayClaseProfesorHora(prof.getIdCorreo(),fecha) == 0x1) {
				if(daoClases.existeClase(idClase) == 0x1) {
					Clase clas = new Clase();
					clas.setAlumno(alumno);
					clas.setFecha(fecha);
					clas.setIdClase(idClase);
					clas.setProfesor(prof);
					return daoClases.crearClase(clas);
				}
			}
		}
		return 0x1;
	}

	@Override
	public int eliminarClase(String idClase) {
		if(daoClases.existeClase(idClase)==0x0) {
			return daoClases.eliminarClase(idClase);
		}
		return 0x1;
	}

	@Override
	public Clase consultarClase(String idClase) {
		
		return daoClases.consultarClase(idClase);
	}

	@Override
	public List<Clase> consultarClasesAlumno(String idAlumno) {
		return daoClases.consultarClasesAlumno(idAlumno);
	}

	@Override
	public List<Clase> consultarClasesProfesor(String idProfesor) {
		return daoClases.consultarClasesProfesor(idProfesor);
	}

	@Override
	public int editarClase(Clase clas) {
		return daoClases.editarClase(clas);
	}

}
