package com.example.demo.models;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class NearEarthObject {
    private NearEarthObjectLinks links;
    private String id;
    private String neoReferenceID;
    private String name;
    private String nasaJplURL;
    private double absoluteMagnitudeH;
    private EstimatedDiameter estimatedDiameter;
    private boolean isPotentiallyHazardousAsteroid;
    private List<CloseApproachDatum> closeApproachData;
    private boolean isSentryObject;

    @JsonProperty("links")
    public NearEarthObjectLinks getLinks() { return links; }
    @JsonProperty("links")
    public void setLinks(NearEarthObjectLinks value) { this.links = value; }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("neo_reference_id")
    public String getNeoReferenceID() { return neoReferenceID; }
    @JsonProperty("neo_reference_id")
    public void setNeoReferenceID(String value) { this.neoReferenceID = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("nasa_jpl_url")
    public String getNasaJplURL() { return nasaJplURL; }
    @JsonProperty("nasa_jpl_url")
    public void setNasaJplURL(String value) { this.nasaJplURL = value; }

    @JsonProperty("absolute_magnitude_h")
    public double getAbsoluteMagnitudeH() { return absoluteMagnitudeH; }
    @JsonProperty("absolute_magnitude_h")
    public void setAbsoluteMagnitudeH(double value) { this.absoluteMagnitudeH = value; }

    @JsonProperty("estimated_diameter")
    public EstimatedDiameter getEstimatedDiameter() { return estimatedDiameter; }
    @JsonProperty("estimated_diameter")
    public void setEstimatedDiameter(EstimatedDiameter value) { this.estimatedDiameter = value; }

    @JsonProperty("is_potentially_hazardous_asteroid")
    public boolean getIsPotentiallyHazardousAsteroid() { return isPotentiallyHazardousAsteroid; }
    @JsonProperty("is_potentially_hazardous_asteroid")
    public void setIsPotentiallyHazardousAsteroid(boolean value) { this.isPotentiallyHazardousAsteroid = value; }

    @JsonProperty("close_approach_data")
    public List<CloseApproachDatum> getCloseApproachData() { return closeApproachData; }
    @JsonProperty("close_approach_data")
    public void setCloseApproachData(List<CloseApproachDatum> value) { this.closeApproachData = value; }

    @JsonProperty("is_sentry_object")
    public boolean getIsSentryObject() { return isSentryObject; }
    @JsonProperty("is_sentry_object")
    public void setIsSentryObject(boolean value) { this.isSentryObject = value; }
}
