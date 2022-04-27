package test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import config.ServiceConfig;
import model.Alumno;
import model.Curso;
import service.EscuelaService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class TestEscuelaService {
	@Autowired
	EscuelaService es;
	
	@Test
	public void testAlumnosCurso() {
		List<Alumno> la = es.alumnosCurso("java");
		assertEquals(4, la.size());
	}
	
	@Test
	public void testCursoMatriculadoAlumno() {
		Curso curso = es.cursoMatriculadoAlumno("1111A");
		assertEquals(2, curso.getIdCurso());
	}
}
