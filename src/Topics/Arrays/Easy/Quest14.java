package Topics.Arrays.Easy;
//https://leetcode.com/problems/max-consecutive-ones/
public class Quest14 {
    public static void main(String[] args) {
      int[] arr = {1,1,0,1,1,1};
     int result =  findMaxConsecutiveOnes(arr);
        System.out.println(result);
    }

    public static  int findMaxConsecutiveOnes(int[] nums) {
       int max = 0;
       int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                count++;
                max = Math.max(max,count);
            }else{
                count = 0;
            }
        }
        return count;
    }
}
