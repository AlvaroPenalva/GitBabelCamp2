package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

import model.Alumno;
import service.AlumnService;

@CrossOrigin(origins = "*")
@Controller
public class AlumnController {

	@Autowired
	AlumnService alumnService;
	
	

    @PostMapping(value = "Alta")
    public String aniadirAlumno(@ModelAttribute Alumno alumno) {
            alumnService.create(alumno);
            return "inicio";
    }

	@GetMapping(value = "Buscador", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Alumno> buscar(@RequestParam("curso") String curso) {
       return alumnService.read(curso);
        
    }
	
	@GetMapping(value= "Cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> buscarCursos(){
		return alumnService.readCursos();
	}

}
