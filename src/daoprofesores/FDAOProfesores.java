package daoprofesores;

import java.util.Date;
import java.util.List;
import dominio.Profesor;

public class FDAOProfesores implements IFDAOProfesores {
    private IDAOProfesores daoProfesores = new DAOProfesores();

    @Override
    public Profesor consultarProfesor(String idCorreo) {
        return daoProfesores.consultarProfesor(idCorreo);
    }

    @Override
    public List<Profesor> consultarProfesores(String nombre, String apellidos) {
        return daoProfesores.consultarProfesores(nombre, apellidos);
    }

    @Override
    public int crearProfesor(Profesor nuevoProfesor) {
        return daoProfesores.crearProfesor(nuevoProfesor);
    }

    @Override
    public int borrarProfesor(String idCorreo) {
        return daoProfesores.borrarProfesor(idCorreo);
    }

    @Override
    public int existeProfesor(String idCorreo) {
        return daoProfesores.existeProfesor(idCorreo);
    }

    @Override
    public int editarProfesor(Profesor profesor) {
        return daoProfesores.editarProfesor(profesor);
    }

    @Override
    public int consultarHorario(String idCorreo, Date horario) {
        return daoProfesores.consultarHorario(idCorreo, horario);
    }
}