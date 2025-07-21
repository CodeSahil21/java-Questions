package Revise.StackAndQueues.Questions;

import java.util.ArrayList;
import java.util.List;
public class Quest7 {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] result = asteroidCollision(asteroids);
        for (int asteroid : result) {
            System.out.print(asteroid + " ");
        }
    }
    static  int[] asteroidCollision(int[] arr){
       List<Integer> list = new ArrayList<>();
       int n = arr.length;
       for(int i = 0 ; i < arr.length; i++){
           if(arr[i] > 0){
               list.add(arr[i]);
           }else{
               while(!list.isEmpty() && list.get(list.size()-1) > 0 && list.get(list.size()-1) < Math.abs(arr[i])){
                   list.remove(list.size()-1);
               }
               if(!list.isEmpty() && list.get(list.size() -1) == Math.abs(arr[i])){
                   list.remove(list.size()-1);
               }else  if(list.isEmpty() || list.get(list.size()-1) < 0){
                   list.add(arr[i]);
               }
           }
       }
       int[] result = new int[list.size()];
       for(int i = 0 ; i < list.size(); i++){
           result[i] = list.get(i);
       }

        return  result;
    }
}
