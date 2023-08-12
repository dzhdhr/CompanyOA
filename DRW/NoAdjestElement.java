package DRW;

import java.util.Arrays;

public class NoAdjestElement {
    private static int helper(int[]array){
        int[]dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0],array[1]);
        dp[2] = Math.max(array[0]+array[2],array[1]);
        for(int i = 3;i<array.length;i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-3]+array[i],dp[i-2]+array[i]));

        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];

    }

    public static void main(String[] args) {
        System.out.println(helper(new int[]{-3,0,-6,-7,-9,-5,-2,-6}));
    }
}
