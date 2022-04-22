package service;

import java.util.List;

import model.Producto;

public interface productService {

	public void create(Producto producto);
	public void delete(String nombre);
	public void update(String nombre, double precio);
	public List<Producto> read(String nombre);
	
}
