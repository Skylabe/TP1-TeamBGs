package esiea.api;

import com.esiea.tp4A.MarsRoverImpl;

public class Pair {
	String pseudo;
	MarsRoverImpl rover;
	
	public Pair(String pseudo, MarsRoverImpl rover) {
		this.pseudo = pseudo;
		this.rover = rover;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public MarsRoverImpl getRover() {
		return rover;
	}

	public void setRover(MarsRoverImpl rover) {
		this.rover = rover;
	}
	
	
}
