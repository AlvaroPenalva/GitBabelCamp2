package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import model.Producto;

@Service
public class ProductServiceImp implements productService {
	
	static ArrayList<Producto> productos = new ArrayList<>(List.of(new Producto("vino","alimentación",8.4,25),
            new Producto("leche","alimentación",1.2,70),
            new Producto("cable usb","informática",5.6,30),
            new Producto("arroz","alimentación",3.1,16),
            new Producto("silla","hogar",30.6,10),
            new Producto("monitor","informática",125.0,5),
            new Producto("escritorio","hogar",230,4)
            ));

	public ProductServiceImp() {
	}
	
	@Override
	public void create(Producto producto) {
		
		productos.add(producto);

	}

	@Override
	public void delete(String nombre) {

		for(Producto p: productos) if(p.getNombre().equals(nombre)) {
			productos.remove(p);
			break;
		}
	}

	@Override
	public void update(String nombre, double precio) {
		
		for(Producto p: productos) if(p.getNombre().equals(nombre)) {
			p.setPrecio(precio);
		}

	}

	@Override
	public List<Producto> read(String nombre) {
		return productos
				.stream()
				.filter(p->p.getNombre().equals(nombre))
				.collect(Collectors.toList());
	}

}
