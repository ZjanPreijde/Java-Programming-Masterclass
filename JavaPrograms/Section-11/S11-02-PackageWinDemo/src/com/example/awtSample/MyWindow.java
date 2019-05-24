package com.example.awtSample;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-14, 13:29
*/

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {
    public MyWindow(String title) {
        super(title);
        setSize(1200, 500);
        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing( WindowEvent e ) {
                System.exit(0);
            }
        } );
    }

    @Override
    public void paint( Graphics g ) {
        super.paint( g );
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString( "The Complete Java Developer Course", 60, 60 );
        g.setFont(new Font("SansSerif", Font.BOLD, 12));
        g.drawString( "by Pipo the Clown", 60, 100 );

        if (false) {
            g.setFont(sansSerifLarge);
            g.drawString( "g.toString() :", 60, 170 );
            g.setFont(sansSerifSmall);
            g.drawString( g.toString(), 60, 200 );
            g.setColor( new Color( 255,0, 0) );
            g.setPaintMode();
            g.drawLine( 60, 210, 400, 400 );
            g.drawLine( 60, 400, 400, 210 );
        }
    }
}
