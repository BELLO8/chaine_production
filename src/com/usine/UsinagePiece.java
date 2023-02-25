package com.usine;

import java.util.Random;

//Cette classe est responsable de l'usinage des pieces
public class UsinagePiece {

    public void usinagePiece(Piece piece, Machine machine) {

        //Initialisation des classe permettant de faire la verification et la reparation de la machine
        VerificationMachine verification_Machine = new VerificationMachine();
        ReparationMachine reparation_Machine = new ReparationMachine();

        //Verification de l'état de la machine si elle est en panne ou pas
        if(verification_Machine.verificationEtatMachine(machine) == false) {
            //si oui nous reparons la machine
            reparation_Machine.reparationMachine(machine);
        }
        //Apres avoir reparé la machine l'état de la machine change et passe à "en_marche"
        machine.setEtat_machine("en_macher");

        //Usinage de la piece en augmentant la qualité de la piece
        piece.setNiveau_qualité_piece(1);

        //On enregistrer le temps d'usinage de la pieces
        machine.setTemps(machine.getTemps_reparation());

        //On affiche le temps d'usinage
        System.out.println("le temps d\'usinage de la pièce : " + piece.getType_piece() + " = " + machine.getTemps_machine() + " minutes");
    }


}
