package com.devstaff.assessment.service;


import com.devstaff.assessment.entity.Farm;
import com.devstaff.assessment.repository.FarmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmService {

    private final Logger log = LoggerFactory.getLogger(FarmService.class);

    @Autowired
    private FarmRepository farmRepository;

    public Farm save(Farm farm) {
        log.debug("Request to save farm : {}", farm);
        return farmRepository.save(farm);
    }

    public Farm findById(Long id) {
        log.debug("Request to get farm by id : {}", id);
        Optional<Farm> farm =  farmRepository.findById(id);
        return farm.orElseGet(Farm::new);
    }

    public Farm findByName(String name) {
        log.debug("Request to get farm by name : {}", name);
        return farmRepository.findByName(name);
    }

    public List<Farm> findAll() {
        log.debug("Request to get all farm");
        return farmRepository.findAll();
    }
}
