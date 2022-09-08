package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximaCount {
    public static int MaxiumCount(int[]array){
        HashMap<Integer, Integer> elemtoTime = new HashMap<>();
        HashMap<Integer, Integer>elemtoMaxTime = new HashMap<>();
        int maxTime = -1;
        for(int elem:array){
            elemtoTime.put(elem,elemtoTime.getOrDefault(elem,0)+1);
            maxTime = Math.max(elemtoTime.get(elem),maxTime);
            for (int k:elemtoTime.keySet()){
                if (elemtoTime.get(k)==maxTime){
                    elemtoMaxTime.put(k,elemtoMaxTime.getOrDefault(k,0)+1);
                }
            }
        }
        System.out.println(elemtoMaxTime);
       int max = Integer.MIN_VALUE;
        for (int k:elemtoTime.keySet()){
            max = Math.max(elemtoMaxTime.get(k),max);
        }
        return max;
    }
    public static int MaxmCount(int[]arrray){
            HashMap<Integer, HashSet<Integer>> coutToElem = new HashMap<>();
            HashMap<Integer,Integer> freqCount = new HashMap<>();
            PriorityQueue<Integer>count = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
            Map<Integer,Integer> elemToMaxium = new HashMap<>();
            for(int elem: arrray){
                if(freqCount.containsKey(elem)){
                    coutToElem.get(freqCount.get(elem)).remove(elem);
                }
                freqCount.put(elem,freqCount.getOrDefault(elem,0)+1);
                coutToElem.putIfAbsent(freqCount.get(elem),new HashSet<>());
                coutToElem.get(freqCount.get(elem)).add(elem);
                count.offer(freqCount.get(elem));
                HashSet<Integer> largest = coutToElem.get(count.peek());
                for (int integer : largest) {
                    elemToMaxium.put(integer,elemToMaxium.getOrDefault(integer,0)+1);
                }
            }
        System.out.println(elemToMaxium);
        System.out.println(freqCount);
        int ret = Integer.MIN_VALUE;
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(MaxmCount(new int[]{1,1, 2, 3, 4, 4,3,3,2,2,2,2}));
        System.out.println(MaxiumCount(new int[]{1,1, 2, 3, 4, 4,3,3,2,2,2,2}));
    }
}
