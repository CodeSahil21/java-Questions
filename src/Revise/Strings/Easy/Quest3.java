package Revise.Strings.Easy;

public class Quest3 {
    public static void main(String[] args) {
        String[] testCases = {
                "35420",     // Expected: "3542"
                "4206",      // Expected: ""
                "738",       // Expected: "73"
                "13579",     // Expected: "13579"
                "24680",     // Expected: ""
                "1000000001" // Expected: "1000000001"
        };

        for (String input : testCases) {
            String result = largestOddNumber(input);
            System.out.println("Input: " + input + " → Output: " + result);
        }
    }
    static String largestOddNumber(String input){
        for(int i = input.length()-1 ; i >= 0; i--){
            int digit = Character.getNumericValue(input.charAt(i));
            if(digit % 2 != 0 ){
                return input.substring(0,i+1);
            }
        }
        return "";
    }
}
