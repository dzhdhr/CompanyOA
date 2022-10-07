package DoorDash;

import java.util.List;

public class Dijkstra {
    private int[]dijsktra(int [][]matrix, int sourcepoint){
        int numberOfVex = matrix.length;
        int[] distance =new int[matrix.length];
        boolean []flag = new boolean[matrix.length];
        for (int i = 0; i < numberOfVex; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。
            distance[i] = matrix[sourcepoint][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }
        flag[sourcepoint] = true;
        distance[sourcepoint] = 0;
        int k=0;
        for (int i = 1; i < numberOfVex; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < numberOfVex; j++) {
                if (!flag[j] && distance[j]<min) {
                    min = distance[j];
                    k = j;
                }
            }

            flag[k] = true;

            for (int j = 0; j <numberOfVex; j++) {
                int tmp = (matrix[k][j]==Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + matrix[k][j]));
                if (!flag[j] && (tmp<distance[j]) ) {
                    distance[j] = tmp;
                }
            }
        }
        return distance;
    }
    public int shorestBetweenThreePoint(int roadsNotes, List<Integer> roadsFrom, List<Integer> roadsTo, List<Integer> roadsWeight, int a, int b, int c){
        int [][]matrix = new int[roadsNotes][roadsNotes];
        //int[][] adjMatrix = new int[roadsNotes][roadsNotes];
        for(int i = 0; i < roadsFrom.size(); i++) {
            matrix[roadsFrom.get(i)][roadsTo.get(i)] = roadsWeight.get(i);
            matrix[roadsTo.get(i)][roadsFrom.get(i)] = roadsWeight.get(i);
        }
        int []distanceA = dijsktra(matrix,a);
        int []distanceB = dijsktra(matrix,b);
        int []distanceC = dijsktra(matrix,c);
        int ret = Integer.MAX_VALUE;
        for(int i = 0;i<roadsNotes;i++){
            int da = distanceA[i];
            int db = distanceB[i];
            int dc = distanceC[i];
            if(da==Integer.MAX_VALUE||db==Integer.MAX_VALUE||dc==Integer.MAX_VALUE)continue;
            ret = Math.min(da+db+dc,ret);
        }
        return ret;
    }
}
