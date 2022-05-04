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
@Table(name="clientes")
@Entity
public class Cliente {
	
	@Id
	private String dni;
	private String nombre;
	private String direccion;
	private int telefono;
	
	@OneToMany(mappedBy = "cliente")
	private List<Titular> titulares;
	
	public Cliente(String dni, String nombre, String direccion, int telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
}
