public class AutomorphicNumberCheck {
    public static void main(String[] args) {
        int number = 25; // Test case 1
        int sq = number * number;
        String s = String.valueOf(sq);
        int l = s.length();
        String[] str = s.split("");
        String n = str[l-1] + str[l-2];
        boolean isAutomorphic = (number == Integer.valueOf(n));

        System.out.printf("Is automorphic: %s",isAutomorphic);
        // Check if automorphic
        // Print: Is automorphic: <true/false>
    }
}