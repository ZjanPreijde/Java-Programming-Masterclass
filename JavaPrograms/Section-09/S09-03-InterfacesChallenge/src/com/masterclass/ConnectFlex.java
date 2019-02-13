package com.masterclass;
/*
    Another great class by Zjan Preijde
*/

public class ConnectFlex extends Connect {
    public ConnectFlex( boolean directPlacement, int nrOfColumns, int nrOfRows, int nrToConnect ) {
        // Args : title, directPlacement, nrOfColumns, nrOfRows, nrToConnect
        super("Connect Flex " + nrOfColumns + "x" + nrOfRows
                        + ", " + nrToConnect + "to win"
                , directPlacement, nrOfColumns, nrOfRows, nrToConnect);
    }

}
