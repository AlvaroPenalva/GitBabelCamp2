package service;

import java.util.Date;
import java.util.List;

import dto.MovimientoDto;
import model.Cuenta;

public interface CajeroService {

	boolean validarCuenta(int idCuenta);
	boolean transferir(double cantidad, int idCuentaOrigen, int idCuentaDestino);
	boolean ingreso(int idCuenta, double cantidad);
	boolean extraer(int idCuenta, double cantidad);
	List<MovimientoDto> getMovimientosCuentaentreFechas(int idCuenta,Date fechaIni, Date fechaFin);
	double getSaldoCuenta(int idCuenta);
}
