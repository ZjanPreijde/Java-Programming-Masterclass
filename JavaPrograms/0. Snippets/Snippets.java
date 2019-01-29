// System.out.print**() short hand
    private static void o(String text) {
        System.out.print("- " + text);
    }
    private static void o(String text, boolean prefix) {
        System.out.print((prefix ? "- " : "") + text);
    }
    private static void o(String text, boolean prefix, boolean newLine) {
        System.out.print((prefix ? "- " : "") + text + (newLine ? "\n" : "" ));
    }
    private static void oln(String text) {
        System.out.println("= " + text);
    }
    private static void oln(String text, boolean prefix) {
        System.out.println((prefix ? "= " : "") + text);
    }

// Print array
    public static void printArray(int[] array) {
        oln(Arrays.toString(array));
    }
//    public static void printArray(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            o("" + array[i]);
//        }
//        o("", false, true);
//    }


// User input
// public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] myIntArray = getIntegers(5);
    }

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

