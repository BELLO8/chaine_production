package com.usine;

import java.util.Random;

//Cette classe est responsable de la reparation de la machine
public class ReparationMachine {

    //Cette fonction permet de reparer la machine.
    public void reparationMachine(Machine machine) {
        System.out.println("La machine est en reparation");
        machine.setEtat_machine("en_marche");
        Random rand = new Random();
        machine.setTemps_reparation(rand.nextInt(6));
        System.out.println("temps de reparation de la machine " + machine.getType_machine() + " est de :" + machine.getTemps_reparation() + " minutes");
    }

}
