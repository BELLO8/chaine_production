package com.usine;

//Cette classe est responsable de la verification de l'état de la machine.
public class VerificationMachine {

    //Cette fonction permet de verifier si une machine est tombé en panne.
    public boolean verificationEtatMachine(Machine machine) {
        if(machine.getEtat_machine() == "en_panne") {
            System.out.println("la machine est en panne");
            return false;
        }else {
            machine.setEtat_machine("en_marche");
            System.out.println("la machine est en bon etat");
            return true;
        }
    }

}
