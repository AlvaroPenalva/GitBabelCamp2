package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="cuenta")
@Entity
public class Cuenta {

	@Id
	private int numeroCuenta;
	private double saldo;
	private String tipocuenta;
	
	@OneToMany(mappedBy = "cuenta")
	private List<Titular> titulares;
	
	public Cuenta(int numeroCuenta, double saldo, String tipocuenta) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipocuenta = tipocuenta;
	}
}
