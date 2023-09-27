package edu.iff.bsi.transfermarkt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.iff.bsi.transfermarkt.entities.Time;

import edu.iff.bsi.transfermarkt.repository.TimeRepository;

@Service

public class TimeService {

    @Autowired
    private TimeRepository repo;

    public List<Time> findAll() {
        return repo.findAll();
    }


    public List<Time> findAll(int page, int size) {
        Pageable p = PageRequest.of(page, size);
        return repo.findAll(p).toList();
    }

    public Time findById(Long id) {
        Optional<Time> result = repo.findById(id);
        return result.get();
    }

    public Time save(Time t) {

        return repo.save(t);

    }

    public void delete(Long id) {
        Time obj = findById(id);
        repo.delete(obj);
    }

}