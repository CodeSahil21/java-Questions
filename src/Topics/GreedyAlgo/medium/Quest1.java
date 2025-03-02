package Topics.GreedyAlgo.medium;
import java.util.*;
//https://www.geeksforgeeks.org/problems/shortest-job-first/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-job-first
public class Quest1 {
    public static void main(String[] args) {
        int[] jobs = {4, 3, 7, 1, 2};

        System.out.print("Array Representing Job Durations: ");
        for (int i = 0; i < jobs.length; i++) {
            System.out.print(jobs[i] + " ");
        }
        System.out.println();

        float ans = averageWaitingtime(jobs);
        System.out.println("Average waiting time: " + ans);
    }
    public static float averageWaitingtime(int[] arr){
        Arrays.sort(arr);
        float waitTime = 0;
        int totalTime = 0;
        for (int i = 0; i < arr.length; i++) {
            waitTime += totalTime;
            totalTime += arr[i];
        }
        return waitTime/arr.length;
    }
}
