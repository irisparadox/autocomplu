package daoalumnos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dominio.Alumno;
import dominio.Main;

public class DAOAlumnos implements IDAOAlumnos {

	public Alumno consultarAlumno(String idCorreo) {
		Alumno alumno = null;
		try {
			Connection connection = DriverManager.getConnection(Main.DB_URL, Main.DB_USR, Main.DB_PSW);
			String query = "SELECT * FROM vistaAlumnos WHERE idCorreo = ?";
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
			alumno.setIdCorreo("-1");
		}
		return alumno;
	}

	public List<Alumno> consultarAlumnos(String nombre, String apellidos) {
		ArrayList<Alumno> list;
		try {
			Connection connection = DriverManager.getConnection(Main.DB_URL, Main.DB_USR, Main.DB_PSW);
			String query = "SELECT * FROM vistaAlumnos WHERE nombre = ? AND apellidos = ?";
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
			Connection connection = DriverManager.getConnection(Main.DB_URL, Main.DB_USR, Main.DB_PSW);
			String query = "INSERT INTO usuarios VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, nuevoAlumno.getIdCorreo());
			statement.setString(2, nuevoAlumno.getNombre());
			statement.setString(3, nuevoAlumno.getApellidos());
			statement.setString(4, nuevoAlumno.getTelefono());
			statement.setString(5, nuevoAlumno.getContrasenha());
			statement.setString(6, nuevoAlumno.getDNI());
			int rowsUpdatedU = statement.executeUpdate();
			query = "INSERT INTO alumnos VALUES(?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, nuevoAlumno.getIdCorreo());
			statement.setInt(2, nuevoAlumno.getNumClasesPendientes());
			int rowsUpdatedA = statement.executeUpdate();
			success = rowsUpdatedU > 0 && rowsUpdatedA > 0 ? 0x0 : 0x1;
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
			Connection connection = DriverManager.getConnection(Main.DB_URL, Main.DB_USR, Main.DB_PSW);
			String query = "DELETE FROM usuarios WHERE idCorreo = ?";
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
			Connection connection = DriverManager.getConnection(Main.DB_URL, Main.DB_USR, Main.DB_PSW);
			String query = "SELECT COUNT(idCorreo) FROM vistaAlumnos WHERE idCorreo = ?";
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
			Connection connection = DriverManager.getConnection(Main.DB_URL, Main.DB_USR, Main.DB_PSW);
			String query = "UPDATE usuarios SET nombre = ?, apellidos = ?, DNI = ?, contrasenha = ?, telefono = ? WHERE idCorreo = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, alumno.getNombre());
			statement.setString(2, alumno.getApellidos());
			statement.setString(3, alumno.getDNI());
			statement.setString(4, alumno.getContrasenha());
			statement.setString(5, alumno.getTelefono());
			statement.setString(6, alumno.getIdCorreo());
			int rowsUpdatedU = statement.executeUpdate();
			query = "UPDATE alumnos SET numClasesPendientes = ? WHERE idCorreo = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, alumno.getNumClasesPendientes());
			statement.setString(2, alumno.getIdCorreo());
			int rowsUpdatedA = statement.executeUpdate();
			success = rowsUpdatedU > 0 && rowsUpdatedA > 0 ? 0x0 : 0x1;
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
			Connection connection = DriverManager.getConnection(Main.DB_URL, Main.DB_USR, Main.DB_PSW);
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
