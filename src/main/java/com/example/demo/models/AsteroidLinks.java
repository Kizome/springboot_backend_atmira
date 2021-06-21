package com.example.demo.models;

import com.fasterxml.jackson.annotation.*;

public class AsteroidLinks {
    private String next;
    private String prev;
    private String self;

    @JsonProperty("next")
    public String getNext() { return next; }
    @JsonProperty("next")
    public void setNext(String value) { this.next = value; }

    @JsonProperty("prev")
    public String getPrev() { return prev; }
    @JsonProperty("prev")
    public void setPrev(String value) { this.prev = value; }

    @JsonProperty("self")
    public String getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(String value) { this.self = value; }
}
