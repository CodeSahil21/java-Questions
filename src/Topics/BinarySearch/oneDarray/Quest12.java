package Topics.BinarySearch.oneDarray;
//https://leetcode.com/problems/find-peak-element/
public class Quest12 {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in the decscending part of array
                // this may be the answer but look at left
                // this why end != mid -1
                end = mid;
            } else {
                // you are in ascending order
                start = mid +1 ; // because we know that mid + 1 element > mid elemnt
            }
        }
        // in the end start == end pointing the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence when they are pointing to one element ie max element because that is what check says
        // mor elaboration : at every point of start and end they have  the best possible answer till that time
        // and iwe are saying that only one item is remaining, hence cuz of above line that is the best possible answer
        return  start; //or return end as both are equal
    }
}
