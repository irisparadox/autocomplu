package dominio;

public class Profesor extends Usuario {
	public Profesor() { super(); }
	public Profesor(String idCorreo, String nombre, String apellidos, String telefono, String contrasenha, String dni) {
		super(idCorreo, nombre, apellidos, telefono, contrasenha, dni);
	}
}
