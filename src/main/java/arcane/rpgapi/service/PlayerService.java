package arcane.rpgapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import arcane.rpgapi.dto.MovementDTO;
import arcane.rpgapi.dto.PlayerDTO;
import arcane.rpgapi.persistence.domain.Player;
import arcane.rpgapi.persistence.repo.PlayerRepository;

@Service
public class PlayerService {

	private PlayerRepository repo;
    private ModelMapper mapper;
	
    public PlayerService(PlayerRepository repo, ModelMapper mapper) {
        super();
        
        this.repo = repo;
        this.mapper = mapper;
    }
    
    public PlayerDTO create(PlayerDTO playerDto) {
    	Player created = this.repo.save(mapFromDTO(playerDto));
    	return this.mapToDTO(created);
    }
    private PlayerDTO mapToDTO(Player player) {
    	return this.mapper.map(player,PlayerDTO.class);
    }
    private Player mapFromDTO(PlayerDTO playerDTO) {
    	return new Player(playerDTO);
    }
    public PlayerDTO move(MovementDTO movementDTO) {
    	Optional<Player> updatedopt = this.repo.findByUsername(movementDTO.getUsername());
    	Player updated = null;
    	try {
			updated = updatedopt.get();
		} catch (Exception e) {
			return null;
		}
    	updated.setMapID(movementDTO.getMapID());
    	updated.setX(movementDTO.getX());
    	updated.setY(movementDTO.getY());
    	updated = this.repo.save(updated);
    	return this.mapToDTO(updated);
    }
    
    public List<MovementDTO> read() {
    	List<Player> players = repo.findAll();
    	List<MovementDTO> playerDtos = new ArrayList<>();
    	players.forEach(player->playerDtos.add(mapToMovementDTO(player)));
    	return playerDtos;
    }

	private MovementDTO mapToMovementDTO(Player player) {
    	return this.mapper.map(player,MovementDTO.class);
	}
	public List<MovementDTO> readAll(Long id) {
    	List<Player> players = repo.findbyMapID(id);
    	List<MovementDTO> playerDtos = new ArrayList<>();
    	players.forEach(player->playerDtos.add(mapToMovementDTO(player)));
    	return playerDtos;
	}
	public PlayerDTO read(Long id) {
    	Optional<Player> readopt = this.repo.findById(id);
    	Player read = null;
    	try {
    		read = readopt.get();
		} catch (Exception e) {
		}
    	return this.mapToDTO(read);
	}

	public Boolean delete(Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

	public Boolean sleep(Long id) {
    	Optional<Player> updatedopt = this.repo.findById(id);
    	Player updated = null;
    	try {
			updated = updatedopt.get();
		} catch (Exception e) {
			return false;
		}
    	updated.setMapID(0);
    	updated = this.repo.save(updated);
    	return true;
	}
}
