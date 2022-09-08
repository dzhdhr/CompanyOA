package Amazon;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NumberofDecresingSubarray {
    public static int numberOfDec(int[] ranging){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] nextGreater = new int[ranging.length];
        Arrays.fill(nextGreater,ranging.length);
        for(int i =0 ;i<ranging.length;i++){
            while (!stack.isEmpty()&&ranging[stack.peek()]<=ranging[i]){
                int front = stack.pop();
                nextGreater[front] = i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(nextGreater));
        int ret = 0;
        for(int i = 0;i<nextGreater.length;i++){
            ret+=nextGreater[i]-i;
        }
        return ret;
    }
    public static void main(String[] args) {
        int []in = new int[]{4,3,5,4,3};
        System.out.println(numberOfDec(in));

    }
}
