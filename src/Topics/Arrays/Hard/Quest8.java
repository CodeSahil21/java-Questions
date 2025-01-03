package Topics.Arrays.Hard;
//https://leetcode.com/problems/merge-sorted-array/
public class Quest8 {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        int m = 4, n = 3;
        merge(arr1,m ,arr2,n);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int len = n+m;
            int gap = (len/2) + (len % 2);//to select gap ir=e cieling
            while(gap > 0){
                int left = 0;
                int right = left+gap;
                while(right < len){
                    if(left < m && right >= m ){
                        swapIfgreater(nums1,nums2,left,right-m);
                    }else if( left >= n){
                        swapIfgreater(nums2,nums2,left-m,right-m);
                    }else{
                        swapIfgreater(nums1,nums1,left,right);
                    }
                    left++;
                    right++;
                }
                if(gap == 1){
                    break;
                }
                // Otherwise, calculate new gap:
                gap = (gap / 2) + (gap % 2);
            }
        System.arraycopy(nums2, 0, nums1, m, n);

    }
    public static void swapIfgreater(int[] arr1,int[] arr2,int m, int n){
        if(arr1[m] > arr2[n]){
            int temp = arr1[m];
            arr1[m] = arr2[n];
            arr2[n] = temp;
        }
    }

}
