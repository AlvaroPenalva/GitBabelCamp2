package test;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;
import service.FormacionService;
import service.FormacionServiceImp;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class TestFormacionMock {
	@Mock
	AlumnosDao ad;
	
	@Mock
	CursosDao cd;
	
	List<Alumno> alumnos;
	List<Curso> cursos;
	
	FormacionService service;
	
	@BeforeEach
	void init() {
		
		cursos=List.of(new Curso(1,"curso1",100,10,null),
				new Curso(2,"curso2",200,20,null),
				new Curso(3,"curso3",300,30,null));
		alumnos=List.of(new Alumno("user1","pwd1","n1","e1",10,new ArrayList<>(List.of(cursos.get(0),cursos.get(1)))),
				new Alumno("user2","pwd2","n2","e2",20,new ArrayList<>(List.of(cursos.get(0)))),
				new Alumno("user3","pwd3","n3","e3",30,new ArrayList<>(List.of(cursos.get(2)))),
				new Alumno("user4","pwd4","n4","e4",10,new ArrayList<>(List.of(cursos.get(0),cursos.get(2)))));
		lenient().when(ad.findByUsuarioAndPassword("user1", "pwd1")).thenReturn(alumnos.get(0));
		lenient().when(ad.findByUsuarioAndPassword("user3", "pwd3")).thenReturn(alumnos.get(2));
		lenient().when(ad.findByUsuarioAndPassword("user7", "aaa")).thenReturn(null);
		lenient().when(ad.findByCurso("curso1")).thenReturn(List.of(alumnos.get(0),alumnos.get(1),alumnos.get(3)));
		lenient().when(ad.findById("user3")).thenReturn(Optional.of(alumnos.get(2)));
		lenient().doNothing().when(ad).save(alumnos.get(2)); //para que no haga nada al llamar a update
		lenient().when(cd.findById(2)).thenReturn(Optional.of(cursos.get(1)));
		lenient().when(cd.findAll()).thenReturn(cursos);
		lenient().when(cd.findByAlumno("user3")).thenReturn(alumnos.get(2).getCursos());
		
		service=new FormacionServiceImp(ad,cd);
	}
	
	@Test
	void testBuscarAlumno() {
		assertEquals("e1",service.validarUsuario("user1", "pwd1").getEmail());
		assertNull(service.validarUsuario("user7", "aaa"));
	}
	
	@Test
	void testCursosAlumno() {
		assertEquals(1, service.cursosdeAlumno("user3").size());
		
	}
	@Test
	void testAlumnosCurso() {
		assertEquals(3, service.alumnosPorCurso("curso1").size());
	}
	
	@Test
	void testCursos() {
		assertEquals(3, service.listaCursos().size());
	}
	
	@Test
	void testMatricular() {
		assertTrue(service.matriculaAlumno("user3", 2));
		//tras matricular al alumno en un nuevo curso, obtenemos el alumno
		//y comprobamos que tiene un curso más al creado inicialmente
		assertEquals(2,service.validarUsuario("user3", "pwd3").getCursos().size());
	}
}
