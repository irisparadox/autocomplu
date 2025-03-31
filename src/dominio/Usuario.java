package dominio;

public class Usuario {
	private String idCorreo;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String contrasenha;
	private String dni;
	private boolean admin;
	
	public Usuario() { super(); }
	public Usuario(String idCorreo, String nombre, String apellidos, String telefono, String contrasenha, String dni,
			boolean admin) {
		this.idCorreo = idCorreo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.contrasenha = contrasenha;
		this.dni = dni;
		this.admin = admin;
	}
	public String getIdCorreo() {
		return idCorreo;
	}
	public void setIdCorreo(String idCorreo) {
		this.idCorreo = idCorreo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getContrasenha() {
		return contrasenha;
	}
	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}
	public String getDNI() {
		return this.dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
