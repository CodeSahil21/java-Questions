package Revise.Arrays.Medium;

public class Quest8 {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,2,3,4};
        int result = findMin(arr);
        System.out.println(result);
    }

    static int findMin(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        int pivot = findPivot(arr);
        return arr[pivot+1];
    }
    static int findPivot(int[] arr){
        int start = 0 ;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(mid > start && arr[mid-1] > arr[mid]){
                return mid-1;
            }
            if(arr[mid] >arr[start]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
    static int binarySearch(int[] arr,int target,int start,int end){
        while(start <= end){
            int mid =  start + (end - start)/2;
            if(target > arr[mid]){
                start = mid +1;
            }else if( target < arr[mid]){
                end = mid-1;
            }else if(target == arr[mid]){
                return mid;
            }

        }
        return -1;
    }
}
