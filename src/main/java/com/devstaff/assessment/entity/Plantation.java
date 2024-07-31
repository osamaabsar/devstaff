package com.devstaff.assessment.entity;

import jakarta.persistence.*;

@Entity
public class Plantation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Field field;

    @Enumerated(value = EnumType.STRING)
    private Season season;

    private Double plantingArea;

    @ManyToOne
    private CropType cropType;

    private Double expectedProductAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Double getPlantingArea() {
        return plantingArea;
    }

    public void setPlantingArea(Double plantingArea) {
        this.plantingArea = plantingArea;
    }

    public CropType getCropType() {
        return cropType;
    }

    public void setCropType(CropType cropType) {
        this.cropType = cropType;
    }

    public Double getExpectedProductAmount() {
        return expectedProductAmount;
    }

    public void setExpectedProductAmount(Double expectedProductAmount) {
        this.expectedProductAmount = expectedProductAmount;
    }
}
