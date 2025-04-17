package saprofesores;

import java.util.List;
import dominio.Profesor;

public class FSAProfesores implements IFSAProfesores {

    private ISAProfesores saProfesores = new SAProfesores();

    @Override
    public Profesor consultarProfesor(String idCorreo) {
        return saProfesores.consultarProfesor(idCorreo);
    }

    @Override
    public List<Profesor> consultarProfesores(String nombre, String apellidos) {
        return saProfesores.consultarProfesores(nombre, apellidos);
    }

    @Override
    public int crearProfesor(Profesor nuevoProfesor) {
        return saProfesores.crearProfesor(nuevoProfesor);
    }

    @Override
    public int borrarProfesor(String idCorreo) {
        return saProfesores.borrarProfesor(idCorreo);
    }

    @Override
    public int existeProfesor(String idCorreo) {
        return saProfesores.existeProfesor(idCorreo);
    }

    @Override
    public int editarProfesor(Profesor profesor) {
        return saProfesores.editarProfesor(profesor);
    }
}