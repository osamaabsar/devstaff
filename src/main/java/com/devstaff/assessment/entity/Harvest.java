package com.devstaff.assessment.entity;

import jakarta.persistence.*;

@Entity
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Field field;

    @Enumerated(value = EnumType.STRING)
    private Season season;

    @ManyToOne
    private CropType cropType;

    private Double actualProductAmount;

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

    public CropType getCropType() {
        return cropType;
    }

    public void setCropType(CropType cropType) {
        this.cropType = cropType;
    }

    public Double getActualProductAmount() {
        return actualProductAmount;
    }

    public void setActualProductAmount(Double actualProductAmount) {
        this.actualProductAmount = actualProductAmount;
    }
}
