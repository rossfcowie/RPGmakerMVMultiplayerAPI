package arcane.rpgapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import arcane.rpgapi.dto.MovementDTO;
import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.service.CityService;

@RestController
@RequestMapping("/city")
@CrossOrigin
public class CityController {
	
	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	@PostMapping
	public ResponseEntity<City> createCity(@RequestBody City city) {
		City created =cityService.create(city);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	@PostMapping(value = "/create")
	public ResponseEntity<City> createCity(@RequestParam String name) {
		City created =cityService.create(name);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	@GetMapping(value = "/{name}")
	public ResponseEntity<City> getCities(@PathVariable String name) {
		City cities = cityService.read(name);
		return new ResponseEntity<>(cities,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<City>> getCity() {
		List<City> cities = cityService.read();
		return new ResponseEntity<>(cities,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<City> update(@RequestBody City city) {
		City cities = cityService.update(city);
		return new ResponseEntity<>(cities,HttpStatus.OK);
	}
}
