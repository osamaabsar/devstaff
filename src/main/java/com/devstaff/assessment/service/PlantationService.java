package com.devstaff.assessment.service;

import com.devstaff.assessment.entity.Field;
import com.devstaff.assessment.entity.Plantation;
import com.devstaff.assessment.repository.PlantationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlantationService {

    private final Logger log = LoggerFactory.getLogger(PlantationService.class);

    @Autowired
    private PlantationRepository plantationRepository;

    public Plantation save(Plantation plantation) {
        log.debug("Request to save plantation : {}", plantation);
        return plantationRepository.save(plantation);
    }

    public Plantation findById(Long id) {
        log.debug("Request to get plantation by id : {}", id);
        Optional<Plantation> plantation =  plantationRepository.findById(id);
        return plantation.orElseGet(Plantation::new);
    }
}
