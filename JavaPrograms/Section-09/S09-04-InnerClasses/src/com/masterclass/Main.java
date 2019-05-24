package com.masterclass;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner( System.in );


    public static void main(String[] args) {

        // Gear is public inner class in Gearbox1 and available to outside world
        gearBox1();

        // Gear is private inner class in Gearbox2,
        //  this is more usual, the outer class handles the inner class
        // Gearbox has public method addGear()
        gearBox2();

        // Gear is private inner class in Gearbox3,
        // Gearbox3 has private method addGear(), now adds gears itself
        gearBox3();


        // local inner class examples,
        //   implement method on object through
        //   local class implementing interface

        // One button, local inner class
        button1();

        // multiple objects, same method
        // Multiple buttons, local inner class
        buttons();


        // anonymous inner class examples,
        // multiple objects,
        //  code depends on objects own anonymous methods
        //  e.g. button clicked, different button different code
        //

        // One button, anonymous inner class
        button1Anonymous();

        // Multiple buttons, each own anonymous inner class
        buttonsAnonymous();
    }

    // Gearbox1 has public inner class Gear
    private static void gearBox1() {
        System.out.println( "- Gearbox1() -" );
        System.out.println( "- Gearbox1 has public inner class Gear -" );
        Gearbox1 mcLaren1 = new Gearbox1( 6 );
        Gearbox1.Gear first  = mcLaren1.new Gear( 1, 12.3 );
        Gearbox1.Gear second = mcLaren1.new Gear( 2, 15.4 );
        Gearbox1.Gear third  = mcLaren1.new Gear( 3, 17.8 );
        System.out.println(
                "Speed first  gear at 1000 revs " + first.driveSpeed( 1000 ) );
        System.out.println(
                "Speed second gear at 1000 revs " + second.driveSpeed( 1000 ) );
        System.out.println(
                "Speed third  gear at 1000 revs " + third.driveSpeed( 1000 ) );
        System.out.println("");

    }

    // GearBox2 has private inner class Gear and public method addGear()
    private static void gearBox2() {
        System.out.println( "- Gearbox2() -" );
        System.out.println( "- Gearbox2 has private inner class Gear -" );
        System.out.println( "- Gearbox2 has public method addGear() -" );
        Gearbox2 lada = new Gearbox2( 4 );
        lada.addGear( 0, 00.0 ); // invalid (added by Gearbox constructor)
        lada.addGear( 5, 21.8 ); // invalid, too high
        lada.addGear( 1, 12.3 );
        lada.addGear( 1, 12.3 ); // invalid, already exists
        lada.addGear( 2, 15.4 );
        lada.addGear( 3, 17.8 );
        lada.addGear( 4, 19.4 );
        lada.addGear( 5, 21.8 ); // invalid, max nr of gears reached
        // lada now has neutral and 4 gears

        lada.changeGear( 1 );    // grind, no clutch down
        lada.operateClutch( true );   // clutch down
        lada.changeGear( 7 );    // invalid gear
        lada.changeGear( 1 );    // newGear == 1
        lada.operateClutch( false );  // clutch up
        System.out.println("Wheelspeed clutch up " + lada.wheelSpeed( 1000 ));
        lada.operateClutch( true );   // clutch down
        // Scream :
        System.out.println("Wheelspeed clutch down " + lada.wheelSpeed( 1000 ));
        lada.changeGear( 2 );    // newGear == 2
        lada.operateClutch( false );  // clutch down
        System.out.println("Wheelspeed clutch up " + lada.wheelSpeed( 1000 ));
        System.out.println("");


    }

    // GearBox3 has private inner class Gear and private method addGear(), handles adding gears itself.
    private static void gearBox3() {
        System.out.println( "- Gearbox3() -" );
        System.out.println( "- Gearbox3 has private inner class Gear -" );
        System.out.println( "- Gearbox3 has private method addGear() -" );
        Gearbox3 lada = new Gearbox3( 4 );
        // lada now has neutral and 4 gears

        lada.changeGear( 1 );    // grind, no clutch down
        lada.operateClutch( true );   // clutch down
        lada.changeGear( 7 );    // invalid gear
        lada.changeGear( 1 );    // newGear == 1
        lada.operateClutch( false );  // clutch up
        System.out.println("Wheelspeed clutch up  " + lada.wheelSpeed( 1000 ));
        lada.operateClutch( true );   // clutch down
        // Scream :
        System.out.println("Wheelspeed clutch down " + lada.wheelSpeed( 1000 ));
        lada.changeGear( 2 );    // newGear == 2
        lada.operateClutch( false );  // clutch up
        System.out.println("Wheelspeed clutch up   " + lada.wheelSpeed( 1000 ));
        System.out.println("");

    }

    /*
     One button, local inner class,
     class Button has interface OnClickListener with method onClick()
    */
    private static void button1() {
        System.out.println("------- One button, local inner class -------");
        Button button = new Button( "Don't click me!" );
        class ClickListener implements Button.OnClickListener {
            @Override
            public void onClick( String title ) {
                System.out.println(title + " was clicked");
            }
        }
        button.setOnClickListener( new ClickListener() );
        buttonListen( button );
    }
    // <- One button, local inner class

    /*
     Multiple buttons, local inner class,
     class Button has interface OnClickListener with method onClick()
    */
    private static void buttons() {
        System.out.println("------- Multiple buttons, local inner class -------");
        // Multiple buttons
        Button[] buttons = {
                new Button("Top"),
                new Button("Previous"),
                new Button("Buy this one!"),
                new Button("Next"),
                new Button("End")
        };
        // Same as one button
        class ClickListener implements Button.OnClickListener {
            @Override
            public void onClick( String title ) {
                System.out.println(title + " was clicked");
            }
        }
        // Set listener on each button
        for ( Button button : buttons ) {
            button.setOnClickListener( new ClickListener() );
        }
        buttonsListen( buttons );
    }
    // <- Multiple buttons, local inner class


    // One button, anonymouse inner class
    private static void button1Anonymous() {
        System.out.println("------- One button, anonymous inner class -------");
        Button button = new Button( "Don't click me!" );
        // Using an anonymous class
        button.setOnClickListener( new Button.OnClickListener() {
            @Override
            public void onClick( String title ) {
                System.out.println( title + " was clicked\n\t(I anonymously reported this)");
            }
        } );
        buttonListen( button ); // Used from other example
    }
    // <- One button, anonymouse inner class

    // One button, anonymouse inner class
    private static void buttonsAnonymous() {
        System.out.println("------- Multiple buttons, anonymous class -------");
        // Multiple buttons
        Button[] buttons = {
                new Button("Top"),
                new Button("Previous"),
                new Button("Buy this one!"),
                new Button("Next"),
                new Button("End")
        };
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener( new Button.OnClickListener() {
                @Override
                public void onClick( String title ) {
                    System.out.println(title + " was clicked, " + title + " action taken."
                            + "\n\t(I anonymously reported this)");
                }
            } );
        }
        buttonsListen( buttons );
    }

    private static void buttonListen(Button button ) {
        boolean quit = false;
        String title = button.getTitle();
        while ( !quit ) {
            System.out.print("\nClick " + title + " (1), or quit (9)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch ( choice ) {
                case 9:
                    quit = true;
                    break;
                case 1:
                    button.onClick();
                    break;
                default:
                    break;
            }
        }
    }
    private static void buttonsListen( Button[] buttons ) {
        while ( true ) {
            System.out.println("\nThese are your options :");
            for (int i = 0; i < buttons.length; i++) {
                System.out.println( "Click " + i + " for " + buttons[i].getTitle()) ;
            }
            System.out.println("Click 9 to quit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if ( choice == 9 ) {
                break;
            }
            if ( choice >= 0 && choice < buttons.length ) {
                buttons[choice].onClick();
            }
        }
    }

}
