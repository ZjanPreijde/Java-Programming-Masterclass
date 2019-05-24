package com.masterclass;

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }
    public String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}
class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

    @Override
    public String plot() {
        return "A shark eats lots of people";
    }
}
class IndepenceDay extends Movie {
    public IndepenceDay() {
        super("Indepence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to take over planet Earth";
    }
}

class MazeRunner extends Movie {
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try and escape a maze";
    }
}
class StarWars extends Movie {
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial forces try to take over the Universe";
    }
}

class Forgettable extends Movie {
    public Forgettable() {
        super("Forgettable");
    }
    // no plot() method
}
public class Main {

    public static void main(String[] args) {
/*
        Movie movie = new Movie("Polymorphism");     System.out.println(movie.plot());
        Starwars starwars = new StarWars();          System.out.println(starwars.plot());
        Forgettable forgettable = new Forgettable(); System.out.println(forgettable.plot());
*/
        for (int i = 1; i < 11; i++) {
            Movie movie = randomMovie();
            System.out.println("movie #" + i
                    + " : " + movie.getName()
                    + "\nPlot : " + movie.plot() + "\n");

        }

    }
    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new IndepenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            default:
                return new Forgettable();
        }

    }
}
