package arcane.rpgapi.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class City {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Column(unique = true)
	private String name;
	private long theme = 1L;
	private long castleLevel = 0L;
	private long forestLevel = 0L;
	private long mineLevel = 0L;
	private long farmLevel = 0L;
	private long innLevel = 0L;
	private long itemShopLevel = 0L;
	private long armourShopLevel = 0L;
	private long weaponShopLevel = 0L;
	private long baracksLevel = 0L;
	
	
	
	public City(long id, String name, long theme, long castleLevel, long forestLevel, long mineLevel, long farmLevel,
			long innLevel, long itemShopLevel, long armourShopLevel, long weaponShopLevel, long baracksLevel) {
		super();
		this.id = id;
		this.name = name;
		this.theme = theme;
		this.castleLevel = castleLevel;
		this.forestLevel = forestLevel;
		this.mineLevel = mineLevel;
		this.farmLevel = farmLevel;
		this.innLevel = innLevel;
		this.itemShopLevel = itemShopLevel;
		this.armourShopLevel = armourShopLevel;
		this.weaponShopLevel = weaponShopLevel;
		this.baracksLevel = baracksLevel;
	}
	
	public void setAll(City city) {
		this.name = city.name;
		this.theme = city.theme;
		this.castleLevel = city.castleLevel;
		this.forestLevel = city.forestLevel;
		this.mineLevel = city.mineLevel;
		this.farmLevel = city.farmLevel;
		this.innLevel = city.innLevel;
		this.itemShopLevel = city.itemShopLevel;
		this.armourShopLevel = city.armourShopLevel;
		this.weaponShopLevel = city.weaponShopLevel;
		this.baracksLevel = city.baracksLevel;
		
	}
	
	public City(String name) {
		super();
		this.name = name;
		this.theme = 1;
		this.castleLevel = 0;
		this.forestLevel = 0;
		this.mineLevel = 0;
		this.farmLevel = 0;
		this.innLevel = 0;
		this.itemShopLevel = 0;
		this.armourShopLevel = 0;
		this.weaponShopLevel = 0;
		this.baracksLevel = 0;
		
	}
	
	public City() {
		super();
		this.theme = 0;
		this.castleLevel = 0;
		this.forestLevel = 0;
		this.mineLevel = 0;
		this.farmLevel = 0;
		this.innLevel = 0;
		this.itemShopLevel = 0;
		this.armourShopLevel = 0;
		this.weaponShopLevel = 0;
		this.baracksLevel = 0;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public long getTheme() {
		return theme;
	}
	public long getCastleLevel() {
		return castleLevel;
	}
	public long getForestLevel() {
		return forestLevel;
	}
	public long getMineLevel() {
		return mineLevel;
	}
	public long getFarmLevel() {
		return farmLevel;
	}
	public long getInnLevel() {
		return innLevel;
	}
	public long getItemShopLevel() {
		return itemShopLevel;
	}
	public long getArmourShopLevel() {
		return armourShopLevel;
	}
	public long getWeaponShopLevel() {
		return weaponShopLevel;
	}
	public long getBaracksLevel() {
		return baracksLevel;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTheme(long theme) {
		this.theme = theme;
	}
	public void setCastleLevel(long castleLevel) {
		this.castleLevel = castleLevel;
	}
	public void setForestLevel(long forestLevel) {
		this.forestLevel = forestLevel;
	}
	public void setMineLevel(long mineLevel) {
		this.mineLevel = mineLevel;
	}
	public void setFarmLevel(long farmLevel) {
		this.farmLevel = farmLevel;
	}
	public void setInnLevel(long innLevel) {
		this.innLevel = innLevel;
	}
	public void setItemShopLevel(long itemShopLevel) {
		this.itemShopLevel = itemShopLevel;
	}
	public void setArmourShopLevel(long armourShopLevel) {
		this.armourShopLevel = armourShopLevel;
	}
	public void setWeaponShopLevel(long weaponShopLevel) {
		this.weaponShopLevel = weaponShopLevel;
	}
	public void setBaracksLevel(long baracksLevel) {
		this.baracksLevel = baracksLevel;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", theme=" + theme + ", castleLevel=" + castleLevel
				+ ", forestLevel=" + forestLevel + ", mineLevel=" + mineLevel + ", farmLevel=" + farmLevel
				+ ", innLevel=" + innLevel + ", itemShopLevel=" + itemShopLevel + ", armourShopLevel=" + armourShopLevel
				+ ", weaponShopLevel=" + weaponShopLevel + ", baracksLevel=" + baracksLevel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (armourShopLevel ^ (armourShopLevel >>> 32));
		result = prime * result + (int) (baracksLevel ^ (baracksLevel >>> 32));
		result = prime * result + (int) (castleLevel ^ (castleLevel >>> 32));
		result = prime * result + (int) (farmLevel ^ (farmLevel >>> 32));
		result = prime * result + (int) (forestLevel ^ (forestLevel >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (innLevel ^ (innLevel >>> 32));
		result = prime * result + (int) (itemShopLevel ^ (itemShopLevel >>> 32));
		result = prime * result + (int) (mineLevel ^ (mineLevel >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (theme ^ (theme >>> 32));
		result = prime * result + (int) (weaponShopLevel ^ (weaponShopLevel >>> 32));
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
		City other = (City) obj;
		if (armourShopLevel != other.armourShopLevel)
			return false;
		if (baracksLevel != other.baracksLevel)
			return false;
		if (castleLevel != other.castleLevel)
			return false;
		if (farmLevel != other.farmLevel)
			return false;
		if (forestLevel != other.forestLevel)
			return false;
		if (id != other.id)
			return false;
		if (innLevel != other.innLevel)
			return false;
		if (itemShopLevel != other.itemShopLevel)
			return false;
		if (mineLevel != other.mineLevel)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (theme != other.theme)
			return false;
		if (weaponShopLevel != other.weaponShopLevel)
			return false;
		return true;
	}
	
}
