package arcane.rpgapi.persistence.domain;


import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long level = 0;
	private HashMap<Long,Long> wares;
	
	
	
	
	
	public Shop() {
		super();
		this.wares= new HashMap<>();
		wares.put(1L, 1L);
	}
	public Shop(long id, long level, HashMap<Long, Long> wares) {
		super();
		this.id = id;
		this.level = level;
		this.wares = wares;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (level ^ (level >>> 32));
		result = prime * result + ((wares == null) ? 0 : wares.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (id != other.id)
			return false;
		if (level != other.level)
			return false;
		if (wares == null) {
			if (other.wares != null)
				return false;
		} else if (!wares.equals(other.wares))
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public long getLevel() {
		return level;
	}
	public HashMap<Long, Long> getWares() {
		return wares;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setLevel(long level) {
		this.level = level;
	}
	public void setWares(HashMap<Long, Long> wares) {
		this.wares = wares;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", level=" + level + ", wares=" + wares + "]";
	}
	public void setAll(Shop shop) {
		this.wares = shop.wares;
		this.level = shop.level;
	}
	public void buy(Long item) {
		if(wares.containsKey(item)) {
			if(wares.get(item)>1) {
				wares.replace(item,wares.get(item)-1);
			}else {
				wares.remove(item);
			}
		}
		
	}
	

	
}
