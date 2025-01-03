package Topics.Arrays.Medium;

import java.util.*;
import java.util.Scanner;
//find kth largest element
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class Quest4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {3,2,1,5,6,4};
        int k = in.nextInt();//to find kth largest element in array ex 2nd largest or 3rd largest
        //6,5,4,3,2,1
        int result = findKthLargest(arr,k);
        System.out.println(result);
        in.close();
    }
    //Time complexity and space complexity o(nlogn) and space complexity o(1)
    public static int  findKthLargest(int[] nums, int k) {
        //edge case
        if(nums.length == 0 && k > nums.length){
            return -1;
        }
        //sort the array
        Arrays.sort(nums);
        //reverse it to get descending order;
        reverse(nums);
        //return  kth larget element
        return nums[k-1];
    }
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int temp  = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    public class KthLargestElement {
        public static int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

            for (int num : nums) {
                minHeap.offer(num);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            return minHeap.peek();
        }

        public static void main(String[] args) {
            int[] nums = {3, 2, 1, 5, 6, 4};
            int k = 2;
            System.out.println(findKthLargest(nums, k));  // Output: 5
        }
    }

}
