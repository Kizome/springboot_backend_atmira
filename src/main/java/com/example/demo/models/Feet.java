package com.example.demo.models;

import com.fasterxml.jackson.annotation.*;

public class Feet {
    private double estimatedDiameterMin;
    private double estimatedDiameterMax;

    @JsonProperty("estimated_diameter_min")
    public double getEstimatedDiameterMin() { return estimatedDiameterMin; }
    @JsonProperty("estimated_diameter_min")
    public void setEstimatedDiameterMin(double value) { this.estimatedDiameterMin = value; }

    @JsonProperty("estimated_diameter_max")
    public double getEstimatedDiameterMax() { return estimatedDiameterMax; }
    @JsonProperty("estimated_diameter_max")
    public void setEstimatedDiameterMax(double value) { this.estimatedDiameterMax = value; }
}
