package Topics.GreedyAlgo.medium;
//https://leetcode.com/problems/jump-game-ii/description/
public class Quest3 {
    public static void main(String[] args) {

    }
    public int jump(int[] nums) {
        int jumps = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            int farthest = 0;

            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            left = right + 1;
            right = farthest;
            jumps++;
        }

        return jumps;
    }

}
