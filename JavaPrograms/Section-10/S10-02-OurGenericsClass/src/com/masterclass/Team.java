package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-13, 18:06
*/

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team.");
            return false;
        } else {
            members.add(player);
            System.out.println("Player " + player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
        } else if (ourScore < theirScore) {
            lost++;
        } else {
            tied++;
        }
        if (opponent != null) {
            opponent.matchResult( null, theirScore, ourScore );
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo( Team <T> otherTeam ) {
        if (this.ranking() > otherTeam.ranking()) {
            return -1;
        } else if (this.ranking() < otherTeam.ranking() ) {
            return 1;
        }
        return 0;
    }
}
