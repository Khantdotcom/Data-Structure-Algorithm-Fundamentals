package Basics;
public class SumOfSeries {
    public static void main(String[] args) {
        int n = 5; // Test case 1
        double total = 0.0000;

        for (int i = 1;i<=n;i++){
            total += (double) 1/i;
        }

        System.out.printf("Sum: %.4f",total);
        // Calculate sum: 1 + 1/2 + 1/3 + ... + 1/n
        // Print with 4 decimal places: Sum: <result>
    }
}