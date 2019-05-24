package com.masterclass;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer( "Joe" );
        BaseballPlayer pat = new BaseballPlayer( "Pat" );
        SoccerPlayer deLigt = new SoccerPlayer( "Matthijs de Ligt" );
        SoccerPlayer deJong = new SoccerPlayer( "Frenkie de Jong");

        Team<SoccerPlayer> ajax = new Team<>("Ajax");
        ajax.addPlayer( deJong );
//        ajax.addPlayer( joe );
//        ajax.addPlayer( pat );
        ajax.addPlayer( deLigt );
        Team<SoccerPlayer> utrecht = new Team<>("Utrecht");

        System.out.println(ajax.numPlayers());

        Team<FootballPlayer> adelaide = new Team<>("Adelaide");
        adelaide.addPlayer( joe );
        Team<BaseballPlayer> chicago = new Team<>("Chicago");
        chicago.addPlayer( pat );

        ajax.matchResult( utrecht, 4, 1 );
        System.out.println(ajax.compareTo( utrecht ));
        System.out.println(utrecht.compareTo( ajax ));

        ArrayList<Team> teams = new ArrayList<>();
        teams.add( utrecht );
        teams.add( ajax );
        for (Team team: teams) {
            System.out.println(team.getName());
        }
        Collections.sort( teams );
        for (Team team: teams) {
            System.out.println(team.getName());
        }

    }
}
