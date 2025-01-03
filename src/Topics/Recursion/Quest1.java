package Topics.Recursion;
import java.util.*;
//https://youtu.be/un6PLygfXrA?feature=shared
public class Quest1 {
    public static void main(String[] args) {
        //printNameNtimes(1,10,"Sahil");
//         print1toN(1,1000);
        //printNto1(10,1);
        //print1toN2(10);
        print2Nto1(1,100);
    }
    static void printNameNtimes(int i , int n,String name){
                  if(i > n){
                      return;
                  }
        System.out.println(name);
        printNameNtimes(i+1,n,name);
    }
    static void print1toN(int i , int n){
               if(i > n){
                   return;
               }
        System.out.println(i);
               print1toN(i+1,n);
    }
    static void printNto1(int i , int n){
        if(i < n){
            return;
        }
        System.out.println(i);
        printNto1(i-1,n);
    }
    //backtracking
    static void print1toN2(int i ){
        if(i < 1) {
            return;

        }
        print1toN2(i-1);
        System.out.println(i);
    }
    ////backtracking
    static void print2Nto1(int i , int n){
        if(i > n){
            return;
        }
        print2Nto1(i+1,n);
        System.out.println(i);
    }
}
