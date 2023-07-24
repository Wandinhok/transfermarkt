package edu.iff.bsi.transfermarkt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.iff.bsi.transfermarkt.entities.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

    @Query(value = "select u from Time", nativeQuery = true)
    Time findBynome(String nome);
    
}
