package snowflake;

import java.util.Arrays;

public class PalindromicSeq {
    // find all the subseq ->use dp ->
    // dp[i][j] longest p start at i end at j inclusive
    // dp[i][i] = 0; if i>j 0;
    //dp[i][j]: if(i==j)2+dp[i+1][j-1]
    // else math.max(dp[i][j-1],dp[i][j+1])
    public static int maxScore(String s){
        int dp[][] = new int[s.length()][s.length()];
        for(int i = 0;i<s.length();i++)Arrays.fill(dp[i],-1);
       helper(dp,s,0,s.length()-1);
       int max = Integer.MIN_VALUE;
        System.out.println(Arrays.deepToString(dp));
       for(int i = 0;i<s.length()-1;i++){
           max = Math.max(dp[0][i]*dp[i+1][s.length()-1],max);
       }
       return max;
    }
    private static int helper(int[][]dp,String s, int start, int end){
        if(start>end){
            return 0 ;
        }
        if(dp[start][end]!=-1)return dp[start][end];
        if(start==end){
            dp[start][end] =1;
            return 1;
        }
        if(s.charAt(start)==s.charAt(end)){
            dp[start][end] = 2+helper(dp,s,start+1,end-1);
            helper(dp,s,start+1,end);
            helper(dp,s,start,end-1);
            return dp[start][end];
        }
        dp[start][end] = Math.max(helper(dp,s,start+1,end),helper(dp,s,start,end-1));
        return dp[start][end];
    }

    public static void main(String[] args) {
        System.out.println(maxScore("axbawbaseksqke"));
    }

}

//[       [-1, -1, -1, -1, 4, 4, 4],
//        [-1, -1,  2,  2, 2, 2, 3],
//        [-1, -1,  1,  1, 1, 1, -1],
//        [-1, -1, -1,  1, 1, 1, -1],
//        [-1, -1, -1, -1, 1, 1, -1],
//        [-1, -1, -1, -1, -1, 1, -1],
//        [-1, -1, -1, -1, -1, -1, -1
//        ]]