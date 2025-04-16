package daoclase;

import java.util.Date;
import java.util.List;

import dominio.Clase;

public class FDAOClases implements IFDAOClases {
	private IDAOClases daoClases = new DAOClases();

	@Override
	public Clase consultarClase(String idClase) {
		return daoClases.consultarClase(idClase);
	}

	@Override
	public int hayAlumno(String idClase) {
		return daoClases.hayAlumno(idClase);
	}

	@Override
	public int hayProfesor(String idClase) {
		return daoClases.hayProfesor(idClase);
	}


	@Override
	public int crearClase(Clase nuevaClase) {
		return daoClases.crearClase(nuevaClase);
	}


	@Override
	public int editarClase(Clase clase) {
		return daoClases.editarClase(clase);
	}

	@Override
	public int existeClase(String idClase) {
		return daoClases.existeClase(idClase);
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
	public int eliminarClase(String idClase) {
		return daoClases.eliminarClase(idClase);
	}
}
