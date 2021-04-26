package arcane.rpgapi.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arcane.rpgapi.persistence.domain.Shop;


@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>  {

	
}
