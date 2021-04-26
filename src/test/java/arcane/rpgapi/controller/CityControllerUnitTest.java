package arcane.rpgapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.rest.CityController;
import arcane.rpgapi.service.CityService;

@SpringBootTest
public class CityControllerUnitTest {
	
	@MockBean
	private CityService service;
	
	@Autowired
	private CityController controller;
	

	City validCity = new City(1,"vengatown",0,0,0,0,0,0,0,0,0,0);
	
	@BeforeEach
	void init() {
		
	}
	
	@Test
	void createTest() {
		when(service.create(Mockito.any(City.class))).thenReturn(validCity);
		ResponseEntity<City> response = new ResponseEntity<>(validCity, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.createCity(validCity));
		verify(service, times(1)).create(Mockito.any(City.class));
	}
	@Test
	void createWithNameTest() {
		when(service.create(Mockito.anyString())).thenReturn(validCity);
		ResponseEntity<City> response = new ResponseEntity<>(validCity, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.createCity("vengatown"));
		verify(service, times(1)).create(Mockito.anyString());
	}
	@Test
	void getWithNameTest() {
		when(service.read(Mockito.anyString())).thenReturn(validCity);
		ResponseEntity<City> response = new ResponseEntity<>(validCity, HttpStatus.OK);
		assertThat(response).isEqualTo(controller.getCities("vengatown"));
		verify(service, times(1)).read(Mockito.anyString());
	}
	@Test
	void getAllTest() {
		when(service.read()).thenReturn(List.of(validCity));
		ResponseEntity<List<City>> response = new ResponseEntity<>(List.of(validCity), HttpStatus.OK);
		assertThat(response).isEqualTo(controller.getCity());
		verify(service, times(1)).read();
	}
	@Test
	void updateTest() {
		City validCity2 = new City(1,"vengatown",1,1,5,4,7,8,4,2,3,4);
		when(service.update(Mockito.any(City.class))).thenReturn(validCity);
		ResponseEntity<City> response = new ResponseEntity<>(validCity, HttpStatus.OK);
		assertThat(response).isEqualTo(controller.update(validCity2));
		verify(service, times(1)).update(Mockito.any(City.class));
	}
}
