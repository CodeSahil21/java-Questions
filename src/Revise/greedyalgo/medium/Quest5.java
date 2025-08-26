package Revise.greedyalgo.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Quest5 {
    public static void main(String[] args) {
            int n = 6;
            int[] start = {1,3,0,5,8,5};
            int[] end = {2,4,5,7,9,9};
            maxMeetings(start,end,n);


    }
    static void maxMeetings(int[] start, int[] end ,int n){
        ArrayList<Meeting> meet = new ArrayList<>();
        for(int i = 0 ; i < n;i++){
            meet.add(new Meeting(start[i],end[i],i+1));
        }
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meet,mc);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        for(int i = 1; i < n;i++){
            if(meet.get(i).start > limit ){
                limit = meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        System.out.println("The order in which the meetings will be performed is ");
        for(int i = 0 ; i < ans.size();i++){
            System.out.println(ans.get(i)+ " ");
        }

    }
}
class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int start,int end,int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class MeetingComparator implements Comparator<Meeting>
{
    @Override
    public int compare(Meeting o1, Meeting o2)
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1;
    }
}