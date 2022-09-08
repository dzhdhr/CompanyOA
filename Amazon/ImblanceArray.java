package Amazon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ImblanceArray {
    public static int imbalanceArray(int []nums){
        Arrays.sort(nums);
        int [] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater,nums.length);

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<nums.length;i++){
            while (!queue.isEmpty()&&nums[queue.peek()]<nums[i]-1){
                int front = queue.remove();
                nextGreater[front] = i;
            }
            queue.add(i);
        }
        queue.clear();
        int [] prevLess = new int[nums.length];
        Arrays.fill(prevLess,-1);
        for(int i = nums.length-1;i>=0;i--){
            while (!queue.isEmpty()&&nums[queue.peek()]-1>nums[i]){
                int front = queue.remove();
                prevLess[front] = i;
            }
            queue.add(i);
        }
        int ret = 0;
       for(int i = 0;i<nums.length;i++){
//           int leftBound = prevLess[i];
//           int rightBound = nextGreater[i];
//           int length = (leftBound+1)*(int)Math.pow(nums.length-i-1,2)+(nums.length-rightBound)*(int)Math.pow(i,2);
//            System.out.printf("%d can offer %d\n",nums[i],length);
//           ret = ret +(leftBound+1)*(int)Math.pow(nums.length-i-1,2)+(nums.length-rightBound)*(int)Math.pow(i,2);
           int nextGreaterElement = nextGreater[i];

           int totalSubset = (int) Math.pow(2,nums.length-nextGreaterElement)-1;
           System.out.printf("%d can offer %d\n",nums[i],totalSubset);
           ret+= totalSubset;
       }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(imbalanceArray(new int[]{3,5,7,9}));
    }
}
