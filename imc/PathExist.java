package imc;

import java.util.Arrays;

public class PathExist {
    private static boolean isPefectSquare(int x){
        if (x>=0){
            int sqrt = (int)Math.sqrt(x);
            return sqrt*sqrt==x;
        }
        return false;
    }
    static boolean[][] visited;
    public static String canReach(int c, int a,int b,int x,int y){
        int size = Math.max(Math.max(x,y),Math.max(a,b));

        visited = new boolean[size+1][size+1];


        return dfs(x,y,c,a,b)?"Yes":"NO";
    }

    private static boolean inArea(int x, int y){
        return x>=0&&x<visited.length&&y>=0&&y<visited.length&&!isPefectSquare(x+y);
    }
    private static boolean dfs(int x, int y, int c,int a, int b) {
        if (!inArea(x,y))return false;
        if (x==a&&y==b) return true;

        if (visited[x][y])return false;

        visited[x][y] = true;
        return dfs(x+y,y,c,a,b)
        ||dfs(x,y+x,c,a,b)
        ||dfs(x+c,y+c,c,a,b);

    }

    public static void main(String[] args) {
        System.out.println(canReach(1,7,6,1,4));
    }
}
