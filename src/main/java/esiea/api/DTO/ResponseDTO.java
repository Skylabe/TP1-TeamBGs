package esiea.api;

import esiea.api.PlayerDTO;
import esiea.api.LocalMapDTO;

public class ResponseDTO {
	PlayerDTO player;
	LocalMapDTO localMap;
	
	public ResponseDTO(PlayerDTO player, LocalMapDTO localMap) {
		this.player = player;
		this.localMap = localMap;
	}

	public PlayerDTO getPlayer() {
		return player;
	}

	public void setPlayer(PlayerDTO player) {
		this.player = player;
	}

	public LocalMapDTO getLocalMap() {
		return localMap;
	}

	public void setLocalMap(LocalMapDTO localMap) {
		this.localMap = localMap;
	}
	
	
}
