package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-14, 9:23
*/

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team>  {
    private ArrayList<T> teams = new ArrayList<>();
    private String name;

    public League( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        if (teams.contains( team )) {
            System.out.println("Team " + team.getName() + " is already added to league " + this.getName());
            return false;
        } else {
            teams.add( team );
            System.out.println("Team " + team.getName() + " added to league " + this.getName());
            return true;
        }
    }

    public void printTeams() {
        for (Team team: teams) {
            System.out.println(team.getRanking() + ". " + team.getName());
        }
    }

    public void printRankings() {
        ArrayList<T> orderedTeams = (ArrayList<T>) teams.clone( );
        Collections.sort( orderedTeams );
        for (Team team: orderedTeams) {
            System.out.println(team.getRanking() + ". " + team.getName());
        }
    }
}
