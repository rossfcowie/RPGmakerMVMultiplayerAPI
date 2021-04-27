package arcane.rpgapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.service.CityService;
import arcane.rpgapi.service.ShopService;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

	
	private ShopService service;
	
	@Autowired
	public ShopController(ShopService service) {
		super();
		this.service = service;
	}
	@PutMapping(value = "/{shop}/{item}")
	public ResponseEntity<Boolean> buy(@PathVariable Long shop, @PathVariable Long item) {
		service.buy(shop,item);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
}
