package Revise.greedyalgo.easy;

public class Quest2 {
    public static void main(String[] args) {
        int[] arr =  {5,5,5,10,20};
        System.out.println(lemonadeChange(arr));
    }

    static boolean lemonadeChange(int[] arr){
        int five = 0;
        int ten = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 5){
                five += 1;
            }else if(arr[i] == 10){
                if(five > 0){
                    five -= 1;
                    ten += 1;
                }else{
                    return false;
                }
            }else{
                if(five >0 && ten  > 0){
                    five -= 1;
                    ten -= 1;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return  false;
                }
            }
        }
        return true;
    }
}
