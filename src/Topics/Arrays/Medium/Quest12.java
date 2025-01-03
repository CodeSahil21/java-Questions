package Topics.Arrays.Medium;
//https://leetcode.com/problems/majority-element/description/
public class Quest12 {
     
        public static void main(String args[]) {
            int[] arr = {2, 2, 1, 1, 1, 2, 2};
            int ans = majorityElement(arr);
            System.out.println("The majority element is: " + ans);

        }

    public static int majorityElement(int[] nums) {
        int c1 = 0;
        int element=0 ;
        for (int i = 0; i < nums.length; i++) {
            if(c1 == 0){
                c1++;
                element = nums[i];
            }else if(nums[i]==element){
                c1++;
            } else if (nums[i] != element) {
                c1--;
            }
        }
        int c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==element){
                c2++;
            }
            if(c2 > nums.length/2){
                return element;
            }
        }
        return -1;
    }
}
/*
  public static int majorityElement(int []v) {
        //size of the given array:
        int n = v.length;

        //declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();

        //storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);
        }

        //searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }

        return -1;
    }
 */
