package com.example.demo.models;

import com.fasterxml.jackson.annotation.*;

public class NearEarthObjectLinks {
    private String self;

    @JsonProperty("self")
    public String getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(String value) { this.self = value; }
}
