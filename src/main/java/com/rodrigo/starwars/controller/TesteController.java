package com.rodrigo.starwars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TesteController {
	
		@RequestMapping(value="/planetas")
		@ResponseBody
	     String execute() {
        
        return "TESTANDO";
    
	}
}
