package arcane.rpgapi.persistence.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.persistence.domain.Player;


@Repository
public interface CityRepository extends JpaRepository<City, Long>  {

	
	City getByName(String name);
	
}
