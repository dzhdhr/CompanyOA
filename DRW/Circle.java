package DRW;

import java.util.HashMap;
import java.util.HashSet;

public class Circle {
    public static boolean hasCircle(int[]a, int [] b){
        HashMap<Integer, HashSet<Integer>>graph = new HashMap<>();
        HashSet<Integer>nodes = new HashSet<>();
        for(int i= 0;i<a.length;i++){
            graph.putIfAbsent(a[i],new HashSet<>());
            graph.get(a[i]).add(b[i]);
            nodes.add(a[i]);
            nodes.add(b[i]);
        }
        nodes.remove(a[0]);
        return dfs(nodes,a[0],a[0],graph,nodes.size());
    }
    private static boolean dfs(HashSet<Integer>nodes,int start, int cur,HashMap<Integer,HashSet<Integer>>graph,int remainNode){

        for(int nei:graph.getOrDefault(cur,new HashSet<>())){
            if(nei==start&&remainNode==0){
                return true;
            }
            if(nodes.contains(nei)){
                nodes.remove(nei);
                if(dfs(nodes,start,nei,graph,remainNode-1)){
                    nodes.add(nei);
                    return true;
                }
                nodes.add(nei);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]a = new int[]{1,3,2,4,1};
        int[]b = new int[]{4,1,3,2,2};
        System.out.println(hasCircle(a, b));
    }
}
