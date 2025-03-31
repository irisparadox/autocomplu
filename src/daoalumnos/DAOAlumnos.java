package daoalumnos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominio.Alumno;

public class DAOAlumnos implements IDAOAlumnos {

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

	public List<Alumno> consultarAlumnos(String nombre, String apellidos) {
		ArrayList<Alumno> list;
		try {
			Connection connection = DriverManager.getConnection("TODO-URL", "root", "1234");
			String query = "SELECT * FROM alumnos WHERE nombre = ? AND apellidos = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, nombre);
			statement.setString(2, apellidos);
			ResultSet table = statement.executeQuery();
			
			list = new ArrayList<>();
			while(table.next()) {
				Alumno alumno = new Alumno();
				alumno.setIdCorreo(table.getString(1));
				alumno.setNombre(table.getString(2));
				alumno.setApellidos(table.getString(3));
				alumno.setTelefono(table.getString(4));
				alumno.setContrasenha(table.getString(5));
				alumno.setDNI(table.getString(6));
				alumno.setNumClasesPendientes(table.getInt(7));
				list.add(alumno);
			}
			
			table.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			list = null;
		}
		return list;
	}

	public int crearAlumno(Alumno nuevoAlumno) {
		int success;
		try {
			Connection connection = DriverManager.getConnection("TODO-URL", "root", "1234");
			String query = "INSERT INTO alumnos VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, nuevoAlumno.getIdCorreo());
			statement.setString(2, nuevoAlumno.getNombre());
			statement.setString(3, nuevoAlumno.getApellidos());
			statement.setString(4, nuevoAlumno.getTelefono());
			statement.setString(5, nuevoAlumno.getContrasenha());
			statement.setString(6, nuevoAlumno.getDNI());
			int rowsUpdated = statement.executeUpdate();
			success = rowsUpdated > 0 ? 0x0 : 0x1;
			statement.close();
			connection.close();
		} catch (SQLException e) {
			success = -0x1;
		}
		return success;
	}

	public int borrarAlumno(String idCorreo) {
		int success;
		try {
			Connection connection = DriverManager.getConnection("TODO-URL", "root", "1234");
			String query = "DELETE FROM alumnos WHERE idCorreo = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idCorreo);
			
			int rowsUpdated = statement.executeUpdate();
			success = rowsUpdated > 0 ? 0x0 : 0x1;
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			success = -0x1;
		}
		return success;
	}

	public int existeAlumno(String idCorreo) {
		int success;
		try {
			Connection connection = DriverManager.getConnection("TODO-URL", "root", "1234");
			String query = "SELECT COUNT(idCorreo) FROM alumnos WHERE idCorreo = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idCorreo);
			ResultSet table = statement.executeQuery();
			success = 0x1;
			if(table.next()) success = table.getInt(1) > 0 ? 0x0 : 0x1;
			table.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			success = -0x1;
		}
		return success;
	}

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

	public int consultarHorario(String idCorreo, Date horario) {
		int success;
		try {
			Connection connection = DriverManager.getConnection("TODO-URL", "root", "1234");
			String query = "SELECT horario FROM clases WHERE idCorreoAlumno = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idCorreo);
			ResultSet table = statement.executeQuery();
			success = 0x1;
			if(table.next()) {
				java.sql.Date sqlDate = table.getDate(1);
				
				if(horario.equals(sqlDate)) success = 0x0;
			}
			
			table.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			success = -0x1;
		}
		return success;
	}

}
