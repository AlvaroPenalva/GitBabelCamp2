package controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pagina;
import service.BuscadorService;

@Controller
public class BuscadorController {

	// Te inyecta la clase qu se ha instanciado con service
	@Autowired
	BuscadorService buscadorService;

	// Cuando llegue una llamada con la ruta buscador debera spring recoger este
	// metodo y los parametros
	@GetMapping(value = "/Buscador")
	public String buscar(@RequestParam("tema") String tema, HttpServletRequest request) {
		List<Pagina> paginas = buscadorService.buscar(tema);
		request.setAttribute("paginas", paginas);

		// Se devulve el nombre de la pagina a la que queremos transmitir la llamada
		return "listado";

	}

	@PostMapping(value = "/Grabar")
	public String grabar(@RequestParam("direccion") String direccion, @RequestParam("tematica") String tematica,
			@RequestParam("descripcion") String descripcion) {

		Pagina pagina = new Pagina(direccion, tematica, descripcion);
		buscadorService.alta(pagina);

		return "datos";

	}
}
