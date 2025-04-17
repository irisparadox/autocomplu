package saprofesores;

import dominio.Profesor;

public class ControllerProfesores {
    private IFSAProfesores saProfesores = new FSAProfesores();

    public Profesor consultarProfesor(String idCorreo) {
        return saProfesores.consultarProfesor(idCorreo);
    }

    public int editarContrasenha(Profesor profesor, String contrasenhaNueva) {
        profesor.setContrasenha(contrasenhaNueva);
        return saProfesores.editarProfesor(profesor);
    }

    public int editarPerfilNoAdmin(Profesor profesor, String nuevoTlf, String nuevaContra) {
        profesor.setTelefono(nuevoTlf);
        profesor.setContrasenha(nuevaContra);
        return saProfesores.editarProfesor(profesor);
    }
}