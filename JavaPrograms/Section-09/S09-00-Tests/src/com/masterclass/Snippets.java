import java.util.*;

public class Snippets {
    // - Helpers -

    // System.out.print**() short hand
    private static void o(String text) {
        o(text, true);
    }
    private static void o(String text, boolean prefix) {
        o(text, (prefix ? "- " : ""), "");
    }
    private static void o(String text, String prefix) {
        o(text, prefix, "");
    }
    private static void o(String text, boolean prefix, String suffix) {
        o(text, (prefix ? "- " : ""), suffix);
    }
    private static void o(String text, String prefix, String suffix) {
        System.out.print(prefix + text + suffix);
    }

    private static void oln(String text) {
        oln(text, true);
    }
    private static void oln(String text, boolean prefix) {
        oln(text, (prefix ? "= " : ""), "");
    }
    private static void oln(String text, String prefix) {
        oln(text, prefix, "");
    }
    private static void oln(String text, String prefix, String suffix) {
        System.out.println(prefix + text + suffix);
    }


    // Print int[] array  -> [0, 1, 2, 3, ...]
    private static void printArray(int[] array) {
        oln(Arrays.toString(array));
    }

// ArrayList
    // Print ArrayList<Integer>
    private static void printALInteger(ArrayList<Integer> array) {
        oln("------------", "");
        for (int i = 0; i < array.size(); i++) {
            oln(i + " : " + array.get(i), ">");
        }
        oln("============", "");
    }
    // Print ArrayList<String>
    private static void printALString( ArrayList<String> array ) {
        oln("------------", "");
        for (int i = 0; i < array.size(); i++) {
            oln(i + " : " + array.get(i), ">");
        }
        oln("============", "");
    }

// LinkedList
    // Print LinkedList<String>
    private static void printLLString(
                LinkedList<String> linkedList, String prefix ) {
        Iterator<String> iterator = linkedList.iterator();
        oln("------------", "");
        while (iterator.hasNext()) {
            oln(prefix + iterator.next(), ">");
        }
        oln("============", "");
    }
    // Insert String in LinkedList<String> in alphabetical order.
    private static boolean addInOrderLLString(
                LinkedList<String> linkedList, String newString, boolean allowDoubles ) {
        // Add string in alphabetical order in LinkedList<String>
        ListIterator<String> listIterator = linkedList.listIterator();
        while ( listIterator.hasNext() ) {
            int comparison = listIterator.next().compareTo(newString);
            if ( comparison == 0) {
                // Already exists
                if ( !allowDoubles ) {
                    // Not doubles allowed
                    oln(newString + " is already in our list");
                    return false;
                }
                // Double, add here
                listIterator.add(newString);
                return true;
            } else if ( comparison > 0 ){
                // Should be inserted before this one, 
                //  hasNext already has us on this element,
                //  so we have to go back one before adding it.
                listIterator.previous();
                listIterator.add(newString);
                return true;
            }
        }
        // Not inserted yet, insert at end
        listIterator.add(newString);
        return true;
    }


// User input
// public class Main {
    private static Scanner scanner = new Scanner(System.in);
//    public static void main(String[] args) {
//        int[] myIntArray = getIntegers(5);
//    }

    private static int[] getIntegers(int number) {
        oln("Enter " + number + " integer values.\r");
        int[] values = new int[number];
        int i = 0;
        while (i < values.length) {
            o("Enter number " + (i + 1) + " : ");
            if (scanner.hasNextInt()) {
                values[i] = scanner.nextInt();
                i++;
            }
            scanner.nextLine();
            o("", false, false);
        }
        return values;
    }
    private static int getInt() {
        oln("Enter " + number + " intege value.\r");
        int i = 0;
	o("Enter number " + (i + 1) + " : ");
	if (scanner.hasNextInt()) {
		i = scanner.nextInt();;
	}
	scanner.nextLine();
        return i;
    }

}
