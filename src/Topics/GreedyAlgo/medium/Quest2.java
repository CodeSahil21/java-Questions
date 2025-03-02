package Topics.GreedyAlgo.medium;

//https://leetcode.com/problems/jump-game/description/
public class Quest2 {
    public static void main(String[] args) {

    }
    public static boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > maxIndex){
                return false;
            }
            maxIndex = Math.max(maxIndex,i+nums[i]);
        }
        return true;
    }
}
