package snowflake;

import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

// try to get the MAX MEX as early as possible
// 1. find the globel max
// remove all element until the globel max
// stop until there is no element int the array
public class ArrayReduction {
    private static int MEX (int []arr,int i,int j){
        int ret = 0;
        HashSet<Integer>set = new HashSet<>();
        for(int k=0;k<=j;k++){
            set.add(arr[k]);
            while (set.contains(ret)){
                ret++;
            }
        }
        return ret;
    }
    static int m;
    static int n;
    static public List<List<Integer>> grid;


    public static List<Integer> ArrayRed(int[]arr){
        int MEX = MEX(arr,0,arr.length-1);

        int left = 0,right = arr.length-1;
        List<Integer>ret = new ArrayList<>(arr.length);
        HashMap<Integer,Integer> m = new HashMap<>();
        for (int j : arr) {
            m.put(j, m.getOrDefault(j, 0) + 1);
        }
        while(left<=right){
            System.out.println(left);
            int cur = 0;
            HashSet<Integer>seen = new HashSet<>();
            while(cur!=MEX){
                seen.add(arr[left]);
                m.put(arr[left],m.get(arr[left])-1);
                while(seen.contains(cur))cur++;
                left++;
            }
            if(cur==0)left++;
            ret.add(cur);
            MEX = 0;
            System.out.println(m);
            while(m.getOrDefault(MEX,0)>0)MEX++;

        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(ArrayRed(new int[]{0,1,2,4,5}));
    }
// 0,0,1,2,2,2,3
}
