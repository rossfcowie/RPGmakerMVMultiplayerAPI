package arcane.rpgapi.dto;


public class MovementDTO {
    private long id;
    private String username;
    private int mapID;
    private int x;
    private int y;

    
	
	
	public MovementDTO(long id, String username, int mapID, int x, int y) {
		super();
		this.id = id;
		this.username = username;
		this.mapID = mapID;
		this.x = x;
		this.y = y;

	}


	public MovementDTO() {
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + mapID;
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
		MovementDTO other = (MovementDTO) obj;
		if (id != other.id)
			return false;
		if (mapID != other.mapID)
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
		return "MovementDTO [id=" + id + ", username=" + username + ", mapID=" + mapID + ", x=" + x + ", y=" + y + "]";
	}


}
