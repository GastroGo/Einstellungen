package com.example.gastrogo_einstellungen_v1;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private String id, Name, Ort, Strasse;
    private int Hausnr, Plz;
    private boolean Speisekarte;

    public Restaurant() {
        // Default constructor required for calls to DataSnapshot.getValue(Restaurant.class)
    }

    public Restaurant(String id, int Hausnr, String Name, String Ort, int Plz, boolean Speisekarte, String Strasse) {
        this.id = id;
        this.Hausnr = Hausnr;
        this.Name = Name;
        this.Ort = Ort;
        this.Plz = Plz;
        this.Speisekarte = Speisekarte;
        this.Strasse = Strasse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHausnr() {
        return Hausnr;
    }

    public String getName() {
        return Name;
    }

    public String getOrt() {
        return Ort;
    }

    public int getPlz() {
        return Plz;
    }

    public boolean isSpeisekarte() {
        return Speisekarte;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setHausnr(int hausnr) {
        this.Hausnr = hausnr;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setOrt(String ort) {
        this.Ort = ort;
    }

    public void setPlz(int plz) {
        this.Plz = plz;
    }

    public void setSpeisekarte(boolean speisekarte) {
        this.Speisekarte = speisekarte;
    }

    public void setStrasse(String strasse) {
        this.Strasse = strasse;
    }

}