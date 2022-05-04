package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="movimientos")
@Entity
public class Movimiento {

	@Id
	private int idMovimiento;
	private Date fecha;
	private double cantidad;
	private String operacion;
	
	@ManyToOne
	@JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta", insertable = false, updatable = false)
	private Cuenta cuenta;
	
	
}
