package com.masterclass;

import java.util.ArrayList;

public interface ISaveable {
    boolean storeValue( String value, String extraInfo );
    ArrayList returnValues();
}
