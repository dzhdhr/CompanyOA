package Cisco;

import java.util.*;

public class SmallestLargestElement {
    public static List<Integer> maxMinElement(int[][]element){

        int[][]maxMatrix = new int[element.length][element[0].length];
        for (int i = 0;i<element.length;i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < element[0].length; j++) {
                max = Math.max(max, element[i][j]);
            }
            Arrays.fill(maxMatrix[i],max);

        }
        System.out.println(Arrays.deepToString(maxMatrix));
        List<Integer> ret = new LinkedList<>();
        for(int j=0;j<element[0].length;j++){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0;i<element.length;i++){
                if(min>element[i][j]) {
                    min = Math.min(element[i][j], min);
                    index = i;
                }
            }
           if(element[index][j]==maxMatrix[index][j]){
               ret.add(element[index][j]);
           }

        }
        return ret;
    }

    public static void main(String[] args) {
        int [][]arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(maxMinElement(arr));
    }
}
