package Cisco;

import java.util.*;

public class Twin {
    public static int findTwin(int[]arr){
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int elem :arr){
            map.put(elem,map.getOrDefault(elem,0)+1);
        }
        PriorityQueue<Integer>ret = new PriorityQueue<>((x,y)->{
            return Integer.compare(x,y);
        });
        for(int key: map.keySet()){
            if(map.get(key)!=2)ret.offer(key);
        }
      if (ret.isEmpty())return -1;
      return ret.peek();
    }

    public static void main(String[] args) {
        int []ret = new int[]{1,1,2,2};
        System.out.println(findTwin(ret));
    }

}
