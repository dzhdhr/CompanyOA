package snowflake;

import java.util.HashMap;

/*
* The data analysts of Hackerland want to schedule some long-running tasks on remote servers optimally to minimize the cost of running them locally. The analysts have two servers, a paid one and a free one. The free server can be used only if the paid server is occupied.
The ith task is expected to take timeli/ units of time to complete and the cost of processing the task on the paid server is cost/il. The task can be run on the free server only if some task is already running on the paid server. The cost of the free server is 0 and it can process any task in 1 unit of time.
Find the minimum cost to complete all the tasks if tasks are scheduled optimally.
Example
Suppose n = 4, cost = [1, 1, 3, 4] and time = [3, 1, 2, 3]
The first task must be scheduled on the paid server for a cost of 1 and it takes 3 units of time to complete. In the meantime, the other three tasks are executed on the free server for no cost as the free server takes only 1 unit to complete any task. Return the total cost, 1.
* */
/*
* // helper(time, index) number of time it take to finish index-length task
//base case if index==server.length return 0
//subproblem: cur task use free server helper(time-1,index+1)
// cur task use paid machine cost[index]+ helper(time+time[index],index-1)
//return min of the subproblem
* */
public class TaskSchele {
    static HashMap<Integer,Long> m[];
    private static long helper(int timeRemain, int index, int[]time,int[]cost) {
        if(index==time.length&&timeRemain>=0)return 0;
        else if(index==time.length)return -1;
        if(m[index].containsKey(timeRemain))return m[index].get(timeRemain);
        if(timeRemain>=cost.length-index)return 0;
        long useFreeCost = helper(timeRemain-1,index+1,time,cost);
        long usePaidCost = helper(timeRemain+time[index],index+1,time,cost);
        if(usePaidCost==-1&&useFreeCost==-1)return -1;
        if(usePaidCost==-1)return useFreeCost;
        if(useFreeCost==-1)return (long)cost[index]+usePaidCost;
        long ret = Math.min(useFreeCost,usePaidCost+cost[index]);
        m[index].put(timeRemain,ret);
        return ret;
    }

    public static void main(String[] args) {

        int time[] = new int[]{1,2,3,2};
        int[]cost = new int[]{1,2,3,2};
        m = new HashMap[time.length];
        for(int i = 0;i<time.length;i++){
            m[i] = new HashMap<>();
        }
        System.out.println(helper(0, 0, time, cost));
    }
}
