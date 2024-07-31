package com.devstaff.assessment.controller;

import com.devstaff.assessment.entity.Plantation;
import com.devstaff.assessment.service.PlantationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plantation")
public class PlantationController {

    private final Logger log = LoggerFactory.getLogger(PlantationController.class);

    @Autowired
    private PlantationService plantationService;

    @PostMapping("/save")
    public ResponseEntity<Plantation> savePlantation(@RequestBody Plantation plantation) {
        log.debug("Request to save plantation : {}", plantation);
        try {
            Plantation savedPlantation = plantationService.save(plantation);
            return ResponseEntity.ok(savedPlantation);
        } catch (Exception ex) {
            log.error("Error occurred in saving plantation : {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plantation> getPlantationById(@PathVariable Long id) {
        log.debug("Request to get plantation by id : {}", id);
        try {
            Plantation plantation = plantationService.findById(id);
            return ResponseEntity.ok(plantation);
        } catch (Exception ex) {
            log.error("Error occurred in getting plantation by id : {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
