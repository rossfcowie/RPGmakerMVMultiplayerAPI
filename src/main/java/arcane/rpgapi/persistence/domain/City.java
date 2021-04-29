package arcane.rpgapi.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	@OneToOne(cascade = CascadeType.ALL)
	private Shop itemShop;
	@OneToOne(cascade = CascadeType.ALL)
	private Shop armourShop;
	@OneToOne(cascade = CascadeType.ALL)
	private Shop weaponShop;
	private long baracksLevel = 0L;
	
	
	
	public City(long id, String name, long theme, long castleLevel, long forestLevel, long mineLevel, long farmLevel,
			long innLevel, long baracksLevel) {
		super();
		this.id = id;
		this.name = name;
		this.theme = theme;
		this.castleLevel = castleLevel;
		this.forestLevel = forestLevel;
		this.mineLevel = mineLevel;
		this.farmLevel = farmLevel;
		this.itemShop = new Shop();
		this.armourShop = new Shop();
		this.weaponShop = new Shop();
		this.innLevel = innLevel;
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
		this.itemShop = city.itemShop;
		this.armourShop = city.armourShop;
		this.weaponShop = city.weaponShop;
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
		this.baracksLevel = 0;
		this.itemShop = new Shop();
		this.armourShop = new Shop();
		this.weaponShop = new Shop();
		
	}
	
	public City() {
		super();
		this.theme = 0;
		this.castleLevel = 0;
		this.forestLevel = 0;
		this.mineLevel = 0;
		this.farmLevel = 0;
		this.innLevel = 0;
		this.baracksLevel = 0;
	}
	public City(long id, String name, Shop itemShop, Shop armourShop, Shop weaponShop, int theme, int castleLevel, int forestLevel
			, int mineLevel,int farmLevel, int innLevel, int baracksLevel) {
		this.id = id;
		this.name = name;
		this.theme = theme;
		this.castleLevel = castleLevel;
		this.forestLevel = forestLevel;
		this.mineLevel = mineLevel;
		this.farmLevel = farmLevel;
		this.itemShop = itemShop;
		this.armourShop = armourShop;
		this.weaponShop = weaponShop;
		this.innLevel = innLevel;
		this.baracksLevel = baracksLevel;
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
	public Shop getItemShop() {
		return itemShop;
	}
	public Shop getArmourShop() {
		return armourShop;
	}
	public Shop getWeaponShop() {
		return weaponShop;
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
	public void setItemShop(Shop itemShop) {
		this.itemShop = itemShop;
	}
	public void setArmourShop(Shop armourShop) {
		this.armourShop = armourShop;
	}
	public void setWeaponShop(Shop weaponShop) {
		this.weaponShop = weaponShop;
	}
	public void setBaracksLevel(long baracksLevel) {
		this.baracksLevel = baracksLevel;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", theme=" + theme + ", castleLevel=" + castleLevel
				+ ", forestLevel=" + forestLevel + ", mineLevel=" + mineLevel + ", farmLevel=" + farmLevel
				+ ", innLevel=" + innLevel + ", itemShop=" + itemShop + ", armourShop=" + armourShop
				+ ", weaponShop=" + weaponShop + ", baracksLevel=" + baracksLevel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((armourShop == null) ? 0 : armourShop.hashCode());
		result = prime * result + (int) (baracksLevel ^ (baracksLevel >>> 32));
		result = prime * result + (int) (castleLevel ^ (castleLevel >>> 32));
		result = prime * result + (int) (farmLevel ^ (farmLevel >>> 32));
		result = prime * result + (int) (forestLevel ^ (forestLevel >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (innLevel ^ (innLevel >>> 32));
		result = prime * result + ((itemShop == null) ? 0 : itemShop.hashCode());
		result = prime * result + (int) (mineLevel ^ (mineLevel >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (theme ^ (theme >>> 32));
		result = prime * result + ((weaponShop == null) ? 0 : weaponShop.hashCode());
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
		if (mineLevel != other.mineLevel)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (theme != other.theme)

			return false;
		return true;
	}
	
}
