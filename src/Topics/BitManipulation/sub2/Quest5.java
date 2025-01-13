package Topics.BitManipulation.sub2;

public class Quest5 {
    public static int xorFrom1ToN(int n) {
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            case 3: return 0;
        }
        return 0; // This line will never be reached
    }

    // Function to calculate the XOR in the range [L, R]
    public static int xorInRange(int L, int R) {
        return xorFrom1ToN(R) ^ xorFrom1ToN(L - 1);
    }

    public static void main(String[] args) {
        int L = 5;
        int R = 10;
        System.out.println("XOR of numbers in range [" + L + ", " + R + "]: " + xorInRange(L, R));
    }
}
