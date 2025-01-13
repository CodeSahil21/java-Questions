package Topics.BitManipulation.sub2;

public class Quest4 {
    public static int[] findUniqueNumbers(int[] nums) {
        long xorResult = 0;

        // Calculate XOR of all numbers
        for (int num : nums) {
            xorResult ^= num;
        }

        // Find the rightmost set bit
        long rightmost = xorResult & ~(xorResult - 1);

        int b1 = 0, b2 = 0;

        // Separate numbers into two groups and XOR
        for (int num : nums) {
            if ((num & rightmost) != 0) {
                b1 ^= num;
            } else {
                b2 ^= num;
            }
        }

        return new int[]{b1, b2};
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 2, 3, 4, 6};
        int[] uniqueNumbers = findUniqueNumbers(nums);
        System.out.println("The unique numbers are: " + uniqueNumbers[0] + " and " + uniqueNumbers[1]);
    }
}
