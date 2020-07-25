package web.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("index/shortNews")
	public String shortNews() {
		return "shortNews";
	}
}
