package Basics;

public public class NeonNumCheck{
    public static void main(String[] args) {
        int number = 9; // Test case 1
        
        // 9^2 = 81, 8+1 = 9 ✓
        int sq = number * number;
        String str = String.valueOf(Math.abs(sq));

        int total = 0;
        for (char c : str.toCharArray()){
            total += Integer.parseInt(String.valueOf(c));
        }
        boolean n = (number == total);
        System.out.printf("Is Neon: %s",n);
        // Check if Harshad: 18 / (1+8) = 18/9 = 2
        // Print: Is Harshad: <true/false>
    }
}
        // Print: Is Neon: <true/false> {
