package DAOAlumnos;

import java.sql.*;
import java.util.Date;
import java.util.List;

import Dominio.Alumno;

public class DAOAlumnos implements IDAOAlumnos {

	@Override
	public Alumno consultarAlumno(String idCorreo) {
		Alumno alumno = null;
		try {
			Connection connection = DriverManager.getConnection("TODO-URL", "root", "1234");
			String query = "SELECT * FROM alumnos WHERE idCorreo = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idCorreo);
			ResultSet table = statement.executeQuery();
			
			if(table.next()) {
				alumno = new Alumno();
				alumno.setIdCorreo(idCorreo);
				alumno.setNombre(table.getString(2));
				alumno.setApellidos(table.getString(3));
				alumno.setTelefono(table.getString(4));
				alumno.setContrasenha(table.getString(5));
				alumno.setDNI(table.getString(6));
				alumno.setNumClasesPendientes(table.getInt(7));
			}
			
			table.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			alumno = new Alumno();
			alumno.setIdCorreo("-2");
		}
		return alumno;
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
		int success;
		try {
			Connection connection = DriverManager.getConnection("TODO-URL", "root", "1234");
			String query = "SELECT COUNT(idCorreo) FROM alumnos WHERE idCorreo = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idCorreo);
			ResultSet table = statement.executeQuery();
			if(table.next()) success = table.getInt(1) > 0 ? 0x0 : 0x1;
			table.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			success = -0x1;
		}
		return success;
	}

	@Override
	public int editarAlumno(Alumno alumno) {
		int success;
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
			success = -0x1;
		}
		return success;
	}

	@Override
	public int consultarHorario(String idCorreo, Date horario) {
		// TODO Auto-generated method stub
		return 0;
	}

}
