package dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovimientoDto {

	private int idMovimiento;
	private Date fecha;
	private double cantidad;
	private String operacion;
}
