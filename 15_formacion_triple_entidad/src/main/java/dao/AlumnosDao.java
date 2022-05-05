package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno, String>{

	@Query("select a from Alumno a where a.usuario=?1 AND a.password =?2")
	Alumno findByUsuarioAndPassword(String usuario, String password);
	@Query("select a from Alumno a join a.matriculas m where m.curso.nombre =?1")
	List<Alumno> findByCurso(String nombreCurso);
}
