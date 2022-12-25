package snowflake;

//
public class StringPattern {
    //dp[i][j]
    // dp[i][j] possible combianton with length n and continue of j
    //dp[i][0] = sum of(dp[i-1][0-k])*21
    //if i<jreturn 0;
    //if dp[i][j] = dp[i-1][j-1]*5
    // if j==1
    //return dp[i][0]-k
    private static long power(long n, int p){
        long ret = 1;
        for(int i = 0;i<p;i++)ret*=n;
        return ret;
    }
    private static final int MOD  = 1000000000+7;
    public static int Combiantion(int n, int k){
        long[][]dp = new long[n+1][k+1];
        long sum = 1;
        for(int i = 1;i<=n;i++){

            dp[i][0] = sum*21;
            sum = dp[i][0];

            for(int j = 1;j<=k;j++){
                if(j>i)dp[i][j] = 0;
                else if(j==i)dp[i][j] = power(5,i);
                else {
                    dp[i][j] = dp[i - 1][j - 1]*5;
                }
                sum += dp[i][j];
            }
        }
        return (int) (sum%MOD);
    }

    public static void main(String[] args) {
        System.out.println(Combiantion(2,1));
    }
}
