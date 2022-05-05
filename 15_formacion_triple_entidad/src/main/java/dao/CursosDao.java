package dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {

	@Query("select c from Curso c join c.matriculas m where m.alumno.usuario=?1")
	List<Curso> findByAlumno(String usuario);
	@Query("select c from Curso c  where c.nombre LIKE ?1")
	Optional<Curso> findByName(String nombre);
	@Query("Select c From Curso c Where c Not In (Select c From Curso c join c.matriculas m Where m.alumno.usuario=?1)")
	List<Curso> findNotMatriculado(String usuario);
	@Query("Select c from Curso c where c.fechaInicio between ?1 and ?2")
	List<Curso> findBetweenDates(Date d1, Date d2);
}
