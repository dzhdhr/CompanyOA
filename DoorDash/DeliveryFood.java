package DoorDash;

import java.util.Arrays;

public class DeliveryFood {
    private double[][] memo;
    public  double deliveryFood (int[]distance, int[]parkTime, int walkSpeed, int carSpeed){
        memo = new double[distance.length][distance.length];
        for (int i = 0;i<distance.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(distance,walkSpeed,parkTime,carSpeed,0,0)+parkTime[0];
    }
    private double helper(int []distance, int walkSpeed,int []parkTime, int carSpeed,int curPosition, int target){
        if(target>=distance.length){
            return 1.0*(distance[target-1]-distance[curPosition])/carSpeed;
        }
        if(memo[curPosition][target]!=-1)return memo[curPosition][target];
        double walkTime = 1.0*(distance[target]-distance[curPosition])/walkSpeed*2+helper(distance,walkSpeed,parkTime,carSpeed,curPosition,target+1);
        double DriveTime = 1.0*(distance[target]-distance[curPosition])/carSpeed+parkTime[target]+helper(distance,walkSpeed,parkTime,carSpeed,target,target+1);
        memo[curPosition][target] = Math.min(walkTime,DriveTime);
        return  memo[curPosition][target];

    }

    public static void main(String[] args) {
        int[]r = new int[]{0,3,5,10,15};
        int []p = new int[]{3,3,4,5,1};
        int ws = 1;
        int ds = 2;
        System.out.println(new DeliveryFood().deliveryFood(r,p,ws,ds));
    }
}
