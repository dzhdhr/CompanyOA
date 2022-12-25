package snowflake;

import java.util.Arrays;

public class SubGrib {
    public static int LargestSubGrid(int[][]grid, int maxSum){
        int [][]preSum = new int[grid.length+1][grid[0].length+1];
        for(int i = 1;i<= grid.length;i++){
            for(int j = 1;j<=grid[0].length;j++){
                preSum[i][j] = preSum[i][j-1]+preSum[i-1][j]-preSum[i-1][j-1]+grid[i-1][j-1];
            }
        }
        System.out.println(Arrays.deepToString(preSum));
        //binary Search, search for right most element such that all the grid sum are less than cur element
        int left =  0, right = grid.length;
        while(left<right-1){
            int mid = left+(right-left)/2;
            int maxsum = findMax(preSum,mid);
            if(maxsum<=maxSum){
                left = mid;
            }
            else{
                right = mid-1;
            }
        }
       if(findMax(preSum,right)<=maxSum)return right;
       return left;

    }

    private static int findMax(int[][] preSum, int mid) {
        int ret = 0;
        for(int i = mid;i<preSum.length;i++){
            for(int j = mid;j<preSum.length;j++){
                ret = Math.max(preSum[i][j]-preSum[i-mid][j]-preSum[i][j-mid]+ preSum[i-mid][j-mid],ret);
            }
        }
        System.out.println(mid+" "+ret);
        return ret;
    }

    public static void main(String[] args) {
        int[][]arr = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(LargestSubGrid(arr, 4));
    }
}
/*
* [[0, 0, 0, 0],
* [0, 2, 6, 14],
* [0, 3, 7, 11],
* [0, 4, 9, 15]]
* */