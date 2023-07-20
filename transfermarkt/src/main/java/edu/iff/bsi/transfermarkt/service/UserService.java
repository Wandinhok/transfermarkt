package edu.iff.bsi.transfermarkt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iff.bsi.transfermarkt.entities.User;
import edu.iff.bsi.transfermarkt.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

     public User save(User u) {
        
        return u;

     }
    
}
