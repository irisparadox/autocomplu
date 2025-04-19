package daoprofesores;

import java.util.Date;
import java.util.List;
import dominio.Profesor;

public interface IFDAOProfesores {
    public Profesor consultarProfesor(String idCorreo);
    public List<Profesor> consultarProfesores(String nombre, String apellidos);
    public int crearProfesor(Profesor nuevoProfesor);
    public int borrarProfesor(String idCorreo);
    public int existeProfesor(String idCorreo);
    public int editarProfesor(Profesor profesor);
    public int consultarHorario(String idCorreo, Date horario);
}