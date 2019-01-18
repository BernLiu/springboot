package com.springboot.activiti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/activitis")
public class EntranceController {
   
	@GetMapping("/editor")
    public String test(){
        return "/modeler";
    }
}
