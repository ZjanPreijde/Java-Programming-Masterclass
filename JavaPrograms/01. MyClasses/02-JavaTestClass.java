package com.masterclass;
/*
    Another great class by Zjan Preijde
*/

// import standard Java
import java.util.*;
// import own classes

// import class we're testing
import com.masterclass.JavaClassExtend.*

public class TestJavaClassExtend {
    public static ArrayList<String[]> tests, runTests;
    public static boolean[] results;

    public static void main( String[] args ) {

        testJavaClassExtend();
    }

    private void testJavaClassExtend() {
        String[] choices;
        initTests();

        while ( true ) {
            choices = testMenu( tests );
            if (choices[1] == "quit") {
                break;
            }
            doTests( choices );
        }
    }
    private static void initTests{
        tests = new ArrayList<>();
        tests.add( new String[]{"Feature 1      ", "feature-a"      , "1"});
        tests.add( new String[]{"Feature 2      ", "feature-b"      , "2"});
        tests.add( new String[]{"Some other test", "some-other-test", "O"});
        tests.add( new String[]{"Run all tests"  , "all"            , "A"});
        tests.add( new String[]{"Exit"           , "quit"           , "Q"});
        return tests;
    }

    private static String[] testMenu( ArrayList<String[]> tests ) {
        // All for now
        oln("\n");
        printHeader("Class JavaClassExtend TDD");
        oln("\n");
        return getAMenu( "Available tests:", tests );
    }

    private static void doTests( String[] choices ) {
        runTests = new ArrayList<>();
        if ( choices[1] == "all" ) {
            tests.forEach( test -> {
                if ( test[1] != "all" && test[1] != "quit" ) runTests.add( test );
            });
        } else {
            runTests.add( choices );
        }
        results = new boolean[ runTests.size() ];
        // I need the index for results[], no .forEach()
        for (int i = 0; i < runTests.size(); i++) {
            switch (runTests.get(i)[1]) {
                case "feature-a":
                    results[i] = testFeatureA();
                    break;
                case "feature-a":
                    results[i] = testFeatureB();
                    break;
                case "some-other-test":
                    results[i] = testSomeOtherFeature();
                    break;
                default:
                    break;
            }
        }
        oln("Test results :", "\n");
        for ( int i = 0; i < runTests.size(); i++) {
            olt( runTests.get( i )[0], results[i] );
        }
    } // <- doTests()

    private static void testFeatureA() {
        return true;
    }
    private static void testFeatureB() {
        return true;
    }
    private static void testSomeOtherFeature() {
        return true;
    }
}
