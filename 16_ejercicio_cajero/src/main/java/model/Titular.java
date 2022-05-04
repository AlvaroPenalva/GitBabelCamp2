package model;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name="titulares")
@Entity
public class Titular {
	
	@EmbeddedId
	private TitularPK pk;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", referencedColumnName = "dni", insertable = false, updatable = false)
	Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idCuenta", referencedColumnName = "numeroCUenta", insertable = false, updatable = false)
	Cuenta cuenta;
}
