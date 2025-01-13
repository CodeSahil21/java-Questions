package Topics.BitManipulation.sub2;
//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
public class Quest1 {
    public static void main(String[] args) {
        int number1 = 29;
        int number2 = 15;
        System.out.println("Minimum bit flips to convert " + number1 + " to " + number2 + ": " + countBitFlips(number1, number2));
    }


    public static int countBitFlips(int a, int b) {
        // Perform XOR between a and b
        int xorResult = a ^ b;

        // Count the number of 1's in the binary representation of xorResult
        int bitFlips = 0;
        while (xorResult != 0) {
            bitFlips += xorResult & 1;
            xorResult >>= 1;
        }

        return bitFlips;
    }
}
