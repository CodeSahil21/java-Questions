package Topics.Arrays.Extra;
//https://leetcode.com/problems/container-with-most-water/
public class Quest1 {
    public static void main(String[] args) {

    }
    public int maxArea(int[] height) {
      int maxArea = 0;
      int n = height.length;
      for(int i = 0 ; i < n; i++){
          for(int j = i+1 ; j<n;j++){
              int width = j-i;
              int h = Math.min(height[i],height[j]);
              int currAns = width*h;
              maxArea = Math.max(maxArea,currAns);
          }
      }
      return maxArea;
    }
    public static int maxAreaON(int[] height) {
        int maxArea = 0;
        int left = 0;
        int n = height.length;
        int right = n-1;
        while(left <= right){
            int width = right - left;
            int h = Math.min(height[left],height[right]);
            int currAns = width*h;
            maxArea = Math.max(maxArea,currAns);
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
