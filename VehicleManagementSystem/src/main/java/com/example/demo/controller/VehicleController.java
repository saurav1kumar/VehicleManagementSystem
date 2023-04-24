package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	VehicleService vehicleService;

	@PostMapping("/addVehicles")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v) {
		return new ResponseEntity<Vehicle>(vehicleService.addVehicle(v), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteVehicle")
	public ResponseEntity<Vehicle> deleteVehicle(@RequestParam Integer vid) {
		return new ResponseEntity<Vehicle>(vehicleService.deleteVehicle(vid), HttpStatus.OK);
	}

	@GetMapping("/getAllVehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/getVehicleById")
	public ResponseEntity<Vehicle> getVehicleById(@RequestHeader Integer vid) {
		Vehicle vehicle = vehicleService.getById(vid);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}

	@GetMapping("/color/{vcolor}")
	public ResponseEntity<List<Vehicle>> getByColor(@RequestHeader String vcolor) {
		List<Vehicle> vehicles = vehicleService.getByColor(vcolor);
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/sorted-by-price")
	public ResponseEntity<List<Vehicle>> getVehiclesSortedByPrice(@RequestParam double vprice) {
	    List<Vehicle> vehicles = vehicleService.findByVpriceGreaterThanEqualOrderByVpriceAsc(vprice);
	    return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}


	@PutMapping("/updateVehicle")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle v) {
		return new ResponseEntity<Vehicle>(vehicleService.updateVehicle(v), HttpStatus.OK);
	}
	
	@GetMapping("/sorted-by-price-and-color")
	public ResponseEntity<List<Vehicle>> findByOrderByvpriceAsccolorAsc(@RequestHeader double vprice, String vcolor) {
		List<Vehicle> vehicles = vehicleService.findByOrderByvpriceAsccolorAsc(vprice, vcolor);
		return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}
	@GetMapping("/price-above-1000000")
	public ResponseEntity<List<Vehicle>> getVehiclesWithPriceAbove() {
	    List<Vehicle> vehicles = vehicleService.getVehiclesWithPriceAbove(1000000);
	    return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}


	@ExceptionHandler
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
