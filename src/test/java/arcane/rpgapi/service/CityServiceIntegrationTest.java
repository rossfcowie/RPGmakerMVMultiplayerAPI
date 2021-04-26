package arcane.rpgapi.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.persistence.repo.CityRepository;


@SpringBootTest
@Transactional
public class CityServiceIntegrationTest {

	@Autowired
	CityService service;
	
	@Autowired
	CityRepository repo;
	

	City validCity = new City(1,"vengatown",1,0,0,0,0,0,0);
	
	@BeforeEach
	void init() {
		validCity = repo.save(validCity);
		
	}
	
	@Test
	void createTest() {
		Assertions.assertEquals(validCity,service.create(validCity));
	}
	@Test
	void createWithNameTest() {
		City validCity2 = new City(validCity.getId()+1,"vengatown 2",1,0,0,0,0,0,0);
		Assertions.assertEquals(validCity2,service.create("vengatown 2"));
	}
	@Test
	void readTest() {
		List<City> cities = List.of(validCity);
		Assertions.assertEquals(cities,service.read());
	}
	@Test
	void readNameTest() {
		Assertions.assertEquals(validCity,service.read("vengatown"));
	}
	
	@Test
	void updateTest() {
		City updatedCity = new City(validCity.getId(),"vengatown",1,1,1,1,1,1,1);
		Assertions.assertEquals(updatedCity,service.update(updatedCity));
	}
	
}
