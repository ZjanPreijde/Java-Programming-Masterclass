package com.masterclass;

public class Main {

    public static void main(String[] args) {
	    League<SoccerTeam> soccerLeague = new League<>("Eredivisie");

	    SoccerTeam ajax = new SoccerTeam("Ajax", 1);
        SoccerTeam az = new SoccerTeam("AZ", 4);
        SoccerTeam feyenoord = new SoccerTeam("Feyenoord", 3);
        SoccerTeam psv = new SoccerTeam("PSV", 2);

        soccerLeague.addTeam( ajax );
        soccerLeague.addTeam( az );
        soccerLeague.addTeam( feyenoord );
        soccerLeague.addTeam( psv );

        // second add, should fail
        soccerLeague.addTeam( ajax );

//        DartsTeam darters = new DartsTeam("Darters", 0);
//        soccerLeague.addTeam( darters );

        System.out.println("\nTeams:");
        soccerLeague.printTeams();

        System.out.println("\nRankings:");
        soccerLeague.printRankings();

        System.out.println("\nTeams:");
        soccerLeague.printTeams();

    }
}
