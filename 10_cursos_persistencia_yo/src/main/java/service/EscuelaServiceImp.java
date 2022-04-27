package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;

@Service
public class EscuelaServiceImp implements EscuelaService {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Alumno> alumnosCurso(String nombre) {

		String jpql = "select c.alumnos from Curso c where c.denominacion=?1";
		TypedQuery<Alumno> query = em.createQuery(jpql, Alumno.class);	
		query.setParameter(1, nombre);
		return query.getResultList();
	}

	@Override
	public List<Alumno> alumnosCursoDuracion(int duracionMaxima) {
		/*String jpql = "select  from Alumno where ";
		TypedQuery<Alumno> query = em.createQuery(jpql, Alumno.class);	
		query.setParameter(1, duracionMaxima);
		return null;/*/
		return null;
	}

	@Override
	public Curso cursoMatriculadoAlumno(String dni) {
		String jpql= "select c from Curso c join c.alumnos a where a.dni=?1";
		TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
		query.setParameter(1, dni);
		return query.getSingleResult();
	}

	@Override
	public List<Curso> alumnosSenior(int edad) {
		String jpql = "select distinct(c) from Curso c join c.alumnos a where a.edad >= ?1";
		TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
		query.setParameter(1, edad);
		return query.getResultList();
	}

	@Override
	public double edadMediaCurso(String nombreCurso) {
		String jpql = "select avg(a.edad) from Curso c join c.alumnos a where c.denominacion = ?1";
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter(1, nombreCurso);
		return query.getSingleResult();
	}

	@Override
	public double precioCurso(String email) {
		String jpql = "select c.precio from Alumno a join a.curso where email = ?1";
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter(1, email);
		return 0;
	}

}
