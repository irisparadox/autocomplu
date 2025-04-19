package configDB;

/* http://localhost:8082
Para conectarte usa:
JDBC URL: jdbc:h2:./data/autocomplu
Usuario: sa
Contraseña: password
*/

public class DatabaseConfig {
    public static final String DB_URL = "jdbc:h2:./data/autocomplu;MODE=MySQL";
    public static final String DB_USER = "sa";
    public static final String DB_PASSWORD = "password";
}