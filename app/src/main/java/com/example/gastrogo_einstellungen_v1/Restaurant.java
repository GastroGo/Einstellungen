package com.example.gastrogo_einstellungen_v1;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private String id;

    public Restaurant() {
        // Default constructor required for calls to DataSnapshot.getValue(Restaurant.class)
    }

    public Restaurant(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}