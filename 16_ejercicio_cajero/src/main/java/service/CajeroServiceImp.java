package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ClienteDao;
import dao.CuentaDao;
import dao.MovimientoDao;
import dt.MovimientoDt;
import model.Cuenta;
import model.Movimiento;

public class CajeroServiceImp implements CajeroService{
	
	
	ClienteDao clienteD;
	
	CuentaDao cuentaD;
	
	MovimientoDao movimientoD;
	
	public CajeroServiceImp(@Autowired ClienteDao clienteD, @Autowired CuentaDao cuentaD, @Autowired MovimientoDao movimientoD) {
		this.clienteD = clienteD;
		this.cuentaD = cuentaD;
		this.movimientoD = movimientoD;
	}
	
	@Override
	public boolean validarCuenta(int idCuenta) {
		Optional<Cuenta> cuentaOptional = cuentaD.findById(idCuenta);
		if(cuentaOptional.isPresent())
			return true;
		return false;
	}

	@Override
	public boolean transferir(double cantidad, int idCuentaOrigen, int idCuentaDestino) {
		Cuenta cuentaOrigen = findCuentaById(idCuentaOrigen);
		Cuenta cuentaDestino = findCuentaById(idCuentaDestino);
		if(cuentaOrigen != null && cuentaDestino != null) {
			cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidad);
			cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);
			cuentaD.save(cuentaOrigen);
			cuentaD.save(cuentaDestino);
			return true;
		}
		return false;
	}

	@Override
	public boolean ingreso(int idCuenta, double cantidad) {
		Cuenta cuenta = findCuentaById(idCuenta);
		if(cuenta != null) {
			cuenta.setSaldo(cuenta.getSaldo() + cantidad);
			cuentaD.save(cuenta);
			return true;
		}
		return false;
	}

	@Override
	public boolean extraer(int idCuenta, double cantidad) {
		Cuenta cuenta = findCuentaById(idCuenta);
		if(cuenta != null) {
			cuenta.setSaldo(cuenta.getSaldo() - cantidad);
			cuentaD.save(cuenta);
			return true;
		}
		return false;
	}

	@Override
	public List<MovimientoDt> getMovimientosCuentaentreFechas(int idCuenta, Date fechaIni, Date fechaFin) {
		
		return null;
   	}
	
	public Cuenta findCuentaById(int idCuenta) {
		Optional<Cuenta> cuentaOptional = cuentaD.findById(idCuenta);
		if(cuentaOptional.isPresent())
			return cuentaOptional.get();
		return null;
	}

}
