package Citdeal;

import java.util.*;

public class ProcessExecution {
    public static int ProcessExcution(int[]arr){
        HashMap<Integer,Integer>m = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        for(int elem:arr){
            if(m.containsKey(elem)){
                m.put(elem,m.get(elem)+1);
            }
            else{
                ret.add(elem);
                m.put(elem,1);
            }
        }
        Collections.sort(ret);
        int[]dp = new int[ret.size()];
        dp[0] = ret.get(0)*m.get(ret.get(0));


        int r = dp[0];
        for(int i = 1;i<dp.length;i++){
            int prev = 0;
            if(ret.get(i)-1==ret.get(i-1)){
                if(i-2>=0){
                    prev = dp[i-2];
                }
            }
            else{
                prev = dp[i-1];
                if(i-2>=0){
                    prev = Math.max(prev,dp[i-2]);
                }
            }
            dp[i] = prev+ret.get(i)*m.get(ret.get(i));
            r = Math.max(dp[i],r);

        }

        return r;
    }

    public static void main(String[] args) {
        int []arr = new int[]{3,3,3,4,4,1,8};
        System.out.println(ProcessExcution(arr));
    }
}
