package arcane.rpgapi.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import arcane.rpgapi.dto.PlayerDTO;

@Entity
public class Player {

	public Player(PlayerDTO playerDto) {
		this.id = playerDto.getId();
		this.mapID = playerDto.getMapID();
		this.username = playerDto.getUsername();
		this.x = playerDto.getX();
		this.y = playerDto.getY();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	
	
	private String username;

	private int mapID;

	private int x;

	private int y;

	public Player() {

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
