package arcane.rpgapi.dto;


public class PlayerDTO {
    private long id;
    private String username;
    private int mapID;
    private int x;
    private int y;
    private int hp;
    private int mp;
    private int mhp;
    private int mmp;
    private int atk;
    private int def;
    private int mat;
    private int mdf;
    private int agi;
    private int luk;

    
	
	
	public PlayerDTO(long id, String username, int mapID, int x, int y, int hp, int mp, int mhp, int mmp, int atk,
			int def, int mat, int mdf, int agi, int luk) {
		super();
		this.id = id;
		this.username = username;
		this.mapID = mapID;
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.mp = mp;
		this.mhp = mhp;
		this.mmp = mmp;
		this.atk = atk;
		this.def = def;
		this.mat = mat;
		this.mdf = mdf;
		this.agi = agi;
		this.luk = luk;
	}


	public PlayerDTO() {
		super();
	}


	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public int getMapID() {
		return mapID;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setMapID(int mapID) {
		this.mapID = mapID;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}


	public int getHp() {
		return hp;
	}


	public int getMp() {
		return mp;
	}


	public int getMhp() {
		return mhp;
	}


	public int getMmp() {
		return mmp;
	}


	public int getAtk() {
		return atk;
	}


	public int getDef() {
		return def;
	}


	public int getMat() {
		return mat;
	}


	public int getMdf() {
		return mdf;
	}


	public int getAgi() {
		return agi;
	}


	public int getLuk() {
		return luk;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public void setMp(int mp) {
		this.mp = mp;
	}


	public void setMhp(int mhp) {
		this.mhp = mhp;
	}


	public void setMmp(int mmp) {
		this.mmp = mmp;
	}


	public void setAtk(int atk) {
		this.atk = atk;
	}


	public void setDef(int def) {
		this.def = def;
	}


	public void setMat(int mat) {
		this.mat = mat;
	}


	public void setMdf(int mdf) {
		this.mdf = mdf;
	}


	public void setAgi(int agi) {
		this.agi = agi;
	}


	public void setLuk(int luk) {
		this.luk = luk;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agi;
		result = prime * result + atk;
		result = prime * result + def;
		result = prime * result + hp;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + luk;
		result = prime * result + mapID;
		result = prime * result + mat;
		result = prime * result + mdf;
		result = prime * result + mhp;
		result = prime * result + mmp;
		result = prime * result + mp;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + x;
		result = prime * result + y;
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
		PlayerDTO other = (PlayerDTO) obj;
		if (agi != other.agi)
			return false;
		if (atk != other.atk)
			return false;
		if (def != other.def)
			return false;
		if (hp != other.hp)
			return false;
		if (id != other.id)
			return false;
		if (luk != other.luk)
			return false;
		if (mapID != other.mapID)
			return false;
		if (mat != other.mat)
			return false;
		if (mdf != other.mdf)
			return false;
		if (mhp != other.mhp)
			return false;
		if (mmp != other.mmp)
			return false;
		if (mp != other.mp)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PlayerDTO [id=" + id + ", username=" + username + ", mapID=" + mapID + ", x=" + x + ", y=" + y + ", hp="
				+ hp + ", mp=" + mp + ", mhp=" + mhp + ", mmp=" + mmp + ", atk=" + atk + ", def=" + def + ", mat=" + mat
				+ ", mdf=" + mdf + ", agi=" + agi + ", luk=" + luk + "]";
	}
    
}
