package Basics;
public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 1; // Test case 1
        String s = "";
        while (true){
            String temp = s;
            if (decimal == 1){
                s = "1" + temp;
                break;
            }
            if (decimal ==0){
                break;
            }
            int de = decimal%2;
            decimal /= 2;
            s = String.valueOf(de) + temp;
        }
        System.out.printf("Binary: %s",s);
        // Convert decimal to binary
        // Print: Binary: <result>
    }
}
