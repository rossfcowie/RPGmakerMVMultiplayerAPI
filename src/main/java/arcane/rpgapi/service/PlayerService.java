package arcane.rpgapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


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
    	Player created = this.repo.save(new Player(playerDto));
    	return this.mapToDTO(created);
    }
    private PlayerDTO mapToDTO(Player player) {
    	return this.mapper.map(player,PlayerDTO.class);
    }
    public PlayerDTO move(PlayerDTO playerDto) {
    	
    	Optional<Player> updatedopt = this.repo.findByUsername(playerDto.getUsername());
    	Player updated = null;
    	try {
			updated = updatedopt.get();
		} catch (Exception e) {
		}
    	System.out.print(playerDto.getUsername());
    	updated.setMapID(playerDto.getMapID());
    	updated.setX(playerDto.getX());
    	updated.setY(playerDto.getY());
    	updated = this.repo.save(updated);
    	return this.mapToDTO(updated);
    }
    
    public List<PlayerDTO> read() {
    	List<Player> players = repo.findAll();
    	List<PlayerDTO> playerDtos = new ArrayList<>();
    	players.forEach(player->playerDtos.add(mapToDTO(player)));
    	return playerDtos;
    }
}
