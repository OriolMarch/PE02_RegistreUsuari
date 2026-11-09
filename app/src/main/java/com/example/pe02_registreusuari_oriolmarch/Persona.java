package com.example.pe02_registreusuari_oriolmarch;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nom;
    private String cognoms;
    private int edat;
    private boolean matriculat;

    public Persona(String nom, String cognoms, int edat, boolean matriculat) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
        this.matriculat = matriculat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public boolean isMatriculat() {
        return matriculat;
    }

    public void setMatriculat(boolean matriculat) {
        this.matriculat = matriculat;
    }
}
