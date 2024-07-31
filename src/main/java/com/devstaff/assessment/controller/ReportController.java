package com.devstaff.assessment.controller;

import com.devstaff.assessment.entity.Harvest;
import com.devstaff.assessment.entity.Season;
import com.devstaff.assessment.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    @GetMapping("/season/{season}")
    public ResponseEntity<String> reportForSeason(@PathVariable Season season){
        log.debug("Request to get report by season : {}", season);
        try {
            String reportString = reportService.getReportBySeason(season);
            return ResponseEntity.ok(reportString);
        } catch (Exception ex) {
            log.error("Error occurred in getting report by season : {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/field/{id}")
    public ResponseEntity<String> reportForField(@PathVariable Long id){
        log.debug("Request to get report by field : {}", id);
        try {
            String reportString = reportService.getReportByField(id);
            return ResponseEntity.ok(reportString);
        } catch (Exception ex) {
            log.error("Error occurred in getting report by field : {}", ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
