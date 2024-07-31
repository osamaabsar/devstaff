package com.devstaff.assessment.controller;

import com.devstaff.assessment.entity.Harvest;
import com.devstaff.assessment.service.HarvestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/harvest")
public class HarvestController {

    private final Logger log = LoggerFactory.getLogger(HarvestController.class);

    @Autowired
    private HarvestService harvestService;

    @PostMapping("/save")
    public ResponseEntity<Harvest> saveHarvest(@RequestBody Harvest harvest) {
        log.debug("Request to save harvest : {}", harvest);
        try {
            Harvest savedHarvest = harvestService.save(harvest);
            return ResponseEntity.ok(savedHarvest);
        } catch (Exception ex) {
            log.error("Error occurred in saving harvest : {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Harvest> getHarvestById(@PathVariable Long id) {
        log.debug("Request to get harvest by id : {}", id);
        try {
            Harvest harvest = harvestService.findById(id);
            return ResponseEntity.ok(harvest);
        } catch (Exception ex) {
            log.error("Error occurred in getting harvest by id : {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
