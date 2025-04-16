package configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import org.h2.tools.Server;

public class DatabaseInitializer {
    private static final String DB_URL = "jdbc:h2:./data/autocomplu;MODE=MySQL";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "password";

    public static void inicializarBaseDeDatos() {
        try {
            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
            System.out.println("Consola H2 disponible en http://localhost:8082");

            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE IF NOT EXISTS usuarios ("
                    + "idCorreo VARCHAR(100) PRIMARY KEY,"
                    + "nombre VARCHAR(100) NOT NULL,"
                    + "apellidos VARCHAR(100) NOT NULL,"
                    + "telefono VARCHAR(12) NOT NULL,"
                    + "contrasenha VARCHAR(100) NOT NULL,"
                    + "dni VARCHAR(9) NOT NULL"
                    + ")");

            stmt.execute("CREATE TABLE IF NOT EXISTS alumnos ("
                    + "idCorreo VARCHAR(100) NOT NULL,"
                    + "numClasesPendientes INT NOT NULL,"
                    + "PRIMARY KEY (idCorreo),"
                    + "FOREIGN KEY (idCorreo) REFERENCES usuarios(idCorreo) ON DELETE CASCADE"
                    + ")");

            stmt.execute("CREATE TABLE IF NOT EXISTS profesores ("
                    + "idCorreo VARCHAR(100) NOT NULL,"
                    + "PRIMARY KEY (idCorreo),"
                    + "FOREIGN KEY (idCorreo) REFERENCES usuarios(idCorreo) ON DELETE CASCADE"
                    + ")");

            stmt.execute("CREATE TABLE IF NOT EXISTS clases ("
                    + "idClase INT AUTO_INCREMENT PRIMARY KEY,"
                    + "idCorreoAlumno VARCHAR(100),"
                    + "horario DATE,"
                    + "FOREIGN KEY (idCorreoAlumno) REFERENCES alumnos(idCorreo)"
                    + ")");

            stmt.execute("CREATE VIEW IF NOT EXISTS vistaAlumnos AS "
                    + "SELECT u.idCorreo, u.nombre, u.apellidos, u.telefono, u.contrasenha, u.dni, "
                    + "a.numClasesPendientes "
                    + "FROM usuarios u "
                    + "INNER JOIN alumnos a ON u.idCorreo = a.idCorreo");

            stmt.execute("MERGE INTO usuarios KEY(idCorreo) VALUES "
                    + "('admin@admin.com', 'Admin', 'Admin', '999999999999', 'admin', '99999999Z'),"
                    + "('alumno@alumno.com', 'alumno', 'alumno', '000000000000', 'alumno', '12345678A')");

            stmt.execute("MERGE INTO profesores KEY(idCorreo) VALUES ('admin@admin.com')");
            stmt.execute("MERGE INTO alumnos KEY(idCorreo) VALUES ('alumno@alumno.com', 0)");

            System.out.println("Base de datos inicializada correctamente");
            conn.close();

        } catch (Exception e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}