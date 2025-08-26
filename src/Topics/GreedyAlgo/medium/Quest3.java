package Topics.GreedyAlgo.medium;
//https://leetcode.com/problems/jump-game-ii/description/
public class Quest3 {
    public static void main(String[] args) {
      int[]  arr = {2,3,1,1,4};
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
   int minJump(int ind,int jump,int[] arr){
           if(ind >= arr.length-1){
               return jump;
           }
           int min = Integer.MAX_VALUE;
       for (int i = 0; i <arr[ind] ; i++) {
           min = Math.min(min,minJump(ind + i,jump+1,arr));
       }
       return min;
   }
}
