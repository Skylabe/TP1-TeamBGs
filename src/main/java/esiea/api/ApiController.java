package esiea.api;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import esiea.api.PlayerDTO;
import esiea.api.LocalMapDTO;
import esiea.api.ResponseDTO;
import com.esiea.tp4A.Position;


@RestController
public class ApiController {

	
	@RequestMapping("/co/{pseudo}")
	public ResponseDTO nouveauPerso(@PathVariable String pseudo) {
		RoverConfig.newPlayer(pseudo);
		PlayerDTO player = new PlayerDTO(pseudo);
		LocalMapDTO localMap = new LocalMapDTO(pseudo);
		ResponseDTO res = new ResponseDTO(player, localMap);
		
		
		return res;
	}
	
	@RequestMapping("status/{pseudo}")
	public ResponseDTO status(@PathVariable String pseudo) {
		for(int i = 0 ; i < RoverConfig.players.size() ; i++) {
			if(RoverConfig.players.get(i).getPseudo().equals(pseudo)) {
				PlayerDTO player = new PlayerDTO(RoverConfig.players.get(i).getPseudo(), RoverConfig.players.get(i).getRover());
				LocalMapDTO localMap = new LocalMapDTO(pseudo);
				ResponseDTO res = new ResponseDTO(player, localMap);
				
				return res;
			}
		}
		
		
		
		
		return null;
	}
	
	@RequestMapping("command/{pseudo}/{command}")
	public ResponseDTO move(@PathVariable String pseudo, @PathVariable String command){
		for(int i = 0 ; i < RoverConfig.players.size() ; i++) {
			if(RoverConfig.players.get(i).getPseudo().equals(pseudo)) {
				Position pos = RoverConfig.players.get(i).getRover().move(command, RoverConfig.planet);
				RoverConfig.players.get(i).getRover().setPosition(pos);
				
				PlayerDTO playerDto = new PlayerDTO(RoverConfig.players.get(i).getPseudo(), RoverConfig.players.get(i).getRover());
				LocalMapDTO localMap = new LocalMapDTO(pseudo);
				ResponseDTO res = new ResponseDTO(playerDto, localMap);
				return res;
			}
		}
		return null;
	}
}