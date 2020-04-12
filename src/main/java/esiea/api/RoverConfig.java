package esiea.api;

import java.util.ArrayList;
import java.util.List;

import com.esiea.tp4A.MarsRoverImpl;
import com.esiea.tp4A.PlanetMapImpl;
import com.esiea.tp4A.Direction;

public class RoverConfig {
	public static List<Pair> players = new ArrayList<Pair>();
	public static PlanetMapImpl planet;

	public static void newPlayer(String nom) {
		MarsRoverImpl rover = new MarsRoverImpl(0, 0, Direction.NORTH, planet, 3);
		RoverConfig.players.add(new Pair(nom, rover));
	}
}
