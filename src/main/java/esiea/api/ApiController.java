package esiea.api;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ApiController {

	@RequestMapping("/test")
	public String index() {
		return "API En Route";
	}

}