package Basics;
public class HappyNumberCheck{
    public static void main(String[] args) {
        int number = 19; // Test case 1
        boolean isHappy = true;
        String str = String.valueOf(Math.abs(number));
        int result = 0;
        while (result <= 1){
                int pre = result;
                for (char c: str.toCharArray()){
                result += Math.pow(Integer.parseInt(String.valueOf(c)),2);
                if (result==pre){
                    isHappy = false;
                    break;
                }
            }
            }
        System.out.printf("Is happy: %s",isHappy);
        }
        // Check if happy number
        // Print: Is happy: <true/false>
    }