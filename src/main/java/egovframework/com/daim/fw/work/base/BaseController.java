package egovframework.com.daim.fw.work.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

	@GetMapping("/")
	public String def() {
		return "home";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}

}
