package com.usine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void triage_piece(List<Piece> carton_pieces, Piece tête, Piece jupe, Piece axe ) {
        for(Piece carton: carton_pieces) {
            if(carton.getType_piece().equals("Tête")) {
                tête.setType_piece(carton.getType_piece());
                tête.setNiveau_qualité_piece(carton.getNiveau_qualité_piece());
            }else if(carton.getType_piece().equals("Jupe")) {
                jupe.setType_piece(carton.getType_piece());
                jupe.setNiveau_qualité_piece(carton.getNiveau_qualité_piece());
            }else if(carton.getType_piece().equals("Axe")) {
                axe.setType_piece(carton.getType_piece());
                axe.setNiveau_qualité_piece(carton.getNiveau_qualité_piece());
            }else {
                System.out.println("pas de pieces");
            }
        }
    }

    public void assemblage_pieces(List<Machine> machines,ReparationMachine reparation,UsinagePiece usine, double temps_machine_MT,double temps_machine_MJ, double temps_machine_MA, Piece tête, Piece jupe, Piece axe) {
        for(Machine machine: machines) {
            if(machine.getType_machine().equals("MT")) {
                //verification de la machine afin de savoir si elle est en panne si c'est le cas on la répare
                if(machine.getProbabilité_panne_machine() < 0.25) {
                    machine.setEtat_machine("en_panne");
                    reparation.reparationMachine(machine);
                    usine.usinagePiece(tête,machine);
                    temps_machine_MT += machine.getTemps_machine();
                    System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MT);
                }else{
                    machine.setEtat_machine("en_marche");
                    usine.usinagePiece(tête,machine);
                    temps_machine_MT += machine.getTemps_machine();
                    System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MT);
                }
            }else if(machine.getType_machine().equals("MJ")) {
                if(machine.getProbabilité_panne_machine() < 0.25) {
                    machine.setEtat_machine("en_panne");
                    reparation.reparationMachine(machine);
                    usine.usinagePiece(jupe,machine);
                    temps_machine_MJ += machine.getTemps_machine();
                    System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MJ);
                }else{
                    machine.setEtat_machine("en_marche");
                    usine.usinagePiece(jupe,machine);
                    temps_machine_MJ += machine.getTemps_machine();
                    System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MJ);
                }
            }else if(machine.getType_machine().equals("MA")){
                if(machine.getProbabilité_panne_machine() < 0.25) {
                    machine.setEtat_machine("en_panne");
                    reparation.reparationMachine(machine);
                    usine.usinagePiece(axe,machine);
                    temps_machine_MA += machine.getTemps_machine();
                    System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MA);
                }else{
                    machine.setEtat_machine("en_marche");
                    usine.usinagePiece(axe,machine);
                    temps_machine_MA += machine.getTemps_machine();
                    System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MA);
                }
            }
        }

    }

    public static void main(String[] args) {

        //Initialisation des cartons contenant les pieces mélangées
        List<Piece> carton_pieces = new ArrayList<>();

        //Initialisation de la liste des pistons assemblés
        List<Piece> piston = new ArrayList<>();

        //Déclaration des classes responsablent de la réparation et de l'usinage des pieces .
        ReparationMachine reparation = new ReparationMachine();
        UsinagePiece usine = new UsinagePiece();

        //Initialisation des machines
        Machine machine_Tete = new Machine("MT",2);
        Machine machine_Jupe = new Machine("MJ",3);
        Machine machine_Axe = new Machine("MA",2.5);
        Machine machine_Principale = new Machine("MP",1);

        //Initialisation de la liste des machines
        List<Machine> machines = new ArrayList<>();

        //Ajout des machines dans la liste
        machines.add(machine_Tete);
        machines.add(machine_Jupe);
        machines.add(machine_Axe);

        //Initialisation des differents temps
        double temps_total = 0 ;
        double temps_machine_MP = 0 ;
        double temps_machine_MT = 0 ;
        double temps_machine_MJ = 0 ;
        double temps_machine_MA = 0 ;

        //Utilisation de la boucle while pour simuler l'assemblage jusqu'a avoir 100 pistons
        while (piston.size() < 100) {
            //Ajout des pieces dans un carton qu'on melange en suite avec la fonction shuffle
            carton_pieces.add(new Piece("Tête",0));
            carton_pieces.add(new Piece("Jupe",0));
            carton_pieces.add(new Piece("Axe",0));

            //Melange des pieces dans le carton
            Collections.shuffle(carton_pieces);

            //en suit on faire un triage des pieces et une vérification de l'etat des machines
            Piece tête = new Piece();
            Piece jupe = new Piece();
            Piece axe = new Piece();

            //triage des pieces
            triage_piece(carton_pieces,tête,jupe,axe);

           //usinage de chaque pieces dans leur machine respective
           for(Machine machine: machines) {
               if(machine.getType_machine().equals("MT")) {
                   //verification de la machine afin de savoir si elle est en panne si c'est le cas on la répare
                   if(machine.getProbabilité_panne_machine() < 0.25) {
                       machine.setEtat_machine("en_panne");
                       reparation.reparationMachine(machine);
                       usine.usinagePiece(tête,machine);
                       temps_machine_MT += machine.getTemps_machine();
                       System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MT);
                   }else{
                       machine.setEtat_machine("en_marche");
                       usine.usinagePiece(tête,machine);
                       temps_machine_MT += machine.getTemps_machine();
                       System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MT);
                   }
               }else if(machine.getType_machine().equals("MJ")) {
                   if(machine.getProbabilité_panne_machine() < 0.25) {
                       machine.setEtat_machine("en_panne");
                       reparation.reparationMachine(machine);
                       usine.usinagePiece(jupe,machine);
                       temps_machine_MJ += machine.getTemps_machine();
                       System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MJ);
                   }else{
                       machine.setEtat_machine("en_marche");
                       usine.usinagePiece(jupe,machine);
                       temps_machine_MJ += machine.getTemps_machine();
                       System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MJ);
                   }
               }else if(machine.getType_machine().equals("MA")){
                   if(machine.getProbabilité_panne_machine() < 0.25) {
                       machine.setEtat_machine("en_panne");
                       reparation.reparationMachine(machine);
                       usine.usinagePiece(axe,machine);
                       temps_machine_MA += machine.getTemps_machine();
                       System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MA);
                   }else{
                       machine.setEtat_machine("en_marche");
                       usine.usinagePiece(axe,machine);
                       temps_machine_MA += machine.getTemps_machine();
                       System.out.println("temps de usinage de la machine " + machine.getType_machine() + " est de " + temps_machine_MA);
                   }
               }
           }

           List<Double> Temps_liste = new ArrayList<>();

           Temps_liste.add(temps_machine_MT);
           Temps_liste.add(temps_machine_MJ);
           Temps_liste.add(temps_machine_MA);

           double temp_max = Collections.max(Temps_liste);
           System.out.println("le temps d\' usinage est de : " + temp_max + " minutes");

           //passons maintenant à l'assemblage des pieces dans la machine principale
            //nous verifions si la machine principale est en panne
            if(machine_Principale.getProbabilité_panne_machine() < 0.75){
                //reparation de la machine et on enregistre le temps de panne
                reparation.reparationMachine(machine_Principale);
                temps_machine_MP += machine_Principale.getTemps_machine();
            }

            piston.add(tête);
            piston.add(jupe);
            piston.add(axe);

            temps_total = temp_max + temps_machine_MP;
            System.out.println("le temps necessaire de l'assemblage des 100 pistons est de " + temps_total);

        }

    }
}
