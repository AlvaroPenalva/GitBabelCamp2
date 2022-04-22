package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;
@Service
public class ProductServiceImp implements productService {

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Transactional
	@Override
	public void create(Producto producto) {
		entityManager.persist(producto);
	}

	@Transactional
	@Override
	public void delete(String nombre) {
		Producto p = searchByName(nombre);
		entityManager.remove(p);
	}

	@Transactional
	@Override
	public void update(Producto p) {
		entityManager.merge(p);
	}

	@Override
	@Transactional
	public List<Producto> read(String seccion) {
		TypedQuery<Producto> query = entityManager.createNamedQuery("Producto.readBySection", Producto.class);
		query.setParameter("seccion", seccion);
		return query.getResultList();
	}

	@Transactional
	@Override
	public Producto buscarProducto(int idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}
	
	private Producto searchByName(String nombre) {
		TypedQuery<Producto> query = entityManager.createNamedQuery("Producto.readByName", Producto.class);
		query.setParameter("nombre", nombre);
		return query.getResultList().get(0);
	}


}
