package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Alumno;
import model.Curso;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class TestFormacionService {
	
	@Autowired
	FormacionService fs;
	
	@Test
	public void testValidarUsuario() {
		Alumno a = fs.validarUsuario("admin", "a");
		assertEquals("tomates", a.getNombre());
	}
	
	@Test
	public void testCursosDeAlumno() {
		List<Curso> cursos = fs.cursosdeAlumno("admin");
		assertEquals(4, cursos.size());
	}
	
	@Test
	public void testListaCursos() {
		List<Curso> cursos = fs.listaCursos();
		assertEquals(18, cursos.size());
	}
	
	@Test
	public void testAlumnosporCurso() {
		List<Alumno> alumnos = fs.alumnosPorCurso("python");
		assertEquals(4, alumnos.size());
	}

}
