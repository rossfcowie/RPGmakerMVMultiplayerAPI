package arcane.rpgapi.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import arcane.rpgapi.dto.MovementDTO;
import arcane.rpgapi.dto.PlayerDTO;
import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.persistence.domain.Player;
import arcane.rpgapi.persistence.repo.CityRepository;
import arcane.rpgapi.persistence.repo.PlayerRepository;
import arcane.rpgapi.persistence.repo.ShopRepository;

@Service
public class CityService {

	
	private ShopRepository sRepo;
	
	private CityRepository repo;
	
    private ModelMapper mapper;
	
    public CityService(CityRepository repo, ModelMapper mapper,ShopRepository sRepo) {
        super();
        this.sRepo = sRepo;
        this.repo = repo;
        this.mapper = mapper;
    }
    
	public City create(String name) {
		City created = new City(name);
		created = this.repo.save(created);
    	return created;
	}
	
	public City create(City city) {
		city.setItemShop(sRepo.save(city.getItemShop()));
		city.setWeaponShop(sRepo.save(city.getWeaponShop()));
		city.setArmourShop(sRepo.save(city.getArmourShop()));
		City created = this.repo.save(city);
    	return created;
	}

	public City update(City city) {
		City updated =  this.repo.findById(city.getId()).orElseThrow();
		updated.setAll(city);
		updated = this.repo.save(updated);
    	return updated;
	}

	public List<City> read() {
    	List<City> cities = repo.findAll();
    	return cities;
	}
	public City read(String name) {
    	City cities = repo.getByName(name);
    	return cities;
	}
}
