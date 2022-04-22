package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import model.Producto;
@Service
public class ProductServiceImp implements productService {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public void create(Producto p) {
		String sql ="insert into productos(nombre,seccion,precio,stock) values(?,?,?,?)";
        template.update(sql, p.getNombre(),p.getSeccion(),p.getPrecio(),p.getStock());
	}

	@Override
	public void delete(String nombre) {
		String sql ="delete from productos where nombre = ?";
        template.update(sql, nombre);
	}

	@Override
	public void update(Producto p) {
		String sql ="update productos set precio = ? where nombre = ?";
        template.update(sql, p.getPrecio(),p.getNombre());
	}

	@Override
	public List<Producto> read(String seccion) {
		String sql ="select * from productos where seccion LIKE ?";
		List<Producto> products = template.query(sql, (rs,f) ->new Producto(rs.getInt("idProducto"),
				rs.getString("nombre"),
				rs.getString("seccion"),
				rs.getDouble("precio"),
				rs.getInt("stock")), seccion);	
		return products;
	}

	@Override
	public Producto buscarProducto(int idProducto) {
		String sql ="select * from productos where idProducto = ?";
		List<Producto> products = template.query(sql, (rs,f) ->new Producto(rs.getInt("idProducto"),
				rs.getString("nombre"),
				rs.getString("seccion"),
				rs.getDouble("precio"),
				rs.getInt("stock")), idProducto);	
		return products.size()>0?products.get(0):null;
	}


}
