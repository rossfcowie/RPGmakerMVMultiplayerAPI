package arcane.rpgapi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import arcane.rpgapi.service.ShopService;

@Component
public class DayFlipper {
	private ShopService service;
	
	@Autowired
	public DayFlipper(ShopService service) {
		super();
		this.service = service;
	}
	@Scheduled(fixedDelay=30000)
	public void aaa() {
		System.out.println("Day flipped");
		service.restockAll();
	}
	
}
