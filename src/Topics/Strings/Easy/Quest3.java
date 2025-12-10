package Topics.Strings.Easy;
//https://leetcode.com/problems/largest-odd-number-in-string/
public class Quest3 {
    public static void main(String[] args) {
        // Example 1
        String num1 = "52";
        System.out.println("The largest odd number in \"" + num1 + "\" is: " + largestOddNumber(num1)); // Expected output: 5

        // Example 2
        String num2 = "4206";
        System.out.println("The largest odd number in \"" + num2 + "\" is: " + largestOddNumber(num2)); // Expected output: ""

        // Example 3
        String num3 = "35427";
        System.out.println("The largest odd number in \"" + num3 + "\" is: " + largestOddNumber(num3)); // Expected output: 35427
    }
    public static String largestOddNumber(String num) {
    for(int i = num.length()-1;i>=0;i--){
        if(Character.getNumericValue(num.charAt(i)) % 2 != 0){
            return num.substring(0,i+1);//it will (0,i) go to i-1
        }
    }
    return "";
    }
}