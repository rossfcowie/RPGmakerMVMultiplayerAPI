package arcane.rpgapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arcane.rpgapi.dto.MovementDTO;
import arcane.rpgapi.dto.PlayerDTO;
import arcane.rpgapi.persistence.domain.Player;
import arcane.rpgapi.service.PlayerService;


@RestController
@RequestMapping("/playerLocations")
@CrossOrigin
public class PlayerController {

	private PlayerService playerService;
	
	@Autowired
	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}
	
	
	@PostMapping
	public ResponseEntity<PlayerDTO> createCharacter(@RequestBody PlayerDTO player) {
		PlayerDTO created =playerService.create(player);
		return new ResponseEntity<>(created,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<PlayerDTO> MoveCharacter(@RequestBody MovementDTO player) {
		PlayerDTO updated =playerService.move(player);
		return new ResponseEntity<>(updated,HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Boolean> sleepCharacter(@PathVariable Long id) {
		return new ResponseEntity<>(playerService.sleep(id),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<MovementDTO>> getCharacters() {
		List<MovementDTO> dtos = playerService.read();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	@GetMapping("/here/{id}")
	public ResponseEntity<List<MovementDTO>> getCharactersbyMap(@PathVariable Long id) {
		List<MovementDTO> dtos = playerService.readAll(id);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<PlayerDTO> getCharacters(@PathVariable Long id) {
		PlayerDTO dto = playerService.read(id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteme(@PathVariable Long id){
		return new ResponseEntity<>(playerService.delete(id),HttpStatus.OK);
		
	}

}
