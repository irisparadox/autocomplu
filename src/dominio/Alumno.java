package dominio;

public class Alumno extends Usuario {
	private int numClasesPendientes;

	public Alumno() {}
	public Alumno(String idCorreo, String nombre, String apellidos, String telefono, String contrasenha, String dni,
			int numClasesPendientes) {
		super(idCorreo, nombre, apellidos, telefono, contrasenha, dni, false);
		this.numClasesPendientes = numClasesPendientes;
	}
	public int getNumClasesPendientes() {
		return numClasesPendientes;
	}

	public void setNumClasesPendientes(int numClasesPendientes) {
		this.numClasesPendientes = numClasesPendientes;
	}
}
