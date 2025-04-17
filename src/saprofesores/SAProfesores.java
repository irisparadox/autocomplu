package saprofesores;

import java.util.List;
import daoprofesores.*;
import dominio.Profesor;

public class SAProfesores implements ISAProfesores {

    private final IFDAOProfesores daoProfesores = new FDAOProfesores();

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
        if (daoProfesores.existeProfesor(nuevoProfesor.getIdCorreo()) == 0x1) {
            return 0x1;
        }
        return daoProfesores.crearProfesor(nuevoProfesor);
    }

    @Override
    public int borrarProfesor(String idCorreo) {
        if (daoProfesores.consultarProfesor(idCorreo) == null) {
            return 0x1;
        }
        return daoProfesores.borrarProfesor(idCorreo);
    }

    @Override
    public int existeProfesor(String idCorreo) {
        return daoProfesores.existeProfesor(idCorreo);
    }

    @Override
    public int editarProfesor(Profesor profesor) {
        if (daoProfesores.existeProfesor(profesor.getIdCorreo()) == 0x1) {
            return 0x1;
        }
        return daoProfesores.editarProfesor(profesor);
    }
}