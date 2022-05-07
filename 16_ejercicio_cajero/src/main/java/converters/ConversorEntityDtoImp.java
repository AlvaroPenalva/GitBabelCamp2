package converters;

import org.springframework.stereotype.Component;
import dto.MovimientoDto;
import model.Movimiento;

@Component
public class ConversorEntityDtoImp implements ConversorEntityDto{

	@Override
	public MovimientoDto movimientoToDto(Movimiento m) {
		return new MovimientoDto(m.getIdMovimiento(), m.getFecha(), m.getCantidad(), m.getOperacion());
	}

}
