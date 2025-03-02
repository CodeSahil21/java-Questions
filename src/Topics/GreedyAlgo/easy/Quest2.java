package Topics.GreedyAlgo.easy;
//https://leetcode.com/problems/lemonade-change/description/
public class Quest2 {
    public static void main(String[] args) {
   int[] arr =  {5,5,5,10,20};
        System.out.println(lemonadeChange(arr));
    }
    public static boolean lemonadeChange(int[] bills) {
      int five = 0;
      int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5){
                five = five+1;
            }else if(bills[i] == 10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if(five>= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
   return true;
    }
}
