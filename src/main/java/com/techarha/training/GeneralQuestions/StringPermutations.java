package com.techarha.training.GeneralQuestions;

/**
 * Print all permutations of a given String
 */
public class StringPermutations {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String data = scanner.nextLine();
//        List<String> permutations = new ArrayList<>();

        printPermutattions("", "ABCD");

    }

    private static void printPermutattions(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                printPermutattions(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
