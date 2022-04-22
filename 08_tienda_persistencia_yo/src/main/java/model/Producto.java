package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="productos")
@NamedQuery(name = "Producto.readBySection", query = "select p from Producto p where p.seccion = :seccion")
@NamedQuery(name = "Producto.readByName", query = "select p from Producto p where p.nombre = :nombre")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String nombre;
	private String seccion;
	private double precio;
	private int stock;
}
