package Basics;
public class BinaryToDecimal {
    public static void main(String[] args) {
        String binary = "1010"; // Test case 1
        int base = binary.length() - 1;
        int decimal = 0;
        for (char c: binary.toCharArray()){
            int n = Integer.parseInt(String.valueOf(c));
            decimal += n * (int) Math.pow(2,base);
            base--;
        }
        System.out.printf("Decimal: %d",decimal);
        // Convert binary to decimal
        // Print: Decimal: <result>
    }
}