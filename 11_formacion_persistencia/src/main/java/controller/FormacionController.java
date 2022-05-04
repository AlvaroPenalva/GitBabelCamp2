package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	//He cambiado la ruta para que coincida con el routing de las vistas
	@PostMapping(value = "Login")
	public String login(@RequestParam("user") String user, 
			@RequestParam("pwd") String pwd, 
			HttpSession sesion, 
			HttpServletRequest request) {
		Alumno alumno=fs.validarUsuario(user, pwd);
		if(alumno!=null) {
			sesion.setAttribute("alumno", alumno);
			return "menu";
		}else {
			request.setAttribute("mensaje", "Usuario y/o contrase�a incorrectos");
			return "login";
		}
	
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
