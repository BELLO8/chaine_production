package com.usine;

import java.util.Random;

//Cette classe est responsable de l'usinage des pieces
public class UsinagePiece {

    public void usinagePiece(Piece piece, Machine machine) {
        VerificationMachine verification_Machine = new VerificationMachine();
        ReparationMachine reparation_Machine = new ReparationMachine();
        if(verification_Machine.verificationEtatMachine(machine) == false) {
            reparation_Machine.reparationMachine(machine);
        }
        machine.setEtat_machine("en_macher");
        piece.setNiveau_qualité_piece(1);
        machine.setTemps(machine.getTemps_reparation());
        System.out.println("le temps d\'usinage de la pièce : " + piece.getType_piece() + " = " + machine.getTemps_machine() + " minutes");
    }


}
