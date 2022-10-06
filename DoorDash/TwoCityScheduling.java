package DoorDash;

import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(x, y)->{
            return Integer.compare(x[0]-x[1],y[0]-y[1]);
        });
        int ret = 0;
        for(int i = 0;i<costs.length/2;i++){
            ret+=costs[i][0];
        }
        for(int i = costs.length/2;i<costs.length;i++){
            ret+=costs[i][1];
        }
        return ret;
    }
}
