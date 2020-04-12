package esiea.api;

import com.esiea.tp4A.Direction;
import com.esiea.tp4A.Position;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;


public class LocalMapDTO {
	Set<Position> obstacles;
	List<OtherPlayer> players;
	
	public LocalMapDTO() {
		this.obstacles = new HashSet<Position>();
		this.players = new ArrayList<OtherPlayer>();
	}

	public Set<Position> getObstacles() {
		return obstacles;
	}

	public void setObstacles(Set<Position> obstacles) {
		this.obstacles = obstacles;
	}

	public List<OtherPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<OtherPlayer> players) {
		this.players = players;
	}
	
	
}
