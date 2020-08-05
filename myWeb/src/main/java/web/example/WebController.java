package web.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/shortNews")
	public String shortNews() {
		return "shortNews";
	}
	
	@GetMapping("/longNews")
	public String longNews() {
		return "longNews";
	}
	
	@GetMapping("/lunch")
	public String lunch() {
		return "lunch";
	}
	
	@GetMapping("/garbage")
	public String garbage() {
		return "garbage";
	}
	
	@GetMapping("/subscribe")
	public String subscribe() {
		return "subscribe";
	}
	
	@GetMapping("/privacy")
	public String privacy() {
		return "privacy";
	}
	
	@GetMapping("/termsOfUse")
	public String termsOfUse() {
		return "termsOfUse";
	}
	
}
