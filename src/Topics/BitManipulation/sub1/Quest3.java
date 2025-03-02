package Topics.BitManipulation.sub1;
//https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1
public class Quest3 {
    public static boolean isBitSetLeft(int number, int i) {
        // Left shift 1 by i positions and AND with the number
        return (number & (1 << i)) != 0;
    }
    /*
    // Dry Run Example: number = 13 (binary: 1101), i = 2
    1 << 2 = 0100 (binary)
    1101 &
    0100
    = 0100
    Result: true
     */
    public static boolean isBitSetRight(int number, int i) {
        // Right shift number by i positions and AND with 1
        return ((number >> i) & 1) == 1;
    }
    /*
    // Dry Run Example: number = 13 (binary: 1101),
     i = 2 1101 >> 2 = 0011 (binary)
       0011
     & 0001
     = 0001
      Result: true
     */
    public static int setBit(int number, int i) {
        // Create a bitmask by shifting 1 left by i positions and OR with the number
        return number | (1 << i);
    }
    /*
    number = 13 (binary: 1101),
     i = 1 1 << 1 = 0010 (binary)
     1101 | 0010 = 1111
    Result: 15 (binary: 1111)
     */
    public static int clearBit(int number, int i) {
        // Create a bitmask by shifting 1 left by i positions and then inverting the bits
        int mask = ~(1 << i);
        // Use the bitwise AND operator with the mask to clear the ith bit
        return number & mask;
    }
    /*
    number = 13 (binary: 1101),
     i = 0 1 << 0 = 0001 (binary)
     ~0001 = 1110 (binary)
      1101 & 1110 = 1100
      Result: 12 (binary: 1100)
     */
    public static int toggleBit(int number, int i) {
        // XOR the number with a bitmask where only the ith bit is set
        return number ^ (1 << i);
    }
    /*
    // Dry Run Example:
    number = 13 (binary: 1101),
     i = 2 1 << 2 = 0100 (binary)
      1101 ^ 0100 = 1001
      Result: 9 (binary: 1001)
     */
    public static int removeLastSetBit(int number) {
        // Subtracting 1 from the number flips all the bits after the rightmost set bit
        // AND-ing with the original number will clear the rightmost set bit
        return number & (number - 1);
    }
    /*
    number = 13 (binary: 1101)
    13 - 1 = 12 (binary: 1100)
    1101 & 1100 = 1100
    Result: 12 (binary: 1100)
     */
    public static boolean isPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        // A number is a power of two if and only if it has exactly one bit set in its binary representation
        return (number & (number - 1)) == 0;
    }
    /*
    number = 13 (binary: 1101)
    13 - 1 = 12 (binary: 1100)
    1101 & 1100 = 1100
    Result: false
     */
    public static int countSetBits1(int n) {
        int count = 0;

        while (n > 0) {
            // Check if the least significant bit is set
            count += n & 1;
            // Shift right by one bit
            n >>= 1;
        }

        return count;
    }
    public static int countSetBits(int n) {
        int cnt = 0;

        while (n != 0) {
            // Remove the last set bit
            n = n & (n - 1);
            cnt++;
        }

        return cnt;
    }
    /*
    n = 13 (binary: 1101)
    cnt = 0
    Step 1: n & (n - 1) -> 1101 & 1100 = 1100, cnt = 1
    Step 2: n & (n - 1) -> 1100 & 1011 = 1000, cnt = 2
    Step 3: n & (n - 1) -> 1000 & 0111 = 0000, cnt = 3
    Result: cnt = 3
     */
    public static boolean isOdd(int number) {
        // Use the bitwise AND operator to check if the least significant bit is 1
        return (number & 1) == 1;
    }
/*
// Dry Run Example:
number = 13 (binary: 1101)
1101 & 0001 = 0001
Result: true
 */
    public static void main(String[] args) {
        int number = 10; // Example number
        int bitPosition = 3; // Example bit position (0-based index)

        boolean resultL = isBitSetLeft(number, bitPosition);
        System.out.println("Using Left Shift: Is bit " + bitPosition + " set in " + number + "? " + resultL);
        boolean resultR = isBitSetRight(number, bitPosition);
        System.out.println("Using Left Shift: Is bit " + bitPosition + " set in " + number + "? " + resultR);
        System.out.println("Original number: " + number);
        int newNumber = setBit(number, bitPosition);
        System.out.println("Number after setting bit " + bitPosition + ": " + newNumber);
        System.out.println("Original number: " + number);
        int newNumber2 = clearBit(number, bitPosition);
        System.out.println("Number after clearing bit " + bitPosition + ": " + newNumber2);
        System.out.println("Original number: " + number);
        int newNumber3 = toggleBit(number, bitPosition);
        System.out.println("Number after toggling bit " + bitPosition + ": " + newNumber3);
        int number2 = 10;
        System.out.println("Original number: " + number2);
        int newNumber4 = removeLastSetBit(number2);
        System.out.println("Number after removing last set bit: " + newNumber4);
        int number3 = 16; // Example number
        boolean result = isPowerOfTwo(number3);
        System.out.println("Is " + number3 + " a power of two? " + result);
        int number4 = 10;
        int result2 = countSetBits1(number4);
        System.out.println("Number of set bits in " + number4 + ": " + result2);
        int number5 = 10;
        int result3 = countSetBits(number5);
        System.out.println("Number of set bits in " + number5 + ": " + result3);
        boolean result4 = isOdd(number5);
        System.out.println("Is " + number5 + " odd? " + result4);
    }
}







