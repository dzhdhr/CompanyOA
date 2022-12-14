package Cisco;

import java.util.Arrays;

public class DigitSum {
    public static int DigitSum(int x, int y){
        int[]dp = new int[x+2];
        for(int i = 0;i<dp.length;i++){
            dp[i] = dp[i/10]+i%10;
        }
        System.out.println(Arrays.toString(dp));
        int ret = 0;
        for(int i = 1;i<dp.length;i++){
            if(dp[i]==y){ret++;
                System.out.println(i);};
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(DigitSum(100,6));
    }
}
