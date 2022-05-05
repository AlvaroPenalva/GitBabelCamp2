package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converters.ConversorEntityDto;
import dao.AlumnosDao;
import dao.CursosDao;
import dao.MatriculaDao;
import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
import model.Alumno;
import model.Curso;
import model.Matricula;
import model.MatriculaPK;

@Service
public class FormacionServiceImp implements FormacionService {

	@Autowired
	ConversorEntityDto conversor;
	AlumnosDao ad;
	CursosDao cd;
	MatriculaDao md;
	
	public FormacionServiceImp(@Autowired AlumnosDao ad, @Autowired CursosDao cd, @Autowired MatriculaDao md) {
		this.ad = ad;
		this.cd = cd;
		this.md = md;
	}
	
	@Override
	public AlumnoDto validarUsuario(String usuario, String password) {
		return conversor.alumnoToDto(ad.findByUsuarioAndPassword(usuario, password));
	}

	@Override
	public List<CursoDto> cursosdeAlumno(String usuario) {
		return cd.findByAlumno(usuario).stream().map(a -> conversor.cursoToDto(a)).collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> listaCursos() {
		return cd.findAll().stream().map(a -> conversor.cursoToDto(a)).collect(Collectors.toList());
	}

	@Override
	public List<AlumnoDto> alumnosPorCurso(String nombre) {
		return ad.findByCurso(nombre).stream().map(a -> conversor.alumnoToDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
		Optional<Alumno> auxA = buscarAlumno(usuario);
		Optional<Curso> auxC = buscarCurso(idCurso);
		if(auxC.isPresent() && auxC.isPresent()) {
			md.save(new Matricula(new MatriculaPK(idCurso,usuario),0,auxC.get(),auxA.get()));			
			return true;
		}else return false;
			
	}
	
	public Optional<Alumno> buscarAlumno(String usuario) {
		return ad.findById(usuario);
	}
	
	public Optional<Curso> buscarCurso(int idCurso) {
		return cd.findById(idCurso);
	}
	
	public List<AlumnoDto> listaAlumnos(){
		return ad.findAll().stream().map(a -> conversor.alumnoToDto(a)).collect(Collectors.toList());
	}

	@Override
	public List<CursoDto> cursosPosiblesMatricularAlumno(String usuario) {
		return cd.findNotMatriculado(usuario)
				.stream()
				.map(c->conversor.cursoToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public boolean altaAlumno(Alumno a) {
		Optional<Alumno> auxA = buscarAlumno(a.getUsuario());
		if(auxA.isEmpty()) {
			ad.save(a);
			return true;
		}	
		return false;
	}
	
	public boolean altaCurso(Curso c) {
		Optional<Curso> auxC = cd.findByName(c.getNombre());
		if(auxC.isEmpty()) {
			cd.save(c);
			return true;
		}	
		return false;
	}
	
	public List<MatriculaDto> consultarMatriculas(Date fechaIni, Date fechaFin) {
		return md.findMatriculasFechas(fechaIni, fechaFin)
				.stream()
				.map(a -> conversor.matriculaToDto(a))
				.collect(Collectors.toList());
	}

}
