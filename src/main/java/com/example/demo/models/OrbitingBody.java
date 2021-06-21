package com.example.demo.models;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum OrbitingBody {
    EARTH;

    @JsonValue
    public String toValue() {
        switch (this) {
            case EARTH: return "Earth";
        }
        return null;
    }

    @JsonCreator
    public static OrbitingBody forValue(String value) throws IOException {
        if (value.equals("Earth")) return EARTH;
        throw new IOException("Cannot deserialize OrbitingBody");
    }
}
