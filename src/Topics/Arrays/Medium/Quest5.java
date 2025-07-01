package Topics.Arrays.Medium;
//Trapping rain water
//https://leetcode.com/problems/trapping-rain-water/description/
public class Quest5 {
    public static void main(String[] args) {
        int[] height = {3, 1, 2, 4, 0, 1, 3, 2};
        System.out.println("Trapped water: " + trap(height));
    }
    public  static int  trap(int[] height) {
        //step1 creating two auxiliary array
        int[] right = new int[height.length];//time:o(n) space:o(n)
        int[] left = new int[height.length];//time:o(n) space:o(n)

        //filling right array
        right[height.length-1] = height[height.length-1];
        for(int i = height.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        //filling left array
        left[0] = height[0];
        for(int i = 1; i<height.length;i++){
            left[i] = Math.max(left[i-1], height[i]);
        }

        //trapwater formula:it will calculate how much water it can store at particular index
        int trapwater = 0;
        for(int i = 0; i<height.length;i++){//time:o(n) space:o(1)
            trapwater += Math.min(left[i],right[i])-height[i];
        }

        return trapwater;

    }
//time: o(n) and space:o(n)

}
//how will we solve this question
/*
1)we will create tow auxilary arrays
Initialize the Arrays:
left array to store the maximum height from the left up to that index.
right array to store the maximum height from the right up to that index.

Fill the left Array:
Traverse the array from left to right.
For each element, store the maximum height encountered so far.

2)Calculation of Trapped Water
For each index, calculate the amount of water trapped using the formula:

water trapped at index i = min(left[i],right[i])-arr[i];
*/