package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	Alumno validarUsuario(String usuario, String password);
	List<Curso> cursosdeAlumno(String usuario);
	List<Curso> listaCursos();
	List<Alumno> alumnosPorCurso(String nombre);
	boolean matriculaAlumno(String usuario, int idCurso);
	List<Alumno> listaAlumnos();
}
