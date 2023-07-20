package edu.iff.bsi.transfermarkt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.iff.bsi.transfermarkt.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query(value = "select u from User u where.username = ?1", nativeQuery = true)
    User findByusername(String username);

}
