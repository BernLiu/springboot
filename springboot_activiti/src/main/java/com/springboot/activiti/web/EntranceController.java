package com.springboot.activiti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntranceController {
   
	@GetMapping("/editor")
    public String test(){
        return "/modeler";
    }
}
