package Revise.StackAndQueues.Implementation;
import java.util.ArrayDeque;
import java.util.Deque;
public class Quest2 {
    public static void main(String[] args) {
        int i, j, n, k = 3, x;
        int[] arr ={4,0,-1,3,5,3,6,8};
        int[] ans = maxSlidingWindowOptimal(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for (i = 0; i < ans.length; i++)
            System.out.print(ans[i] + "  ");

    }
    static int[]maxSlidingWindowOptimal(int[] arr, int k){
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        int[] result = new int[n-k+1];
        int resultIndex =0;
        for(int i = 0; i < n; i++){
            //remove the out of window element
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }
            //maintain:remove smaller numbers in k range as they are useless
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k-1 && !dq.isEmpty()) {
                result[resultIndex++] = arr[dq.peek()];
            }

        }
        return result;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }

        return result;
    }
}
