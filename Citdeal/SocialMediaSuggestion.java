package Citdeal;

import java.util.*;

public class SocialMediaSuggestion {
    public static int[]socailMediaSuggestion(int n,int[][]edges){
        HashMap<Integer,HashSet<Integer>>graph = new HashMap<Integer, HashSet<Integer>>();
        for(int[]e:edges){
            graph.putIfAbsent(e[0],new HashSet<>());
            graph.get(e[0]).add(e[1]);

            graph.putIfAbsent(e[1],new HashSet<>());
            graph.get(e[1]).add(e[0]);
        }
        System.out.println(graph);
        HashMap<Integer,Integer>[]results = new HashMap[n];
        for(int []e:edges){
            int nei = e[1];
            if(results[e[0]]==null)results[e[0]] = new HashMap<>();
            for(int elem:graph.getOrDefault(nei,new HashSet<>())){
                if(elem!=e[0]&&!graph.getOrDefault(e[0],new HashSet<>()).contains(elem)){
                    results[e[0]].put(elem,results[e[0]].getOrDefault(elem,0)+1);
                }
            }
            nei = e[0];
            if(results[e[1]]==null)results[e[1]] = new HashMap<>();
            for(int elem:graph.getOrDefault(nei,new HashSet<>())){
                if(elem!=e[1]&&!graph.getOrDefault(e[1],new HashSet<>()).contains(elem)){
                    results[e[1]].put(elem,results[e[1]].getOrDefault(elem,0)+1);
                }
            }
        }
        System.out.println(Arrays.toString(results));
        int[]ret = new int[n];
        Arrays.fill(ret,-1);
        for(int  i =0;i<n;i++){
            if(results[i]!=null){
                int index = -1;
                for(int key:results[i].keySet()){
                    if(results[i].get(key)>results[i].getOrDefault(index,-1)){
                        index = key;
                    }
                    else if(results[i].get(key)==results[i].getOrDefault(index,-1)){
                        index = Math.min(index,key);
                    }

                }
                ret[i] = index;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][]r = new int[][]{{0,1},{1,2},{2,0}};
        int[][]r2 = new int[][]{{0,1},{0,2},{1,3},{2,3},{3,4}};
        int[][]r3 = new int[][]{{0,1},{0,2}};
        System.out.println(Arrays.toString(socailMediaSuggestion(5, r2)));
    }
}
