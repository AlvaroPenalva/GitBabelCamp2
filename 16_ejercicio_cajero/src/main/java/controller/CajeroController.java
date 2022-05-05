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

import dt.MovimientoDt;
import service.CajeroService;

@CrossOrigin(origins = "*")
@Controller
public class CajeroController {

	@Autowired
	CajeroService cs;

	@PostMapping(value = "LoginCuenta")
	public String validarCuenta(@RequestParam("idCuenta") int idCuenta, HttpSession sesion,
			HttpServletRequest request) {

		if (cs.validarCuenta(idCuenta))
			return "menu";
		return "login";

	}

	@PostMapping(value = "Ingresar")
	public String ingresarDinero(@RequestParam("idCuenta") int idCuenta, @RequestParam("dinero") double dinero) {
		if (cs.ingreso(idCuenta, dinero))
			return "menu";
		return "ingresar";
	}

	@PostMapping(value = "Ingresar")
	public String retirarDinero(@RequestParam("idCuenta") int idCuenta, @RequestParam("dinero") double dinero) {
		if (cs.extraer(idCuenta, dinero))
			return "menu";
		return "ingresar";
	}

	@GetMapping(value = "MovimientosPorFechas")
	public @ResponseBody List<MovimientoDt> MovimientosPorFechas(@RequestParam("idCuenta") int idCuenta,
			@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

		return cs.getMovimientosCuentaentreFechas(idCuenta, fechaIni, fechaFin);
	}
}
