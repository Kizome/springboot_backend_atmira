package com.example.demo.models;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class CloseApproachDatum {
    private LocalDate closeApproachDate;
    private String closeApproachDateFull;
    private long epochDateCloseApproach;
    private RelativeVelocity relativeVelocity;
    private MissDistance missDistance;
    private OrbitingBody orbitingBody;

    @JsonProperty("close_approach_date")
    public LocalDate getCloseApproachDate() { return closeApproachDate; }
    @JsonProperty("close_approach_date")
    public void setCloseApproachDate(LocalDate value) { this.closeApproachDate = value; }

    @JsonProperty("close_approach_date_full")
    public String getCloseApproachDateFull() { return closeApproachDateFull; }
    @JsonProperty("close_approach_date_full")
    public void setCloseApproachDateFull(String value) { this.closeApproachDateFull = value; }

    @JsonProperty("epoch_date_close_approach")
    public long getEpochDateCloseApproach() { return epochDateCloseApproach; }
    @JsonProperty("epoch_date_close_approach")
    public void setEpochDateCloseApproach(long value) { this.epochDateCloseApproach = value; }

    @JsonProperty("relative_velocity")
    public RelativeVelocity getRelativeVelocity() { return relativeVelocity; }
    @JsonProperty("relative_velocity")
    public void setRelativeVelocity(RelativeVelocity value) { this.relativeVelocity = value; }

    @JsonProperty("miss_distance")
    public MissDistance getMissDistance() { return missDistance; }
    @JsonProperty("miss_distance")
    public void setMissDistance(MissDistance value) { this.missDistance = value; }

    @JsonProperty("orbiting_body")
    public OrbitingBody getOrbitingBody() { return orbitingBody; }
    @JsonProperty("orbiting_body")
    public void setOrbitingBody(OrbitingBody value) { this.orbitingBody = value; }
}
