package service;

import java.util.Date;
import java.util.List;

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
import model.Alumno;
import model.Curso;

public interface FormacionService {

	AlumnoDto validarUsuario(String usuario, String password);
	List<CursoDto> cursosdeAlumno(String usuario);
	List<CursoDto> listaCursos();
	List<AlumnoDto> alumnosPorCurso(String nombre);
	boolean matricularAlumno(String usuario, int idCurso);
	List<AlumnoDto> listaAlumnos();
	List<CursoDto> cursosPosiblesMatricularAlumno(String usuario);
	boolean altaAlumno(Alumno a);
	boolean altaCurso(Curso c);
	List<MatriculaDto> consultarMatriculas(Date fechaIni, Date fechaFin);
}
