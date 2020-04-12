package esiea.api;

import com.esiea.tp4A.Position;
import com.esiea.tp4A.Direction;
import com.esiea.tp4A.MarsRoverImpl;

public class PlayerDTO {
	String name;
	RoverStatusEnum status;
	Position position;
	int laserRange;
	
	public PlayerDTO(String pseudo) {
		this.name = pseudo;
		this.status = RoverStatusEnum.ALIVE;
		this.position = Position.of(0, 0, Direction.NORTH);
		this.laserRange = 3;
	}
	
	public PlayerDTO(String pseudo, MarsRoverImpl rover) {
		this.name = pseudo;
		this.status = RoverStatusEnum.ALIVE;
		this.position = rover.getPosition();
		this.laserRange = 3;
	}
	
	public String toString() {
		String txt = "";
		txt += "Name : " + name+ "\n";
		txt += "Status : " + status + "\n";
		txt += "Position : \n\tX : " + position.getX() + "\n";
		txt += "\tY : " + position.getY() + "\n";
		txt += "Range laser : " + laserRange + "\n";
		return txt;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoverStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RoverStatusEnum status) {
		this.status = status;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getLaserRange() {
		return laserRange;
	}

	public void setLaserRange(int laserRange) {
		this.laserRange = laserRange;
	}
	
	
	

}
