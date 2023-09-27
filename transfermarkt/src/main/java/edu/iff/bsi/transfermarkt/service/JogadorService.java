package edu.iff.bsi.transfermarkt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.iff.bsi.transfermarkt.entities.Jogador;
import edu.iff.bsi.transfermarkt.repository.JogadorRepository;

@Service
public class JogadorService {

  @Autowired
  private JogadorRepository repo;

  public List<Jogador> findAll() {
    return repo.findAll();
  }

  public List<Jogador> findAll(int page, int size) {
    Pageable p = PageRequest.of(page, size);
    return repo.findAll(p).toList();
  }

  public Jogador save(Jogador j) {
    return repo.save(j);
  }

  public Jogador findById(Long id) {
    Optional<Jogador> result = repo.findById(id);
    return result.get();
  }

  public Jogador update(Jogador j) {
     findById(j.getId());
     return repo.save(j);
  } 

  public void delete(Long id) {
    Jogador obj = findById(id);
    repo.delete(obj);
  }


  


}
