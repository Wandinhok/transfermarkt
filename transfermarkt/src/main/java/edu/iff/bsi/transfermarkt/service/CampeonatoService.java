package edu.iff.bsi.transfermarkt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import edu.iff.bsi.transfermarkt.entities.Campeonato;
import edu.iff.bsi.transfermarkt.repository.CampeonatoRepository;

@Service

public class CampeonatoService {

    @Autowired

    private CampeonatoRepository repo;

    public List<Campeonato> findAll() {
        return repo.findAll();
    }

    public List<Campeonato> findAll(int page, int size) {
        Pageable p = PageRequest.of(page, size);
        return repo.findAll(p).toList();
    }

    public Campeonato save(Campeonato c) {

        return repo.save(c);

    }

    public Campeonato findById(Long id) {
        Optional<Campeonato> result = repo.findById(id);
        return result.get();
    }

    public void delete(Long id) {
        Campeonato obj = findById(id);
        repo.delete(obj);
    }

}