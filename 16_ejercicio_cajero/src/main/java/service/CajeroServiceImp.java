package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.ClienteDao;
import dao.CuentaDao;
import dao.MovimientoDao;
import dto.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

@Service
public class CajeroServiceImp implements CajeroService {

	@Autowired
	ConversorEntityDto conversor;
	ClienteDao clienteD;

	CuentaDao cuentaD;

	MovimientoDao movimientoD;

	public CajeroServiceImp(@Autowired ClienteDao clienteD, @Autowired CuentaDao cuentaD,
			@Autowired MovimientoDao movimientoD) {
		this.clienteD = clienteD;
		this.cuentaD = cuentaD;
		this.movimientoD = movimientoD;
	}

	@Override
	public boolean validarCuenta(int idCuenta) {
		Optional<Cuenta> cuentaOptional = cuentaD.findById(idCuenta);
		if (cuentaOptional.isPresent())
			return true;
		return false;
	}

	@Override
	public boolean transferir(double cantidad, int idCuentaOrigen, int idCuentaDestino) {
		Cuenta cuentaOrigen = findCuentaById(idCuentaOrigen);
		Cuenta cuentaDestino = findCuentaById(idCuentaDestino);
		if (cuentaOrigen != null && cuentaDestino != null) {
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
		if (cuenta != null) {
			cuenta.setSaldo(cuenta.getSaldo() + cantidad);
			cuentaD.save(cuenta);
			return true;
		}
		return false;
	}

	@Override
	public boolean extraer(int idCuenta, double cantidad) {
		Cuenta cuenta = findCuentaById(idCuenta);
		if (cuenta != null) {
			cuenta.setSaldo(cuenta.getSaldo() - cantidad);
			cuentaD.save(cuenta);
			return true;
		}
		return false;
	}

	@Override
	public List<MovimientoDto> getMovimientosCuentaentreFechas(int idCuenta, Date fechaIni, Date fechaFin) {
		return movimientoD.findBetweenDates(fechaIni, fechaFin).stream().map(m -> conversor.movimientoToDto(m))
				.collect(Collectors.toList());
	}

	public Cuenta findCuentaById(int idCuenta) {
		Optional<Cuenta> cuentaOptional = cuentaD.findById(idCuenta);
		if (cuentaOptional.isPresent())
			return cuentaOptional.get();
		return null;
	}
	
	public double getSaldoCuenta(int idCuenta) {
		Cuenta cuenta = findCuentaById(idCuenta);
		if(cuenta != null) return cuenta.getSaldo();
		return 0;
	}

}
