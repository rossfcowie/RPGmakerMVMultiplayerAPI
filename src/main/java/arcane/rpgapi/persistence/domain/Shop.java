package arcane.rpgapi.persistence.domain;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;


@Entity
public class Shop implements levelable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long level = 0;
	private long expReq = 0;
	private long maxlevel=2;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "FOO_TABLE", joinColumns = @JoinColumn(name = "fooId"))
	@MapKeyColumn(name="mapKey")
	@Column(name = "mapValue")
	private Map<Long,Long> wares =new HashMap<Long, Long>();
	
	@Override
	public void levelUp() {
		if(level<maxlevel) {
			level++;
		}
		
	}
	@Override
	public void gainExp(long gained) {
		expReq-=gained;
		if(expReq<0) {
			levelUp();
			expReq += 25 + level * Math.floor(Math.pow(level, 1.1));
		}
		
	}
	
	
	
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
	public Map<Long, Long> getWares() {
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
	public void add(Long item) {
		if(wares.containsKey(item)) {
			if(wares.get(item)>0) {
				wares.replace(item,wares.get(item)+(3+(level*level)-item));
			}
		}else {
			wares.put(item,1L);
		}
		
	}
	public void restock() {
		for (long i = 1; i <=1+ (level*level); i++) {
			add(i);
		}
	}

	

	
}
