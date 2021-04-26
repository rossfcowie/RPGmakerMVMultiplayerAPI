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
import arcane.rpgapi.persistence.domain.Player;
import arcane.rpgapi.persistence.repo.PlayerRepository;

@SpringBootTest
public class PlayerServiceUnitTest {

	@MockBean
	PlayerRepository repo;
	
	@MockBean
	ModelMapper mapper;
	
	@Autowired
	private PlayerService playerService;
	
	
	PlayerDTO validPlayerDTO = new PlayerDTO(1,"Harold",1,1,1,100,100,100,100,5,5,5,5,5,5);
	Player validPlayer = new Player(validPlayerDTO);
	MovementDTO  validMovementDTO = new MovementDTO(1, "Harold",1,2,2);
	
	@Test
	void createTest() {
		when(repo.save(Mockito.any(Player.class))).thenReturn(validPlayer);
		when(mapper.map(Mockito.any(), Mockito.any())).thenReturn(validPlayerDTO);
		Assertions.assertEquals(validPlayerDTO,playerService.create(validPlayerDTO));
		verify(repo, times(1)).save(Mockito.any(Player.class));
		verify(mapper, times(1)).map(Mockito.any(), Mockito.any());
	}
	
	@Test
	void moveTest() {
		PlayerDTO newPlayerDTO = new PlayerDTO(1,"Harold",1,2,2,100,100,100,100,5,5,5,5,5,5);
		Player movedPlayer = new Player(newPlayerDTO);
		when(repo.findByUsername(Mockito.anyString())).thenReturn(Optional.of(validPlayer));
		when(repo.save(Mockito.any(Player.class))).thenReturn(movedPlayer);
		when(mapper.map(Mockito.any(), Mockito.any())).thenReturn(newPlayerDTO);
		Assertions.assertEquals(newPlayerDTO,playerService.move(validMovementDTO));
		verify(repo, times(1)).save(Mockito.any(Player.class));
		verify(repo, times(1)).findByUsername(Mockito.anyString());
		verify(mapper, times(1)).map(Mockito.any(), Mockito.any());
	}
	@Test
	void readTest() {
		List<Player> players = List.of(validPlayer);
		List<MovementDTO> movementDTOs = List.of(validMovementDTO);
		when(repo.findbyMapID(Mockito.anyLong())).thenReturn(players);
		when(mapper.map(Mockito.any(), Mockito.any())).thenReturn(validMovementDTO);
		Assertions.assertEquals(movementDTOs,playerService.readAll(1L));
		verify(repo, times(1)).findbyMapID(Mockito.anyLong());
		verify(mapper, times(1)).map(Mockito.any(), Mockito.any());
	}
	@Test
	void readEveryTest() {
		List<Player> players = List.of(validPlayer);
		List<MovementDTO> movementDTOs = List.of(validMovementDTO);
		when(repo.findAll()).thenReturn(players);
		when(mapper.map(Mockito.any(), Mockito.any())).thenReturn(validMovementDTO);
		Assertions.assertEquals(movementDTOs,playerService.read());
		verify(repo, times(1)).findAll();
		verify(mapper, times(1)).map(Mockito.any(), Mockito.any());
	}
	@Test
	void readPlayerTest() {
		when(repo.findById(Mockito.anyLong())).thenReturn(Optional.of(validPlayer));
		when(mapper.map(Mockito.any(), Mockito.any())).thenReturn(validPlayerDTO);
		Assertions.assertEquals(validPlayerDTO,playerService.read(1L));
		verify(repo, times(1)).findById(Mockito.anyLong());
		verify(mapper, times(1)).map(Mockito.any(), Mockito.any());
	}
	@Test
	void sleepPlayerTest() {
		PlayerDTO newPlayerDTO = new PlayerDTO(1,"Harold",0,1,1,100,100,100,100,5,5,5,5,5,5);
		Player sleepingPlayer = new Player(newPlayerDTO);
		when(repo.findById(Mockito.anyLong())).thenReturn(Optional.of(validPlayer));
		when(repo.save(Mockito.any(Player.class))).thenReturn(sleepingPlayer);
		Assertions.assertTrue(playerService.sleep(1L));
		verify(repo, times(1)).save(Mockito.any(Player.class));
		verify(repo, times(1)).findById(Mockito.anyLong());
	}
}
