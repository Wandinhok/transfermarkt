package edu.iff.bsi.transfermarkt.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.iff.bsi.transfermarkt.entities.Jogador;
import edu.iff.bsi.transfermarkt.service.JogadorService;

@Controller
@RequestMapping(path = "/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService service;

    @GetMapping("/jogador")
    public String cadastro(Model model) {
        model.addAttribute("jogador", new Jogador());
        return "formJogador";
    }

    @PostMapping("/jogador")
    public String registerJogador(@ModelAttribute Jogador newjogador, Model model) {
        service.save(newjogador);
        System.out.println("Jogador id: " + newjogador.getId());
        System.out.println("Jogador nome: " + newjogador.getNome());
        System.out.println("Jogador pais: " + newjogador.getPais());
        System.out.println("Jogador data_nascimento: " + newjogador.getData_nascimento());
        System.out.println("Jogador gols: " + newjogador.getGols());
        System.out.println("Jogador assistencia: " + newjogador.getAssistencia());
        System.out.println("Jogador valor_mercado: " + newjogador.getValor_mercado());
        model.addAttribute("jogador", new Jogador());

        return "sucess";

    }

}
