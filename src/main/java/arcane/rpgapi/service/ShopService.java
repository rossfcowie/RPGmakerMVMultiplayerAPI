package arcane.rpgapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.persistence.domain.Shop;
import arcane.rpgapi.persistence.repo.ShopRepository;

@Service
public class ShopService {

	private ShopRepository repo;
	
    private ModelMapper mapper;
    public ShopService(ModelMapper mapper,ShopRepository repo) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }
    
	public Shop buy(Long id, Long item) {
		Shop updated =  this.repo.findById(id).orElseThrow();
		updated.buy(item);
		updated = this.repo.save(updated);
    	return updated;
	}
    
}
