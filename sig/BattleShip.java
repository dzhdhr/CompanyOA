package sig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BattleShip {
    public static List<String> battleShip(char[][]grid, int[][]command){
        List<String>ret = new ArrayList<>();
        HashMap<Character,HashSet<Integer>>map = new HashMap<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                map.putIfAbsent(grid[i][j],new HashSet<>());
                map.get(grid[i][j]).add(i*grid[0].length+j);
            }
        }
        for(int []c: command){
            if(grid[c[0]][c[1]]=='.'){
                ret.add("Missed");
            }
            else {
                int curLocation = c[0]*grid[0].length+c[1];
                if(map.get(grid[c[0]][c[1]]).contains(curLocation)){
                    map.get(grid[c[0]][c[1]]).remove(curLocation);
                    if(map.get(grid[c[0]][c[1]]).isEmpty()){
                        ret.add("Ship"+grid[c[0]][c[1]]+"sunk");
                    }
                    else {
                        ret.add("Attack ship"+grid[c[0]][c[1]]);
                    }
                }
                else {
                    ret.add("Already Attacted");
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        char[][]grid = new char[][]{
                {'.','A','B','B','B'},
                {'.','A','.','.','C'},
                {'D','D','.','.','.'},
                {'.','E','E','E','E'},

        };
        int [][]command = new int[][]{{0,0},{0,1},{0,2},{1,1},{0,1},{1,4},{2,2},{2,4},{0,3},{0,0},{0,4}};
        System.out.println(battleShip(grid,command));
    }
}
