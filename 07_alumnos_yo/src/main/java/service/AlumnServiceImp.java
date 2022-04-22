package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import model.Alumno;

@Service
public class AlumnServiceImp implements AlumnService {

	@Autowired
	JdbcTemplate template;

	@Override
	public void create(Alumno a) {
			String sql = "insert into alumnos(nombre, curso, nota) values(?,?,?)";
			template.update(sql, a.getNombre(), a.getCurso(), a.getNota());
	}

	@Override
	public List<Alumno> read(String curso) {
		String sql = "select * from alumnos where curso LIKE ?";
		List<Alumno> products = template.query(sql, (rs, f) -> new Alumno(rs.getInt("idAlumno"), rs.getString("nombre"),
				rs.getString("curso"), rs.getDouble("nota")), curso);
		return products;
	}
	
	@Override
	public boolean readByName(String name) {
		String sql = "select * from alumnos where nombre like ?";
		List<Alumno> products = template.query(sql, (rs, f) -> new Alumno(rs.getInt("idAlumno"), rs.getString("nombre"),
				rs.getString("curso"), rs.getDouble("nota")), name);
		return products.size() == 0;
	}
	
	@Override
	public List<String> readCursos(){
		String sql = "select distinct(curso) from alumnos";
		List<String> cursos = template.query(sql, (rs, f) -> new String(rs.getString("curso")));
		return cursos;
	}

}
