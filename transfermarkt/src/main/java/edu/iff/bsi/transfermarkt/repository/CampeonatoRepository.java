package edu.iff.bsi.transfermarkt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.iff.bsi.transfermarkt.entities.Campeonato;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Long>{

    @Query(value = "select u from Campeonato u where.nome = ?1", nativeQuery = true)
    Campeonato findByNome(String nome);

    
}
