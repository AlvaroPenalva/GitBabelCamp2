package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	Alumno validarUsuario(String usuario, String password);
	List<Curso> cursosdeAlumno(String usuario);
	List<Curso> listaCursos();
	List<Alumno> alumnosPorCurso(String nombre);
	boolean matricularAlumno(String usuario, int idCurso);
	List<Alumno> listaAlumnos();
	List<Curso> noMatriculado(String usuario);
	boolean altaAlumno(Alumno a);
	boolean altaCurso(Curso c);
	List<Curso> consultarMatriculas(Date fechaIni, Date fechaFin);
}
