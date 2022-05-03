package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImp implements FormacionService {

	AlumnosDao ad;
	
	CursosDao cd;
	
	public FormacionServiceImp(@Autowired AlumnosDao ad, @Autowired CursosDao cd) {
		this.ad = ad;
		this.cd = cd;
	}
	
	@Override
	public Alumno validarUsuario(String usuario, String password) {
		return ad.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public List<Curso> cursosdeAlumno(String usuario) {
		return cd.findByAlumno(usuario);
	}

	@Override
	public List<Curso> listaCursos() {
		return cd.findAll();
	}

	@Override
	public List<Alumno> alumnosPorCurso(String nombre) {
		return ad.findByCurso(nombre);
	}

	@Override
	public boolean matriculaAlumno(String usuario, int idCurso) {
		Alumno auxA = buscarAlumno(usuario);
		Curso auxC = buscarCurso(idCurso);
		if(auxC  != null && auxC != null) {
			auxA.getCursos().add(auxC);
			ad.update(auxA);
			return true;
		}else return false;
			
	}
	
	public Alumno buscarAlumno(String usuario) {
		return ad.findById(usuario);
	}
	
	public Curso buscarCurso(int idCurso) {
		return cd.findById(idCurso);
	}
	
	public List<Alumno> listaAlumnos(){
		return ad.findAll();
	}

}
