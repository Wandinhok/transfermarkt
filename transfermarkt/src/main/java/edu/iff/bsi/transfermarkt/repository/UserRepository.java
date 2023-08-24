package edu.iff.bsi.transfermarkt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.iff.bsi.transfermarkt.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query(value = "SELECT u FROM User u WHERE u.id = :id")

    public Optional<User> findById(@Param("id") Long id);

 

    @Query(value = "SELECT * FROM User us. WHERE us.id = :id",

    nativeQuery = true )

    public List<User> findall();
 

}
