package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		if(fs.validarUsuario(user, pwd) != null) return "inicio";
		
		return "login";
	}
	
	@GetMapping(value= "Cursos",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> getCursos() {
		return fs.listaCursos();
	}
	
	@GetMapping(value="Alumnos")
	public @ResponseBody List<Alumno> getAlumnos() {
		return fs.listaAlumnos();
	}
	
	@GetMapping(value="BuscarAlumnos")
	public @ResponseBody List<Alumno> getPorCurso(@RequestParam String nombre){
		return fs.alumnosPorCurso(nombre);
	}
	
	@GetMapping(value="BuscarCursos")
	public @ResponseBody List<Curso> getPorAlumno(@RequestParam String usuario){
		return fs.cursosdeAlumno(usuario);
	}
	
}
