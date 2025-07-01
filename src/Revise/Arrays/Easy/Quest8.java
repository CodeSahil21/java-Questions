package Revise.Arrays.Easy;

public class Quest8 {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {2, 1, 3, 4};
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(check(nums1));// Output: true
        System.out.println(check(nums2));//Output: false
        System.out.println(check(nums3)); // Output: true
    }

    static boolean check(int[] arr){
        int count = 0;
        for(int i = 0 ; i < arr.length;i++){
            if(arr[i] > arr[(i+1)% arr.length]){
                count ++;
            }
        }
        if(count > 1){
            return  false;
        }
        return true;
    }
}
