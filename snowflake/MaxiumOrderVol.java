package snowflake;
import java.util.Arrays;
public class MaxiumOrderVol {
    static class Node {
        int startTime;
        int endTime;
        int profit;
        public Node(int startTime, int endTime,int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }


    static public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[]dp;
        dp = new int[endTime.length];
        Arrays.fill(dp,-1);
        Node[]order = new Node[endTime.length];
        for(int i = 0;i<endTime.length;i++){
            order[i] = new Node(startTime[i],startTime[i]+endTime[i],profit[i]);
        }
        Arrays.sort(order,(x,y)->{
            return Integer.compare(x.startTime,y.startTime);
        });
        int ret = 0;
        dp[endTime.length-1] = order[endTime.length-1].profit;
        for(int i = endTime.length-2;i>=0;i--){
            int max = dp[i+1];
            int searchResult = bs(order,order[i].endTime,i+1);
            //System.out.println(searchResult);
            int prev = searchResult==-1?0:dp[searchResult];
            dp[i] = Math.max(max,prev+order[i].profit);
            ret = Integer.max(ret,dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return ret;
    }
    private static int bs(Node []task,int endTime,int start){
        int left = start;
        int right = task.length-1;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(task[mid].startTime>endTime){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        if(task[left].startTime>endTime)return left;
        if(task[right].startTime>endTime)return right;
        return -1;
    }

    public static void main(String[] args) {
        int[]startTime = new int[]{10,5,15,18,30};
        int[]endTime = new int[]{30,12,20,35,35};
        int[]Duration = new int[]{50,51,20,25,10};
        System.out.println(jobScheduling(startTime,endTime,Duration));
    }
}
