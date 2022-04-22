package service;

import java.util.List;

import model.Alumno;

public interface AlumnService {

	public void create(Alumno a);
	public List<Alumno> read(String curso);
	public List<String> readCursos();
}
