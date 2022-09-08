package Amazon;

import java.util.Arrays;

public class NoDecresingPower {
    public static int MinimumPower(int []arr){
        int arrSize = arr.length;
        int dp[] = new int[arrSize];
        for (int i = 1; i < arrSize; i++) {
            dp[i] = dp[i-1]+Math.max(arr[i-1]-arr[i],0);
        }
        System.out.println(Arrays.toString(dp));
        return dp[arrSize-1];
    }

    public static void main(String[] args) {
        System.out.println(MinimumPower(new int[]{3, 4, 1, 9, 2}));
    }
}
