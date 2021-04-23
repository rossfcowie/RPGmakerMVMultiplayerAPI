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


}
