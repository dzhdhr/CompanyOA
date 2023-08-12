package DRW;

import java.util.Arrays;

public class MaxColROw {
    public static int solution(int[][]a){
     int []rowSum = new int[a.length];
     int sum = 0;
     int []colSum = new int[a[0].length];
     for(int i = 0;i<a.length;i++){
         for(int j = 0;j<a[0].length;j++){
             rowSum[i]+=a[i][j];
             colSum[j]+=a[i][j];
             sum+=a[i][j];
         }
     }
     int ret = Integer.MAX_VALUE;
     for(int i = 0;i<a.length;i++){
         for(int j = 0;j<a[0].length;j++){
             int cur = sum-rowSum[i]-colSum[j]+a[i][j];
             ret = Math.min(ret,cur);
         }
     }
     return ret;
    }

    public static void main(String[] args) {
        int[][]arr = new int[][]{{-4,0,-1},{-8,1,-3},{1,-10,-5}};
        System.out.println(solution(arr));
    }
}
