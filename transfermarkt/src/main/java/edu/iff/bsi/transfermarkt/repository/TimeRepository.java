package edu.iff.bsi.transfermarkt.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.iff.bsi.transfermarkt.entities.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

    @Query(value = "SELECT * FROM Time t WHERE t.id = :id",

    nativeQuery = true )

    public List<Time> findall();

}
