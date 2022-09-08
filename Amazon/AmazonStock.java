package Amazon;

import java.util.Arrays;

public class AmazonStock {
    public static int findEariestMonth(int []stockPrice){
        int []dp = new int[stockPrice.length+1];
        for(int i = 0;i<stockPrice.length;i++){
            dp[i+1] = dp[i]+stockPrice[i];
        }
        double netChange = Double.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < stockPrice.length-1; i++) {
            double prefix = Math.floor(1.0*(dp[i]+stockPrice[i])/(i+1));
            double post = Math.floor(1.0*(dp[dp.length-1]-dp[i]-stockPrice[i])/(stockPrice.length-i-1));
            if (netChange>Math.abs(prefix-post)){
                netChange = Math.abs(prefix-post);
                ret = i;
            }
        }
        return ret+1;
    }

    public static void main(String[] args) {
        System.out.println(findEariestMonth(new int[]{1, 3, 2, 3}));
    }
}
