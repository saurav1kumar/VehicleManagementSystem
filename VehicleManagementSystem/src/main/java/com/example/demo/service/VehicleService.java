package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Vehicle;

public interface VehicleService {
	Vehicle addVehicle(Vehicle v);

	Vehicle deleteVehicle(Integer vid);

	Vehicle getById(Integer vid);

	List<Vehicle> getByColor(String vcolor);

	Vehicle updateVehicle(Vehicle v);

	List<Vehicle> getAllVehicles();


	List<Vehicle> findByOrderByvpriceAsccolorAsc(double vprice, String vcolor);


	List<Vehicle> getVehiclesWithPriceAbove(double vprice);

	List<Vehicle> findByVpriceGreaterThanEqualOrderByVpriceAsc(double vprice);

}
