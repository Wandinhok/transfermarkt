package edu.iff.bsi.transfermarkt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.iff.bsi.transfermarkt.entities.Time;
import edu.iff.bsi.transfermarkt.entities.User;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

    @Query(value = "select u from Time u where.nome = ?1", nativeQuery = true)
    User findBynome(String nome);
    
}
