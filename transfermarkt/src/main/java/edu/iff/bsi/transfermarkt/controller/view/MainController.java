package edu.iff.bsi.transfermarkt.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    

    
}
