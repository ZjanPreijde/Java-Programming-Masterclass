package com.masterclass;
/*
    Another great class by Zjan Preijde
*/

import java.util.ArrayList;

import static com.masterclass.OutputExtend.*;
import static com.masterclass.ArrayExtend.*;



public class TranslateTest {
    public static String string, result;
    public static String[] strings, results;
    public static ArrayList <String[]> translate = new ArrayList<>();
    public static ArrayList <String  > from      = new ArrayList<>();
    public static ArrayList <String  > to        = new ArrayList<>();
    public static ArrayList <String  > include   = new ArrayList<>();
    public static ArrayList <String  > exclude   = new ArrayList<>();

    public static void main(String[] args) {
        testTranslate1() ;
    }

    public static void testTranslate1() {

        oln("Silly examples, but technique may be interesting", "\n", "\n");
        oln("Or may also be silly :-)", "\n", "\n");
        // 1.
        oln("\n" + "1. test .replace()", "\n");
        string = "babab, test .replace()";
        oln(string, "\n");
        oln("Replace( (a) -> (A) :", "\n");
        oln( string.replace("a", "A"), "\n");

        // 2.
        oln("\n" + "2. init from, to", "\n");
        string = "The dog barks and pees against the tree";
        oln(string, "\n");
        oln("Replace( (dog, barks, tree) -> (cat meows, sofa) :");
        from = new ArrayList <>(  );
        to   = new ArrayList <>(  );
        from.add("dog")  ; to.add("cat");
        from.add("barks"); to.add("meows");
        from.add("tree") ; to.add("sofa");
        oln( translateString( string, from, to ) , "\n");

        // 3.
        oln("\n" + "3. init translate", "\n");
        string = "The dog barks and pees against the tree";
        oln(string, "\n");
        oln("Replace( (dog, barks, tree) -> (cat meows, sofa) :", "\n");
        translate = new ArrayList <>();
        translate.add( new String[]{ "dog",   "cat" });
        translate.add( new String[]{ "barks", "meows"});
        translate.add( new String[]{ "tree",  "sofa"});
        oln( translateString( string, translate ) , "\n");

    }


    // Overloaders
    public static String[] translateString( String[] translateStrings
            , ArrayList<String[]> translate) {
        from = new ArrayList <>();
        to   = new ArrayList <>();
        translateInit( translate, from, to );
        return translateString( translateStrings, from, to );
    }
    public static String translateString( String translateString
            , ArrayList<String[]> translate) {
        from = new ArrayList <>();
        to   = new ArrayList <>();
        translateInit( translate, from, to );
        return translateString( translateString, from, to );
    }
    public static String[] translateString( String[] translateStrings
            , ArrayList<String> from
            , ArrayList<String> to) {
        ArrayList <String  > include   = new ArrayList<>();
        ArrayList <String  > exclude   = new ArrayList<>();
        return translateString( translateStrings, from, to, include, exclude );
    }
    public static String[] translateString( String[] translateStrings
            , ArrayList<String> from
            , ArrayList<String> to
            , ArrayList<String> include
            , ArrayList<String> exclude  ) {
        // include and exclude not used at this point
        // went something like this,
        // - if current row index not in (not empty) includes, skip.
        // - if current row index in (not empty) excludes, skip.

        String[] result = new String[ translateStrings.length ];
        for ( int s = 0; s < result.length; s++ ) {
            result[ s] = result[ s ] = translateString( strings[ s ], from, to );
        }
        return result;

    }

    // Overloaded
    // This is where the actual work is done
    public static String translateString( String translateString
            , ArrayList<String> from
            , ArrayList<String> to ) {
        String result = translateString;
        for ( int a = 0; a < from.size(); a++ ) {
            String search  = from.get( a );
            String replace = to  .get( a );
//            oln("Replace " + search + " with " + replace);
            result = result.replace( search, replace );
        }
        return result;
    }

    public static void translateInit( ArrayList<String[]> translate
            , ArrayList<String> from
            , ArrayList<String> to ) {
        translate.forEach( ( sequence ) -> {
            from.add( sequence[0] );
            to.add( sequence[1] );
        } ); /* .forEach() */
    }

    // A little big for a simple test.
    public static String[] translateHTML( String[] html ) {
        from = new ArrayList <>();
        to   = new ArrayList <>();
        translateHTMLInit( from, to );
        return translateString( html, from, to );
    }
    public static ArrayList<String[]> translateHTMLInit( ArrayList<String> from
            , ArrayList<String> to ) {
        translate = new ArrayList <>(  );
        translate.add(new String[]{"<html>", ""});
        translate.add(new String[]{"</html>", ""});
        translate.add(new String[]{"<body>", "\n"});
        translate.add(new String[]{"</body>", ""});
        translate.add(new String[]{"<br>", "\n"});
        translate.add(new String[]{"<br/>", "\n"});
        translate.add(new String[]{"<p>", "\n\n"});
        translate.add(new String[]{"</p>", ""});
        return translate;
    }
}
