package daoclase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import configDB.DatabaseConfig; 
import dominio.Clase;
import dominio.Alumno;
import dominio.Profesor;

public class DAOClases implements IDAOClases {

	@Override
	public int crearClase(Clase clase) {
		int success;
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "INSERT INTO clases VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, clase.getIdClase());
			statement.setString(2, clase.getAlumno().getIdCorreo());
			statement.setString(3, clase.getProfesor().getIdCorreo());
			statement.setDate(4, new java.sql.Date(clase.getFecha().getTime()));
			
			int rowsInserted = statement.executeUpdate();
			success = rowsInserted > 0 ? 0x0 : 0x1;
		} catch (SQLException e) {
			success = -0x1;
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public int existeClase(String idClase) {
		int success;
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "SELECT COUNT(*) FROM clases WHERE idClase = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idClase);
			ResultSet rs = statement.executeQuery();
			success = 0x1;
			if (rs.next() && rs.getInt(1) > 0) success = 0x0;
		} catch (SQLException e) {
			success = -0x1;
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public Clase consultarClase(String idClase) {
		Clase clase = null;
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "SELECT * FROM clases WHERE idClase = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idClase);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				clase = new Clase();
				clase.setIdClase(String.valueOf(rs.getInt("idClase")));
				clase.setFecha(rs.getDate("horario"));

				Alumno alumno = new Alumno();
				alumno.setIdCorreo(rs.getString("idCorreoAlumno"));
				clase.setAlumno(alumno);

				Profesor profesor = new Profesor();
				profesor.setIdCorreo(rs.getString("idCorreoProfesor"));
				clase.setProfesor(profesor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clase;
	}

	@Override
	public List<Clase> consultarClasesAlumno(String idCorreo) {
		List<Clase> clases = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "SELECT * FROM clases WHERE idCorreoAlumno = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idCorreo);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Clase clase = new Clase();
				clase.setIdClase(String.valueOf(rs.getInt("idClase")));
				clase.setFecha(rs.getDate("horario"));

				Alumno alumno = new Alumno();
				alumno.setIdCorreo(rs.getString("idCorreoAlumno"));
				clase.setAlumno(alumno);

				Profesor profesor = new Profesor();
				profesor.setIdCorreo(rs.getString("idCorreoProfesor"));
				clase.setProfesor(profesor);
				clases.add(clase);
			}
		} catch (SQLException e) {
			clases = null;
			e.printStackTrace();
		}
		return clases;
	}

	@Override
	public List<Clase> consultarClasesProfesor(String idProfesor) {
		List<Clase> clases = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "SELECT * FROM clases WHERE idCorreoProfesor = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idProfesor);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Clase clase = new Clase();
				clase.setIdClase(String.valueOf(rs.getInt("idClase")));
				clase.setFecha(rs.getDate("horario"));

				Alumno alumno = new Alumno();
				alumno.setIdCorreo(rs.getString("idCorreoAlumno"));
				clase.setAlumno(alumno);

				Profesor profesor = new Profesor();
				profesor.setIdCorreo(rs.getString("idCorreoProfesor"));
				clase.setProfesor(profesor);
				clases.add(clase);
			}
		} catch (SQLException e) {
			clases = null;
			e.printStackTrace();
		}
		return clases;
	}

	@Override
	public int editarClase(Clase clase) {
		int success;
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "UPDATE clases SET idCorreoAlumno = ?, idCorreoProfesor = ?, horario = ? WHERE idClase = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, clase.getAlumno().getIdCorreo());
			statement.setString(2, clase.getProfesor().getIdCorreo());
			statement.setDate(3, new java.sql.Date(clase.getFecha().getTime()));
			statement.setInt(4, Integer.parseInt(clase.getIdClase()));
			int rowsUpdated = statement.executeUpdate();
			success = rowsUpdated > 0 ? 0x0 : 0x1;
		} catch (SQLException e) {
			success = -0x1;
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public int eliminarClase(String idClase) {
		int success;
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "DELETE FROM clases WHERE idClase = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, Integer.parseInt(idClase));
			int rowsDeleted = statement.executeUpdate();
			success = rowsDeleted > 0 ? 0x0 : 0x1;
		} catch (SQLException e) {
			success = -0x1;
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public int hayAlumno(String idClase) {
		int existe = 0x1;
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "SELECT idCorreoAlumno FROM clases WHERE idClase = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, Integer.parseInt(idClase));
			ResultSet rs = statement.executeQuery();
			if (rs.next() && rs.getString("idCorreoAlumno") != null) {
				existe = 0x0;
			}
		} catch (SQLException e) {
			existe = -0x1;
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public int hayProfesor(String idClase) {
		int existe = 0x1;
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "SELECT idCorreoProfesor FROM clases WHERE idClase = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, Integer.parseInt(idClase));
			ResultSet rs = statement.executeQuery();
			if (rs.next() && rs.getString("idCorreoProfesor") != null) {
				existe = 0x0;
			}
		} catch (SQLException e) {
			existe = -0x1;
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public int hayClaseAlumnoHora(String idAlumno, java.sql.Date fecha) {
		int existe = 0x1;
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "SELECT COUNT(*) FROM clases WHERE idCorreoAlumno = ? AND horario = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idAlumno);
			statement.setDate(2, fecha);
			ResultSet rs = statement.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				existe = 0x0;
			}
		} catch (SQLException e) {
			existe = -0x1;
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public int hayClaseProfesorHora(String idProfesor, java.sql.Date fecha) {
		int existe = 0x1;
		try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
			String query = "SELECT COUNT(*) FROM clases WHERE idCorreoProfesor = ? AND horario = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idProfesor);
			statement.setDate(2, fecha); 
			ResultSet rs = statement.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				existe = 0x0;
			}
		} catch (SQLException e) {
			existe = -0x1;
			e.printStackTrace();
		}
		return existe;
	}

}
