package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
	@Query(value = "SELECT * FROM vehicle WHERE vcolor = ?;", nativeQuery = true)
	List<Vehicle> findBycolor(String vcolor);

	@Query(value = "SELECT * FROM vehicle WHERE vprice > 1000000;\r\n" + "", nativeQuery = true)
	List<Vehicle> getVehiclesWithPriceAbove(double vprice);

	@Query(value = "SELECT * FROM vehicle ORDER BY vprice ASC, vcolor ASC", nativeQuery = true)
	List<Vehicle> findByOrderByvpriceAscvcolorAsc(double vprice, String vcolor);

	@Query(value = "SELECT * FROM vehicle WHERE vprice >= ? ORDER BY vprice ASC;", nativeQuery = true)
	List<Vehicle> findByVpriceGreaterThanEqualOrderByVpriceAsc(double vprice);
}
