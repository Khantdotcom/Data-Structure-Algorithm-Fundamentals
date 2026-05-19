public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 10; // Test case 1
        String s = "";
        while (true){
            String temp = s;
            int de = decimal%2;
            decimal /= 2;

            if (decimal == 1){
                s = "1" + temp;
                break;
            }
            if (decimal ==0){
                break;
            }
        }
        System.out.printf("Binary: %s",s);
        // Convert decimal to binary
        // Print: Binary: <result>
    }
}