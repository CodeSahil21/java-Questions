package Topics.BitManipulation.sub2;

public class Quest3 {
    public static int findUniqueNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println("The unique number is: " + findUniqueNumber(nums));
    }
}

