package saprofesores;

import dominio.Profesor;

import java.util.List;

public interface IFSAProfesores {
    public Profesor consultarProfesor(String idCorreo);
    public List<Profesor> consultarProfesores(String nombre, String apellidos);
    public int crearProfesor(Profesor nuevoProfesor);
    public int borrarProfesor(String idCorreo);
    public int existeProfesor(String idCorreo);
    public int editarProfesor(Profesor profesor);
}
