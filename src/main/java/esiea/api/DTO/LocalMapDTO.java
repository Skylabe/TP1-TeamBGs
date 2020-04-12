package esiea.api;

import com.esiea.tp4A.Direction;
import com.esiea.tp4A.Position;

import esiea.api.RoverConfig;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;


public class LocalMapDTO {
	Set<Position> obstacles;
	List<OtherPlayer> players;
	
	public LocalMapDTO(String pseudo) {
		this.obstacles = RoverConfig.planet.obstaclePositions();
		this.players = new ArrayList<OtherPlayer>();
		for(Pair player : RoverConfig.players) {
			
			if(!player.pseudo.equals(pseudo)) {
				this.players.add(new OtherPlayer(new PlayerDTO(player.pseudo, player.rover)));
			}
		}
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
