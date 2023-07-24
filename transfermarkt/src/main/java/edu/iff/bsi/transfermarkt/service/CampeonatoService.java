package edu.iff.bsi.transfermarkt.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.iff.bsi.transfermarkt.entities.Campeonato;

import edu.iff.bsi.transfermarkt.repository.CampeonatoRepository;

@Service

public class CampeonatoService {

    @Autowired

    private CampeonatoRepository repo;

    public Campeonato save(Campeonato c) {

        return repo.save(c);

    }

}