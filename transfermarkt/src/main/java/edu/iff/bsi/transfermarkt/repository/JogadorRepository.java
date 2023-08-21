package edu.iff.bsi.transfermarkt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.iff.bsi.transfermarkt.entities.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository <Jogador, Long>{

    @Query(value = "SELECT * FROM Jogador", nativeQuery = true)
    public List<Jogador> findAll();
    
    @Query("SELECT j FROM Jogador j WHERE j.nome = :nome")
    public Optional<Jogador> findByNome(@Param("nome") String nome);
}
