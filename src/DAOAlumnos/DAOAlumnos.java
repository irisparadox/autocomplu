package DAOAlumnos;

import java.sql.*;
import java.util.Date;
import java.util.List;

import Dominio.Alumno;

public class DAOAlumnos implements IDAOAlumnos {

	@Override
	public Alumno consultarAlumno(String idCorreo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> consultarAlumnos(String nombre, String apellidos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int crearAlumno(Alumno nuevoAlumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarAlumno(String idCorreo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int existeAlumno(String idCorreo) {
		
		return 0;
	}

	@Override
	public int editarAlumno(Alumno alumno) throws IllegalStateException {
		int success = -0x1;
		try {
			//TODO setup database
			Connection connection = DriverManager.getConnection("TODO-URL", "root", "1234");
			String query = "UPDATE alumnos SET ...";
			PreparedStatement statement = connection.prepareStatement(query);
			//TODO Set attributes
			//statement.set...(...);
			int rowsUpdated = statement.executeUpdate();
			success = rowsUpdated > 0 ? 0x0 : 0x1;
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect to database", e);
		}
		return success;
	}

	@Override
	public int consultarHorario(String idCorreo, Date horario) {
		// TODO Auto-generated method stub
		return 0;
	}

}
