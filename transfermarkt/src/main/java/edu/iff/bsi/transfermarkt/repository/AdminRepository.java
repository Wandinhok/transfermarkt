package edu.iff.bsi.transfermarkt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.iff.bsi.transfermarkt.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    
    @Query(value = "SELECT a FROM Admin a WHERE a.id = :id")
    public Optional<Admin> findById(@Param("id") Long id);

    @Query(value = "SELECT * FROM Admin a. WHERE a.id = :id", 
    nativeQuery = true )
    public List<Admin> findall();

    
}