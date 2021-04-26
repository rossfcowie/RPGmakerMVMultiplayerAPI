package arcane.rpgapi.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import arcane.rpgapi.dto.MovementDTO;
import arcane.rpgapi.dto.PlayerDTO;
import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.persistence.domain.Player;
import arcane.rpgapi.persistence.repo.CityRepository;
import arcane.rpgapi.persistence.repo.PlayerRepository;

@SpringBootTest
@Transactional
public class PlayerServiceIntegrationTest {
	
	@Autowired
	PlayerService service;
	
	@Autowired
	PlayerRepository repo;
	
	@Autowired
	ModelMapper mapper;
	
	PlayerDTO validPlayerDTO = new PlayerDTO(1,"Harold",1,1,1,100,100,100,100,5,5,5,5,5,5);
	Player validPlayer = new Player(validPlayerDTO);
	MovementDTO  validMovementDTO = new MovementDTO(1, "Harold",1,1,1);
	
	@BeforeEach
	void init() {
		validPlayer = repo.save(validPlayer);
		validPlayerDTO = mapper.map(validPlayer, PlayerDTO.class);
		validMovementDTO.setId(validPlayer.getId());
	}
	
	@Test
	void createTest() {
		PlayerDTO newPlayerDTO = new PlayerDTO(validPlayer.getId()+1,"PlayerA",2,2,2,150,80,150,80,6,8,2,6,7,8);
		Assertions.assertEquals(newPlayerDTO,service.create(newPlayerDTO));
	}
	
	@Test
	void moveTest() {
		 validMovementDTO = new MovementDTO(validPlayer.getId(), "Harold",1,2,2);
		PlayerDTO newPlayerDTO = new PlayerDTO(validPlayer.getId(),"Harold",1,2,2,100,100,100,100,5,5,5,5,5,5);
		Player movedPlayer = new Player(newPlayerDTO);
		Assertions.assertEquals(newPlayerDTO,service.move(validMovementDTO));
	}
	@Test
	void readTest() {
		
		List<Player> players = List.of(validPlayer);
		List<MovementDTO> movementDTOs = List.of(validMovementDTO);
		Assertions.assertEquals(movementDTOs,service.readAll((long) validPlayer.getMapID()));
	}
	@Test
	void readEveryTest() {
		List<Player> players = List.of(validPlayer);
		List<MovementDTO> movementDTOs = List.of(validMovementDTO);
		Assertions.assertEquals(movementDTOs,service.read());
	}
	@Test
	void readPlayerTest() {
		Assertions.assertEquals(validPlayerDTO,service.read(validPlayer.getId()));
	}
	@Test
	void sleepPlayerTest() {
		Assertions.assertTrue(service.sleep(validPlayer.getId()));
	}
	
}
