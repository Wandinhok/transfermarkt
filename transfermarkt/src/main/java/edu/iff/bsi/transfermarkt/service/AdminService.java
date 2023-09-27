package edu.iff.bsi.transfermarkt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iff.bsi.transfermarkt.entities.Admin;
import edu.iff.bsi.transfermarkt.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public List<Admin> findAll() {
        return repo.findAll();
    }

    public Admin save(Admin a) {
        return repo.save(a);
    }

    public Admin findById(Long id) {
        Optional<Admin> result = repo.findById(id);
        return result.get();
    }

    public void delete(Long id) {
        Admin obj = findById(id);
        repo.delete(obj);
    }

}
