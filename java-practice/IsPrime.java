public class IsPrime {
    public static void main(String[] args) {
        int number = 17; // Test case 1
        boolean isPrime = true;
        for (int i=2;i<number,i++){
            if (number % i==0){
                isPrime = false;
            }
        }
        System.out.printf("Is prime: %s",isPrime);
        // Check if number is prime
        // Print: Is prime: <true/false>
    }}