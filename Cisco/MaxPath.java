package Cisco;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MaxPath {
    public static int MaxPath(int[]x ,int[] y){
        HashMap<Integer,Integer> xMap = new HashMap<>();
        HashMap<Integer,Integer>yMap = new HashMap<>();
        for(int  i = 0;i<x.length;i++){
            xMap.put(x[i],xMap.getOrDefault(x[i],0)+1);
            yMap.put(x[i],yMap.getOrDefault(y[i],0)+1);
        }
        List<Integer> xvalue = new LinkedList<>( xMap.values());
        List<Integer> yvalue = new LinkedList<>( yMap.values());
        Collections.sort(xvalue);
        Collections.sort(yvalue);
        int ret = Math.max(xvalue.get(yvalue.size()-1),yvalue.get(yvalue.size()-1));
        System.out.println(xMap);
        System.out.println(yMap);
        return ret==1?0:ret;
    }

    public static void main(String[] args) {
        int[]x = new int[]{2,3,2,4,2};
        int []y = new int[]{2,2,6,5,8};
        System.out.println(MaxPath(x,y));
    }
}
