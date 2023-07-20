package edu.iff.bsi.transfermarkt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iff.bsi.transfermarkt.entities.Jogador;
import edu.iff.bsi.transfermarkt.repository.JogadorRepository;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository repo;

    public Jogador save(Jogador j) {
      return repo.save(j);
    }

}
