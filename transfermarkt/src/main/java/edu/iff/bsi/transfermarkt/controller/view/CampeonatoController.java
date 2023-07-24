package edu.iff.bsi.transfermarkt.controller.view;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import edu.iff.bsi.transfermarkt.entities.Campeonato;

import edu.iff.bsi.transfermarkt.service.CampeonatoService;

@Controller

@RequestMapping(path = "/campeonatos")

public class CampeonatoController {

    @Autowired
    private CampeonatoService service;

    @GetMapping("/campeonato")
    public String cadastro(Model model) {

        model.addAttribute("campeonato", new Campeonato());

        return "formcampeonato";

    }

    @PostMapping("/campeonato")
    public String registerCampeonato(@ModelAttribute Campeonato newcampeonato, Model model) {

        service.save(newcampeonato);

        model.addAttribute("campeonato", new Campeonato());

        return "sucess";

    }

}