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
        System.out.print(prefix + text + suffix);
    }

// Print array
    public static void printArray(int[] array) {
        oln(Arrays.toString(array));
    }

// User input
// public class Main {
    private static Scanner scanner = new Scanner(System.in);
//    public static void main(String[] args) {
//        int[] myIntArray = getIntegers(5);
//    }

    public static int[] getIntegers(int number) {
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

