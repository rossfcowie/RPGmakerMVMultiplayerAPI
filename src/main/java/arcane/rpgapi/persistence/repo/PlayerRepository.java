package arcane.rpgapi.persistence.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import arcane.rpgapi.persistence.domain.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>  {
	
	@Query(value = "SELECT * FROM Player WHERE username = ?1", nativeQuery = true)
	public Optional<Player> findByUsername(String username);
	@Query(value = "SELECT * FROM Player WHERE mapid = ?1 LIMIT 50", nativeQuery = true)
	public List<Player> findbyMapID(Long mapid);
}
