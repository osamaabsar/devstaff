package com.devstaff.assessment.service;

import com.devstaff.assessment.entity.Field;
import com.devstaff.assessment.entity.Harvest;
import com.devstaff.assessment.entity.Plantation;
import com.devstaff.assessment.entity.Season;
import com.devstaff.assessment.repository.FieldRepository;
import com.devstaff.assessment.repository.HarvestRepository;
import com.devstaff.assessment.repository.PlantationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private PlantationRepository plantationRepository;

    @Autowired
    private HarvestRepository harvestRepository;

    @Autowired
    private FieldRepository fieldRepository;

    public String getReportBySeason(Season season){

        List<Plantation> plantationList = plantationRepository.getPlantationBySeason(season);
        List<Harvest> harvestList = harvestRepository.getHarvestBySeason(season);
        double actualAmount = harvestList.stream().mapToDouble(Harvest::getActualProductAmount).sum();
        double expectedAmount = plantationList.stream().mapToDouble(Plantation::getExpectedProductAmount).sum();
        StringBuilder report = new StringBuilder();
        report.append("Season : " + season + " --- ");
        report.append("Expected Amount From Plantation : " + expectedAmount + " --- ");
        report.append("Actual Amount Harvested : " + actualAmount);
        return report.toString();
    }

    public String getReportByField(Long id){
        Field field = fieldRepository.getFieldById(id);
        List<Plantation> plantationList = plantationRepository.getPlantationByField(id);
        List<Harvest> harvestList = harvestRepository.getHarvestByField(id);
        double actualAmount = harvestList.stream().mapToDouble(Harvest::getActualProductAmount).sum();
        double expectedAmount = plantationList.stream().mapToDouble(Plantation::getExpectedProductAmount).sum();
        StringBuilder report = new StringBuilder();
        report.append("In Field : " + field.getName() + " --- ");
        report.append("Expected Amount From Plantation : " + expectedAmount + " --- ");
        report.append("Actual Amount Harvested : " + actualAmount + " in tons");
        return report.toString();
    }

}
