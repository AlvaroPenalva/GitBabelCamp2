package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimiento;

public interface MovimientoDao extends JpaRepository<Movimiento, Integer>{
	
	@Query("Select m from Movimiento m where m.fecha between ?1 and ?2")
	List<Movimiento> findBetweenDates(Date d1, Date d2);
	
}
