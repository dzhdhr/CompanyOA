package Cisco;

import java.util.Arrays;
import java.util.HashMap;

public class MeanandMod {
    public static int[] MeanAndMod(int[]arr){
        HashMap<Integer,Integer>counter = new HashMap<>();
        int most = arr[0];
        long sum = 0;
        for(int elem:arr){
            counter.put(elem,counter.getOrDefault(elem,0)+1);
            if(counter.get(elem)>counter.get(most)){
                most =elem;
            }
            sum+=elem;
        }
        return new int[]{(int) (sum/arr.length),most};
    }
    public static void main(String[]args){
        int[]cur = new int[]{1,2,7,3,2};
        System.out.println(Arrays.toString(MeanAndMod(cur)));
    }
}