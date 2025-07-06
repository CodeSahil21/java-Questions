package Revise.Arrays.Hard;

import java.util.Arrays;

public class Quest8 {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge(arr1,arr2,n,m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
    static void merge(int[] arr1,int[] arr2,int n,int m){
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while(gap > 0){
            int left = 0;
            int right =  left+gap;
            while(right < len){
                if(left < n && right >= n){
                     swapIfgreater(arr1,arr2,left,right-n);
                }else if(left >= n){
                    swapIfgreater(arr2,arr2,left-n,right-n);
                }else{
                    swapIfgreater(arr1,arr1,left,right);
                }
                left++;
                right++;
            }
            if(gap == 1){
                break;
            }
            gap = (gap /2) + (gap % 2);
        }
    }
    public static void swapIfgreater(int[] arr1,int[] arr2,int m, int n){
        if(arr1[m] > arr2[n]){
            int temp = arr1[m];
            arr1[m] = arr2[n];
            arr2[n] = temp;
        }
    }
    static void mergeP1(int[] arr1,int[] arr2,int n ,int m){
     int left = n-1;
     int right = 0;
     while(left >= 0 && right < m){
         if(arr1[left] >arr2[right]){
             int temp = arr1[left];
             arr1[left] = arr2[right];
             arr2[right] = temp;
             right++;
             left--;
         }else{
             break;
         }
     }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
