package edu.iff.bsi.transfermarkt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.iff.bsi.transfermarkt.entities.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository <Jogador, Long>{

    @Query(value = "SELECT * FROM Jogador", nativeQuery = true)
    Jogador findByNome (String nome);
    
}
