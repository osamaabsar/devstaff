package com.devstaff.assessment.service;

import com.devstaff.assessment.entity.Harvest;
import com.devstaff.assessment.entity.Plantation;
import com.devstaff.assessment.repository.HarvestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HarvestService {

    private final Logger log = LoggerFactory.getLogger(HarvestService.class);

    @Autowired
    private HarvestRepository harvestRepository;

    public Harvest save(Harvest harvest) {
        log.debug("Request to save harvest : {}", harvest);
        return harvestRepository.save(harvest);
    }

    public Harvest findById(Long id) {
        log.debug("Request to get harvest by id : {}", id);
        Optional<Harvest> harvest =  harvestRepository.findById(id);
        return harvest.orElseGet(Harvest::new);
    }
}
