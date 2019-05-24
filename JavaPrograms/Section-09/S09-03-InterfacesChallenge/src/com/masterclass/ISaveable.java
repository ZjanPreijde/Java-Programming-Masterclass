package com.masterclass;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
    boolean storeValue( String value, String extraInfo );
    List returnValues();
}
