package Citdeal;

import java.util.*;

public class SpecialNode {
    public static int[]specialNode(int[]a,int []b, int n){
        if(n==1)return new int[]{1};
        if(n==2)return new int[]{1,1};
        HashMap<Integer, HashSet<Integer>>m = new HashMap<>();
        HashSet<Integer> nodes = new HashSet<>();
        int[]indegree = new int[n];
        for(int  i = 0;i<a.length;i++){
            int[]elem = new int[]{a[i],b[i]};
            m.putIfAbsent(elem[0]-1,new HashSet<>());
            m.get(elem[0]-1).add(elem[1]-1);
            m.putIfAbsent(elem[1]-1,new HashSet<>());
            m.get(elem[1]-1).add(elem[0]-1);
            indegree[elem[0]-1]++;
            indegree[elem[1]-1]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<indegree.length;i++){
            if (indegree[i]==1){
                q.add(i);
            }
            else {
                nodes.add(i);
            }
        }
        while (!q.isEmpty()&&nodes.size()>2){
            int qsize = q.size();
            for(int i = 0;i<qsize;i++){
                int front = q.remove();
                for(int bei: m.getOrDefault(front,new HashSet<>())){
                    if(nodes.contains(bei)){
                        indegree[bei]--;
                        if (indegree[bei]==1){
                            q.add(bei);
                            nodes.remove(bei);
                        }
                    }
                }
            }
        }
        if(nodes.size()==1){
            for(int node:nodes) {
                List<Integer>result = bfs(node,m);
                int[] ret = new int[n];
                for (int elem:result){
                    ret[elem]=1;
                }
                return ret;
            }
        }
        else {
            Integer[] t =nodes.toArray(new Integer[0]);
            m.get(t[0]).remove(t[1]);
            m.get(t[1]).remove(t[0]);
            List<Integer>result = bfs(t[0],m);
            result.addAll( bfs(t[1],m));
            int[] ret = new int[n];
            for (int elem:result){
                ret[elem]=1;
            }
            return ret;
        }
        return null;

    }

    private static List<Integer> bfs(Integer integer, HashMap<Integer, HashSet<Integer>> m) {
        Queue<Integer>q = new LinkedList<>();
        HashSet<Integer>visited = new HashSet<>();
        q.add(integer);
        List<Integer>ret = null;
        visited.add(integer);
        while (!q.isEmpty()){
            int qsize = q.size();
            List<Integer>curLevel = new ArrayList<>(qsize);
            for (int i = 0;i<qsize;i++){
                int front = q.remove();
                curLevel.add(front);
                for(int nei: m.getOrDefault(front,new HashSet<>())){
                    if (!visited.contains(nei)){
                        visited.add(nei);
                        q.add(nei);
                    }
                }
            }
            ret = curLevel;

        }
        return ret;
    }

    public static void main(String[] args) {
        int[][]edge = new int[][]{{1,2}};
        int []a = new int[]{1, 2, 3, 3, 1, 1};
        int []b = new int[]{2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(specialNode(a,b, 7)));
    }
}
