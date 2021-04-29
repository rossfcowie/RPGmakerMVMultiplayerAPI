package arcane.rpgapi.service;

import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import arcane.rpgapi.persistence.domain.City;
import arcane.rpgapi.persistence.domain.Shop;
import arcane.rpgapi.persistence.repo.ShopRepository;

@Service
public class ShopService {

	private ShopRepository repo;

	private ModelMapper mapper;

	public ShopService(ModelMapper mapper, ShopRepository repo) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public Shop buy(Long id, Long item) {
		Shop updated = this.repo.findById(id).orElseThrow();
		updated.buy(item);
		updated = this.repo.save(updated);
		return updated;
	}

	public Shop addExp(Long id, Long exp) {
		Shop updated = this.repo.findById(id).orElseThrow();
		updated.gainExp(exp);
		updated = this.repo.save(updated);
		return updated;
	}

	public void restock(Shop shop) {
		shop.restock();
		this.repo.save(shop);
	}

	public void restockAll() {

		for (Shop shop : repo.findAll()) {
			restock(shop);
		}

	}

}
