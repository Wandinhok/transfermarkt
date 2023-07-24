package edu.iff.bsi.transfermarkt.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.iff.bsi.transfermarkt.entities.Time;
import edu.iff.bsi.transfermarkt.service.TimeService;

@Controller
@RequestMapping(path = "/times")
public class TimeController {

    @Autowired
    private TimeService service;

    @GetMapping("/time")
    public String cadastro(Model model) {

        model.addAttribute("user", new Time());
        return "formtime";

    }

    @PostMapping("/time")
    public String registerTime(@ModelAttribute Time newtime, Model model) {
        service.save(newtime);
        System.out.println("Time ID: " + newtime.getId());
        System.out.println("Time nome: " + newtime.getNome());
        System.out.println("Time pais: " + newtime.getPais());
        System.out.println("Time valor_mercado: " + newtime.getValor_mercado());
        System.out.println("Time valor_elenco: " + newtime.getValor_elenco());
        model.addAttribute("time", new Time());

        return "sucess";
    }

}
