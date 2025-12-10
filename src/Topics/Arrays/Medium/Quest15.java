package Topics.Arrays.Medium;

import java.util.ArrayList;

public class Quest15 {
    public static void main(String[] args){

        int[] arr=  {10, 22, 12, 3, 0, 6};
        ArrayList<Integer> ans= printLeaders(arr);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }

    }
    public static ArrayList<Integer> printLeaders(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        int max = nums[nums.length-1];
        list.add(max);
        for (int i = nums.length-2; i >= 0; i--) {
            if(nums[i] > max){
                list.add(nums[i]);
                max = nums[i];
            }
        }
        return list;
    }
}
