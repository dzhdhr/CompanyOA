package Amazon;

import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval {
    public MergeInterval(){

    }
    public static int gotNonInclusiveRetailer(int[][] array){
        int ret = 0;
        Arrays.sort(array,(a,b)-> Integer.compare(a[0],b[0]));
        int max = Integer.MIN_VALUE;
        for(int []elem:array){
            if (max>=elem[1])ret++;
            max =Math.max(max,elem[1]);
        }
        return ret;
    }
    public static void main(String[] args) {
        int[][] arr= new int[][]{{1,2},{2,3},{4,5},{3,5},{1,5}};
        System.out.printf("%d\n", gotNonInclusiveRetailer(arr));
    }
}
