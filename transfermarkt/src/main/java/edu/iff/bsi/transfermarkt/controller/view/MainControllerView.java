package edu.iff.bsi.transfermarkt.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.iff.bsi.transfermarkt.entities.User;


@Controller
@RequestMapping(path = "/home")
public class MainControllerView {


    @GetMapping("/")
    public String page()   {
        return "index";
    }

    @PostMapping("/new/user")
    public String registerUser(@ModelAttribute User newuser){
            System.out.println("User ID: " + newuser.getId());
            System.out.println("User username: " + newuser.getUsername());
            System.out.println("User password: " + newuser.getPassword());
            return "sucess";
    }


    
}
