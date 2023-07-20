package edu.iff.bsi.transfermarkt.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.iff.bsi.transfermarkt.entities.User;
import edu.iff.bsi.transfermarkt.service.UserService;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user")
    public String cadastro(Model model) {
        model.addAttribute("user", new User(1, null, null));
        return "index";
    }

    @PostMapping("/user")
    public String registerUser(@ModelAttribute User newuser, Model model) {
        System.out.println("User ID: " + newuser.getId());
        System.out.println("User username: " + newuser.getUsername());
        System.out.println("User password: " + newuser.getPassword());
        model.addAttribute("user", new User(1, null, null));
        return "sucess";
    }

}
