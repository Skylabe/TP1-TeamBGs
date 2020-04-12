package esiea.api;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import esiea.api.PlayerDTO;
import esiea.api.LocalMapDTO;
import esiea.api.ResponseDTO;

@RestController
public class ApiController {

	@RequestMapping("/test")
	public String index() {
		return "API En Route";
	}
	
	@RequestMapping("/co/{pseudo}")
	public ResponseDTO nouveauPerso(@PathVariable String pseudo) {
		RoverConfig.newPlayer(pseudo);
		PlayerDTO player = new PlayerDTO(pseudo);
		LocalMapDTO localMap = new LocalMapDTO(pseudo);
		ResponseDTO res = new ResponseDTO(player, localMap);
		
		
		return res;
	}

}