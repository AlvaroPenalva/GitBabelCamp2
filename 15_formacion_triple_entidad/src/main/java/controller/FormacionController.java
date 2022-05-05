package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.AlumnoDto;
import dto.CursoDto;
import dto.MatriculaDto;
import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin(origins = "*")
@Controller
public class FormacionController {

	@Autowired
	FormacionService fs;
	
	@PostMapping(value = "Login")
	public String login(@RequestParam String user, @RequestParam String pwd) {
		
		if(fs.validarUsuario(user, pwd) != null) return "menu";
		
		return "login";
	}
	
	@GetMapping(value= "Cursos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> getCursos() {
		return fs.listaCursos();
	}
	
	@GetMapping(value="Alumnos")
	public @ResponseBody List<AlumnoDto> getAlumnos() {
		return fs.listaAlumnos();
	}
	
	@GetMapping(value="BuscarAlumnos")
	public @ResponseBody List<AlumnoDto> getPorCurso(@RequestParam String nombre){
		return fs.alumnosPorCurso(nombre);
	}
	
	@GetMapping(value="BuscarCursos")
	public @ResponseBody List<CursoDto> getPorAlumno(@RequestParam String usuario){
		return fs.cursosdeAlumno(usuario);
	}
	
	@PostMapping(value="AltaAlumno")
	public String altaAlumno(@ModelAttribute Alumno a){
		if(fs.altaAlumno(a)) return "menu";
		return "alta";
	}
	
	@PostMapping(value="AltaCurso")
	public String altaCurso(@ModelAttribute Curso c) {
		if(fs.altaCurso(c)) return "menu";
		else return "alta";
	}
	
	@GetMapping(value="MatriculasPorFecha",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MatriculaDto> matriculas(@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni, 
												@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin){
		
			return fs.consultarMatriculas(fechaIni, fechaFin);
		
	}
	
	@GetMapping(value = "NoMatriculados", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CursoDto> matriculas(@RequestParam("usuario") String usuario) {
		return fs.cursosPosiblesMatricularAlumno(usuario);

	}
	
	@PostMapping(value="Matricular")
	public String matricular(@RequestParam("idCurso") int idCurso, @RequestParam("usuario") String usuario) {
		fs.matricularAlumno(usuario, idCurso);
		return "Login";
	}

	@GetMapping(value = "getAltaAlumno")
	public String getAltaAlumno() {
		return "altaAlumno";
	}

	@GetMapping(value = "getAltaCurso")
	public String getAltaCurso() {
		return "altaCurso";
	}
}
