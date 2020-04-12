package esiea.api;

public class OtherPlayer {
	String name;
	int x;
	int y;
	
	public OtherPlayer(PlayerDTO joueur) {
		fillwith(joueur);
	}
	
	public void fillwith(PlayerDTO mapping) {
		this.name = mapping.getName();
		this.x = mapping.getPosition().getX();
		this.y = mapping.getPosition().getY();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
