package DRW;

import java.util.*;

public class MovePackage {
    public static boolean canMove(int[]A, int []P,int B, int E){
        List<int[]> interval = new ArrayList<>(A.length);
        for(int i = 0;i<A.length;i++){
            int start = P[i]-A[i];
            int end = P[i]+A[i];
            interval.add(new int[]{start,end});
            //System.out.println(start+" "+end);
        }
        interval.sort(Comparator.comparingInt(x -> x[0]));
        List<int[]> ret = new LinkedList<>();
        int start =interval.get(0)[0];
        int end = interval.get(0)[1];
        for (int i = 1;i<interval.size();i++){
            int curStart = interval.get(i)[0];
            int curEnd = interval.get(i)[1];
            if(curStart<=end){ //in range
                end = Math.max(end,curEnd);
            }
            else{
                ret.add(new int[]{start, end});
                end = curEnd;
                start = curStart;
            }
        }
        ret.add(new int[]{start, end});
        for (int[] a:ret){
           if(a[0]<=B&&a[1]>=E)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canMove(new int[]{2, 1}, new int[]{5, 1}, 2, 6));
    }
}
