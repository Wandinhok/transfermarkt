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
         return repo.save(u);
     }

     public List<User> findAll() {

        return repo.findAll();

    }

 

    public User save(User u) {

        return repo.save(u);

    }

 

    public User findById(Long id) {

        Optional<User> result = repo.findById(id);

        return result.get();

    }

 

    public void delete(Long id) {

        User obj = findById(id);

        repo.delete(obj);

    }
     
    
}
