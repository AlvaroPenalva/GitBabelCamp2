package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.MovimientoDto;
import service.CajeroService;

@CrossOrigin(origins = "*")
@Controller
public class CajeroController {

	@Autowired
	CajeroService cs;

	@PostMapping(value = "Login")
	public String validarCuenta(@RequestParam("idCuenta") int idCuenta, HttpSession sesion,
			HttpServletRequest request) {
		if (cs.validarCuenta(idCuenta)) {
			sesion.setAttribute("cuenta", idCuenta);
			return "menu";
		}
		return "login";

	}

	@PostMapping(value = "Ingresar")
	public String ingresarDinero(@RequestParam("dinero") double dinero, HttpSession sesion) {
		int idCuenta = (Integer) sesion.getAttribute("cuenta");
		if (cs.ingreso(idCuenta, dinero))
			return "menu";
		return "ingresar";
	}

	@PostMapping(value = "Retirar")
	public String retirarDinero(@RequestParam("dinero") double dinero, HttpSession sesion) {
		int idCuenta = (Integer) sesion.getAttribute("cuenta");
		if (cs.extraer(idCuenta, dinero))
			return "menu";
		return "retirar";
	}

	@PostMapping(value = "Transferir")
	public String transferencia(@RequestParam("dinero") double dinero, HttpSession sesion, @RequestParam("idCuentaDestino") int idCuentaDestino) {
		int idCuentaOrigen = (Integer) sesion.getAttribute("cuenta");
		if (cs.transferir(dinero, idCuentaOrigen, idCuentaDestino))
			return "menu";
		return "transferencia";
	}

	@GetMapping(value = "MovimientosPorFechas")
	public @ResponseBody List<MovimientoDto> MovimientosPorFechas(
			@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin, HttpSession sesion) {
		int idCuenta = (Integer) sesion.getAttribute("cuenta");
		return cs.getMovimientosCuentaentreFechas(idCuenta, fechaIni, fechaFin);
	}
	
	@GetMapping(value="GetSaldoCuenta")
	public @ResponseBody double leerSaldoCuenta(HttpSession sesion) {
		int idCuenta = (Integer) sesion.getAttribute("cuenta");
		return cs.getSaldoCuenta(idCuenta);
	}
}
