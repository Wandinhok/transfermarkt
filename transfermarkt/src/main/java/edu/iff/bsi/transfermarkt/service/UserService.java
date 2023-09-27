package edu.iff.bsi.transfermarkt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iff.bsi.transfermarkt.entities.User;
import edu.iff.bsi.transfermarkt.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

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
