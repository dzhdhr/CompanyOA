package blackrock;



import java.util.*;

public class Currency {
    public static class Node{
        double val;
        String target;
        public Node(String target,double val){
            this.val = val;
            this.target = target;
        }
    }
    public static double exchangeCurrency(String[][]edge, String start,String end){
        HashMap<String, List<Node>> graph = new HashMap<>();
        for(String[] elem:edge){
            graph.putIfAbsent(elem[0],new ArrayList<>());
            graph.get(elem[0]).add(new Node(elem[1],Double.parseDouble(elem[2])));
        }
        HashMap<String,Double>visited = new HashMap<>();
        Queue<Node>q = new LinkedList<>();
        q.add(new Node(start,1));
        visited.put(start,1.0);
        while(!q.isEmpty()){
            Node front = q.remove();
            for(Node nei:graph.getOrDefault(front.target,new ArrayList<>())){
                double newResult = nei.val* front.val;
                if(newResult>visited.getOrDefault(nei.target,0.0)){
                    visited.put(nei.target,newResult);
                    q.add(new Node(nei.target,newResult));
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.toString().toCharArray();
        return visited.getOrDefault(end,-1.0);
    }

    public static void main(String[] args) {
        String [][] input = new String[][]{{"USD","GBP","0.7"},{"USD","JPY","109"},{"CAD","CNY","5.27"},{"GBP","JPY","155"},{"CAD","KRW","921"}};
        System.out.println(exchangeCurrency(input, "USD", "JPY"));
    }
}

