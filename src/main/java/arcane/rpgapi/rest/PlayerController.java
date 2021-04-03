package arcane.rpgapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<PlayerDTO> MoveCharacter(@RequestBody PlayerDTO player) {
		PlayerDTO updated =playerService.move(player);
		return new ResponseEntity<>(updated,HttpStatus.OK);
	}
		
	@GetMapping
	public ResponseEntity<List<PlayerDTO>> getCharacters() {
		List<PlayerDTO> dtos = playerService.read();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
}
