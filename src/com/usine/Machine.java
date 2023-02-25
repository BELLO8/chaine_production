package com.usine;

import java.util.Random;

public class Machine {
    private String type_machine;
    private double temps_machine;
    private String etat_machine;
    private double temps_reparation;
    private double probabilité_panne_machine;

    public Machine(String type_machine, double temps_machine) {
        this.type_machine = type_machine;
        this.temps_machine = temps_machine;
        this.etat_machine = "en_marche";
        this.temps_reparation = 0;
        this.probabilité_panne_machine = 0;
    }

    public double getTemps_reparation() {
        return temps_reparation;
    }

    public double getProbabilité_panne_machine() {
        Random rand = new Random();
        this.probabilité_panne_machine = rand.nextDouble();
        return this.probabilité_panne_machine;
    }

    public void setTemps_reparation(double temps_reparation) {
        this.temps_reparation = temps_reparation;
    }

    public String getType_machine() {
        return type_machine;
    }

    public void setType_machine(String type_machine) {
        this.type_machine = type_machine;
    }

    public double getTemps_machine() {
        return temps_machine;
    }

    public void setTemps_machine(double temps_machine) {
        this.temps_machine = temps_machine;
    }

    public void setTemps(double temps_reparation) {
        this.temps_machine += temps_reparation;
    }

    public String getEtat_machine() {
        return etat_machine;
    }

    public void setEtat_machine(String etat_machine) {
        this.etat_machine = etat_machine;
    }

}
