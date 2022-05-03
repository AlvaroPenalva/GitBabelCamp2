package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Matricula;
import model.MatriculaPK;

public interface MatriculaDao extends JpaRepository<Matricula, MatriculaPK> {

	@Query("Select m from matricula m where m.cursos.fechaIni between ?1 and ?2")
	List<Matricula> findMatriculasFechas(Date fechaIni, Date fechaFin);
	
}
