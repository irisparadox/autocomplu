package daoprofesores;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import configDB.DatabaseConfig;
import dominio.Profesor;

public class DAOProfesores implements IDAOProfesores {

    @Override
    public Profesor consultarProfesor(String idCorreo) {
        Profesor profesor = null;
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
            String query = "SELECT * FROM profesores WHERE idCorreo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idCorreo);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                profesor = new Profesor();
                profesor.setIdCorreo(rs.getString("idCorreo"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setApellidos(rs.getString("apellidos"));
                profesor.setContrasenha(rs.getString("contrasena"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesor;
    }

    @Override
    public List<Profesor> consultarProfesores(String nombre, String apellidos) {
        List<Profesor> profesores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
            String query = "SELECT * FROM profesores WHERE nombre LIKE ? AND apellidos LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + nombre + "%");
            statement.setString(2, "%" + apellidos + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setIdCorreo(rs.getString("idCorreo"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setApellidos(rs.getString("apellidos"));
                profesor.setContrasenha(rs.getString("contrasena"));
                profesores.add(profesor);
            }
        } catch (SQLException e) {
            profesores = null;
            e.printStackTrace();
        }
        return profesores;
    }

    @Override
    public int crearProfesor(Profesor profesor) {
        int success;
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
            String query = "INSERT INTO profesores VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, profesor.getIdCorreo());
            statement.setString(2, profesor.getNombre());
            statement.setString(3, profesor.getApellidos());
            statement.setString(4, profesor.getContrasenha());
            int rowsInserted = statement.executeUpdate();
            success = rowsInserted > 0 ? 0x0 : 0x1;
        } catch (SQLException e) {
            success = -0x1;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public int consultarHorario(String idCorreo, Date horario) {
        int ocupado = 0x1;
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
            String query = "SELECT COUNT(*) FROM clases WHERE idCorreoProfesor = ? AND horario = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idCorreo);
            statement.setDate(2, new java.sql.Date(horario.getTime()));
            ResultSet rs = statement.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                ocupado = 0x0;
            }
        } catch (SQLException e) {
            ocupado = -0x1;
            e.printStackTrace();
        }
        return ocupado;
    }

    @Override
    public int existeProfesor(String idCorreo) {
        int existe = 0x1;
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
            String query = "SELECT COUNT(*) FROM profesores WHERE idCorreo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idCorreo);
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
    public int editarProfesor(Profesor profesor) {
        int success;
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
            String query = "UPDATE profesores SET nombre = ?, apellidos = ?, contrasena = ? WHERE idCorreo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, profesor.getNombre());
            statement.setString(2, profesor.getApellidos());
            statement.setString(3, profesor.getContrasenha());
            statement.setString(4, profesor.getIdCorreo());
            int rowsUpdated = statement.executeUpdate();
            success = rowsUpdated > 0 ? 0x0 : 0x1;
        } catch (SQLException e) {
            success = -0x1;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public int borrarProfesor(String idCorreo) {
        int success;
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.DB_USER, DatabaseConfig.DB_PASSWORD)) {
            String query = "DELETE FROM profesores WHERE idCorreo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idCorreo);
            int rowsDeleted = statement.executeUpdate();
            success = rowsDeleted > 0 ? 0x0 : 0x1;
        } catch (SQLException e) {
            success = -0x1;
            e.printStackTrace();
        }
        return success;
    }
}