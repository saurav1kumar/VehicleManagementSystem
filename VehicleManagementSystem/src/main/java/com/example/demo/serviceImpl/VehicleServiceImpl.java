package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.module.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepo repo;

	@Override
	public Vehicle addVehicle(Vehicle v) {
		// TODO Auto-generated method stub
		return repo.save(v);
	}

	@Override
	public Vehicle deleteVehicle(Integer vid) {
		Vehicle v = repo.findById(vid).orElse(null);
		if (v != null) {
			repo.deleteById(vid);
			return v;
		} else {
			throw new ResourceNotFoundException("Vehicle", "Id", vid);
		}
	}

	@Override
	public Vehicle getById(Integer vid) {
		return repo.findById(vid).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id", vid));
	}

	@Override
	public List<Vehicle> getByColor(String vcolor) {
		// TODO Auto-generated method stub
		return repo.findBycolor(vcolor);
	}

	@Override
	public Vehicle updateVehicle(Vehicle v) {
		Vehicle v1 = repo.findById(v.getVid()).orElse(null);
		if (v1 != null) {
			v1.setVname(v.getVname());
			v1.setVprice(v.getVprice());
			v1.setVcolor(v.getVcolor());
			v1.setVmodel(v.getVmodel());
			return repo.save(v1);
		} else {
			throw new ResourceNotFoundException("Vehicle", "Id", v);
		}
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return repo.findAll();
	}

	@Override
	public List<Vehicle> findByOrderByvpriceAsccolorAsc(double vprice, String vcolor) {
		// TODO Auto-generated method stub
		return repo.findByOrderByvpriceAscvcolorAsc(vprice, vcolor);
	}

	@Override
	public List<Vehicle> getVehiclesWithPriceAbove(double vprice) {
		// TODO Auto-generated method stub
		return repo.getVehiclesWithPriceAbove(vprice);
	}

	@Override
	public List<Vehicle> findByVpriceGreaterThanEqualOrderByVpriceAsc(double vprice) {
		// TODO Auto-generated method stub
		return repo.findByVpriceGreaterThanEqualOrderByVpriceAsc(vprice);
	}

}
