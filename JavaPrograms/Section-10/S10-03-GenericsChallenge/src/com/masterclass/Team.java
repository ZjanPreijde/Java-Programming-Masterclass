package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-14, 9:18
*/

public abstract class Team implements Comparable<Team> {
    private String name;
    private int ranking;

    public Team( String name, int ranking ) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public int getRanking() {
        return ranking;
    }

    @Override
    public int compareTo( Team o ) {
        if (this.getRanking() > o.getRanking()) {
            return 1;
        } else if (this.getRanking() < o.getRanking()) {
            return -1;
        }
        return 0;
    }
}
