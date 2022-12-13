package DoorDash;

import java.util.ArrayDeque;
import java.util.Arrays;

public class KthGreaterElement {
    public static int[] kthGreaterElements(int[]arrs, int k){
        int []ret = new int[arrs.length];
        // non increasing stack,
        int []nextGreatest = new int[arrs.length];
        Arrays.fill(nextGreatest,-1);
        ArrayDeque<Integer>stack = new ArrayDeque<>();
        for(int i = 0;i<arrs.length;i++){
            while(!stack.isEmpty()&&arrs[stack.peek()]<arrs[i]){
                int front = stack.pop();
                nextGreatest[front] = i;
            }
            stack.push(i);
        }
        for(int i = 0;i<arrs.length;i++){
            int index = nextGreatest[i];
            for(int j= 1;j<k;j++){
                if(index==-1)break;
                index = nextGreatest[index];
            }
            ret[i] = index;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthGreaterElements(new int[]{3,4,2,6,5}, 2)));
    }
}
