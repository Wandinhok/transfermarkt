package edu.iff.bsi.transfermarkt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.iff.bsi.transfermarkt.entities.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository <Jogador, Long>{
  
    @Query(value = "SELECT * FROM Jogador j WHERE j.id = :id", 
    nativeQuery = true )
    public List<Jogador> findall();

    @Query("SELECT j FROM Jogador j WHERE j.id = :id")
    Jogador findById(long id);
    
}
