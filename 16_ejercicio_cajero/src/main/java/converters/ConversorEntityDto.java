package converters;

import dto.MovimientoDto;
import model.Movimiento;

public interface ConversorEntityDto {

	MovimientoDto movimientoToDto(Movimiento m);
}
