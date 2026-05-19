public class Main {
    public static void main(String[] args) {
        int number = 153; // Test case 1
        int l = String.valueOf(Math.abs(number)).length();
        int total = 0;
        String[] s = String.valueOf(number).split("");
        for (String c: s){
            total += Math.pow(Integer.parseInt(c),l);
        }
        boolean is = (total== number);
        System.out.printf("Is Armstrong: %s",is);
        // Check if Armstrong: 153 = 1^3 + 5^3 + 3^3
        // Print: Is Armstrong: <true/false>
    }
}