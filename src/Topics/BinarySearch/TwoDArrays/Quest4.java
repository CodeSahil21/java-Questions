package Topics.BinarySearch.TwoDArrays;
//https://leetcode.com/problems/find-a-peak-element-ii/description/
public class Quest4 {
    public static void main(String[] args) {

    }
    static int findMaxIndex(int[][] mat,int col){
        int maxvalue= -1;
        int index = -1;
        for (int i = 0; i < mat.length; i++) {
            if(mat[i][col] > maxvalue){
                maxvalue = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    public  static int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat[0].length-1;
        while(start <= end){
            int mid = (start+end)/2;
            int maxRowIndex = findMaxIndex(mat,mid);
            int left = mid-1 >= 0 ? mat[maxRowIndex][mid-1]:-1;
            int right = mid+1 < mat[0].length ? mat[maxRowIndex][mid+1]:-1;
            if(mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right){
                return new int[] {maxRowIndex,mid};
            }
            if(mat[maxRowIndex][mid] < left){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return new int[] {-1,-1};
    }
}
