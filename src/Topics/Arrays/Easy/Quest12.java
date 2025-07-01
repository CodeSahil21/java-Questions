package Topics.Arrays.Easy;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays
//union of two sorted array
public class Quest12 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> Union = FindUnion(arr1, arr2);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union)
            System.out.print(val+" ");
    }

        static ArrayList<Integer> FindUnion(int arr1[], int arr2[]) {
                int n = arr1.length;
                int m = arr2.length;
            int i = 0, j = 0; // pointers
            ArrayList<Integer > Union=new ArrayList<>(); // Union vector
            while (i < n && j < m) {
                if (arr1[i] <= arr2[j]) // Case 1 and 2
                {
                    if (Union.isEmpty() || Union.get(Union.size()-1) != arr1[i])
                        Union.add(arr1[i]);
                    i++;
                } else // case 3
                {
                    if (Union.isEmpty() || Union.get(Union.size()-1) != arr2[j])
                        Union.add(arr2[j]);
                    j++;
                }
            }
            while (i < n) // IF any element left in arr1
            {
                if (Union.get(Union.size()-1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            }
            while (j < m) // If any elements left in arr2
            {
                if (Union.get(Union.size()-1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
            return Union;
        }

    }




