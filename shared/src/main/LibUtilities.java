package main;

public class LibUtilities {
    public static boolean isNotNumeric(String str) {
        return !str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static Long handleUserInputID(String input) {
        if (LibUtilities.isNotNumeric(input)) {
            System.out.println("Provided argument id: \"" + input + "\" is not a number! Try again.");
            return null;
        } else if (input.contains(".")) {
            System.out.println("ID field cannot accept decimal values. Try again.");
            return null;
        }

        Long id = null;
        try {
            id = Long.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.println("Provided argument: \"" + input + "\" is too large for ID field. Try again.");
        }
        return id;
    }
}
