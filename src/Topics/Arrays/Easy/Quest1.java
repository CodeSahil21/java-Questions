package Topics.Arrays.Easy;
//https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
//Maximum and minimum of an array using minimum number of comparisons
public class Quest1 {
    public static void main(String[] args) {
        int[] arr = { 4, 9, 6, 5, 2, 3 };
        System.out.println("Minimum element is : " + min(arr));
        System.out.println("Maximum element is : " + max(arr));
    }
//complexity for both codes will be o(n)
    static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length;i++){
           max = Math.max(max,arr[i]);
        }
        return max;
    }

    static int min(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i<arr.length;i++){
          min = Math.min(min,arr[i]);
        }
        return min;
    }
}
