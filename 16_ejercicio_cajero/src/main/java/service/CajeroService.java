package service;

import java.util.Date;
import java.util.List;

import dt.MovimientoDt;
import model.Cuenta;

public interface CajeroService {

	boolean validarCuenta(int idCuenta);
	boolean transferir(double cantidad, int idCuentaOrigen, int idCuentaDestino);
	boolean ingreso(int idCuenta, double cantidad);
	boolean extraer(int idCuenta, double cantidad);
	List<MovimientoDt> getMovimientosCuentaentreFechas(int idCuenta,Date fechaIni, Date fechaFin);
}
