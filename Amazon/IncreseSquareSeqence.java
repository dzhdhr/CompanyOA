package Amazon;

import java.util.HashMap;
import java.util.HashSet;

public class IncreseSquareSeqence {
    static HashMap<Integer,Integer> visited = new HashMap<>();
    static HashSet<Integer> g;
    public static int increaseSquareSeqence(HashSet<Integer> set){
        int ret = Integer.MIN_VALUE;
        g = set;
        for(int elem:set){

            int length = dfs(elem);
            ret = Math.max(length,ret);
        }
        System.out.println(visited);
        return ret;

    }
    static int dfs(int elem){
        if(visited.containsKey(elem)){
            return visited.get(elem);
        }
        int next = elem *elem;
        if (g.contains(next)){
            int length = dfs(next)+1;
            visited.put(elem,length);
            return length;
        }
        visited.put(elem,1);
        return 1;

    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(8);
        set.add(9);
        set.add(16);
        set.add(4);
        set.add(3);
        set.add(81);
        set.add(6561);
//        set.add(2);
        System.out.println(increaseSquareSeqence(set));
    }
}
