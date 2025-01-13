package Topics.BitManipulation.sub1;

public class Quest4 {
    public static int divide(int dividend, int divisor) {
        // Handling edge cases
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Overflow case
        }

        boolean sign = (dividend > 0) == (divisor > 0); // Determine the sign of the result

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;
        long sum = d;

        while (n >= sum) {
            long temp = d, count = 1;
            while (n >= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }
            n -= temp;
            quotient += count;
        }

        return sign ? (int) quotient : (int) -quotient;
    }


    public static void main(String[] args) {
        int dividend = 22;
        int divisor = 3;
        System.out.println("Result of dividing " + dividend + " by " + divisor + ": " + divide(dividend, divisor));
    }
}


