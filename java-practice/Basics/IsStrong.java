package Basics;
public class IsStrong {
    public static void main(String[] args) {
        int number = 145; // Test case 1
        String str = String.valueOf(Math.abs(number));
        int total = 0;
        for (char c: str.toCharArray()){
            int num = Integer.parseInt(String.valueOf(c));
            int facto = 1;
            for (int i = num;i<1;i--){
                facto *= i;
            }
            total += facto;
        }
        boolean isStrong = number == total;
        System.out.printf("Is strong: %s" ,isStrong);
        // Check if strong number
        // Print: Is strong: <true/false>
    }
}
