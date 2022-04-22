package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Service
public class AlumnServiceImp implements AlumnService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public void create(Alumno a) {	
		entityManager.persist(a);
	}

	@Transactional
	@Override
	public List<Alumno> read(String curso) {
		TypedQuery<Alumno> query = entityManager.createNamedQuery("Alumno.readByCurso", Alumno.class);
		query.setParameter("curso", curso);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public List<String> readCursos(){
		TypedQuery<String> query = entityManager.createNamedQuery("Alumno.readCursos", String.class);
		return query.getResultList();
	}

}
