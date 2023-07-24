package edu.iff.bsi.transfermarkt.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.iff.bsi.transfermarkt.entities.Time;

import edu.iff.bsi.transfermarkt.repository.TimeRepository;

@Service

public class TimeService {

    @Autowired

    private TimeRepository repo;

    public Time save(Time t) {

        return repo.save(t);

    }

}