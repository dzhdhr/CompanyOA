package Citdeal;

import java.util.LinkedList;
import java.util.Queue;

public class KnightMoves {
    private static final int[][] dirs = new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
    public static int miniMove(int n, int startX, int startY, int endX, int endY){
//        int[][]board = new int[n][n];
        boolean [][]visited = new boolean[n][n];
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{startX,startY});
        visited[startX][startY] = true;
        int count = 0;
        while (!q.isEmpty()){
            int qsize = q.size();
            for(int i = 0;i<qsize;i++){
                int[]front = q.remove();
                if(front[0]==endX&&front[1]==endY)return count;
                for(int[]dir:dirs){
                    int nextX = dir[0]+front[0];
                    int nextY = dir[1]+front[1];
                    if(inArea(nextX,nextY,visited)){
                        if(!visited[nextX][nextY]){
                            visited[nextX][nextY] = true;
                            q.add(new int[]{nextX,nextY});
                        }
                    }
                }
            }
            count++;
        }
        return -1;

    }

    private static boolean inArea(int nextX, int nextY, boolean[][] visited) {
        return nextX<visited.length&&nextY<visited[0].length&&nextY>=0&&nextX>=0;
    }

    public static void main(String[] args) {
        System.out.println(miniMove(10,0,0,0,2));
    }
}
