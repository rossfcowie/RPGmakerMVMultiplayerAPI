package arcane.rpgapi.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import arcane.rpgapi.dto.MovementDTO;
import arcane.rpgapi.dto.PlayerDTO;
import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.persistence.domain.Player;
import arcane.rpgapi.persistence.repo.CityRepository;
import arcane.rpgapi.persistence.repo.PlayerRepository;

@SpringBootTest
public class CityServiceUnitTest {

	@MockBean
	CityRepository repo;
	
	@Autowired
	private CityService cityService;

	City validCity = new City(1,"vengatown",0,0,0,0,0,0,0);

	
	@Test
	void createTest() {
		when(repo.save(Mockito.any(City.class))).thenReturn(validCity);
		Assertions.assertEquals(validCity,cityService.create(validCity));
		verify(repo, times(1)).save(Mockito.any(City.class));
	}
	@Test
	void createWithNameTest() {
		City validCity2 = new City(2,"vengatown 2",0,0,0,0,0,0,0);
		when(repo.save(Mockito.any(City.class))).thenReturn(validCity2);
		Assertions.assertEquals(validCity2,cityService.create("vengatown 2"));
		verify(repo, times(1)).save(Mockito.any(City.class));
	}
	@Test
	void readTest() {
		List<City> cities = List.of(validCity);
		when(repo.findAll()).thenReturn(List.of(validCity));
		Assertions.assertEquals(cities,cityService.read());
		verify(repo, times(1)).findAll();
	}
	@Test
	void readNameTest() {
		when(repo.getByName(Mockito.anyString())).thenReturn(validCity);
		Assertions.assertEquals(validCity,cityService.read("vengatown"));
		verify(repo, times(1)).getByName(Mockito.anyString());
	}
	
	@Test
	void updateTest() {
		City updatedCity = new City(1,"vengatown",1,1,1,1,1,1,1);
		when(repo.findById(Mockito.anyLong())).thenReturn(Optional.of(validCity));
		when(repo.save(Mockito.any(City.class))).thenReturn(updatedCity);
		Assertions.assertEquals(updatedCity,cityService.update(updatedCity));
		verify(repo, times(1)).findById(Mockito.anyLong());
		verify(repo, times(1)).save(Mockito.any(City.class));
	}
}
