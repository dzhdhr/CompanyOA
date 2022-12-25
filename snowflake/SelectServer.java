package snowflake;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;


public class SelectServer {
//    public static boolean haveDuplicateRows(int c){
//        int[] marks=new int[m];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid.get(i).get(j)>=c){
//                    marks[j]+=1;
//                    if(marks[j]>=2) return true;
//
//                }
//            }
//        }
//        return false;
//
//    }
//
//    public static int getMaxNetVulnerability(List<List<Integer>> vulnerability) {
//        // Write your code here
//        //rows:m cols:n
//        m=vulnerability.size();
//        n=vulnerability.get(0).size();
//        int high=1000000;
//        int low=1000000;
//
//        grid= vulnerability;
//        Integer[][] gridT=new Integer[n][m];
//        //System.out.println();
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                gridT[i][j]=vulnerability.get(j).get(i);
//            }
//        }
//        for(int ii=0;ii<n;ii++){
//            high=Math.min(high,Collections.max(Arrays.asList(gridT[ii])));
//            low=Math.min(low,Collections.min(Arrays.asList(gridT[ii])));
//        }
//
//        if(haveDuplicateRows(high)) return high;
//        while(low<high){
//            int mid=low+(high-low+1)/2;
//            if(haveDuplicateRows(mid)) low=mid;
//            else high=mid-1;
//        }
//        return low;
//
//    }
    public static boolean isValidate(int[][]grid, int target){
        int[]mask = new int[grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j< grid[0].length;j++){
                if(grid[i][j]>=target)mask[j]++;
            }
        }
        boolean ret = false;
        System.out.println(Arrays.toString(mask));
        for(int elem:mask){
            if(elem==0)return false;
            if(elem>=2)ret = true;
        }
        return ret;
    }
    public static int select(int[][]select){
        int left = Integer.MAX_VALUE,right = Integer.MIN_VALUE;
        for(int i = 0;i<select.length;i++){
            for(int j = 0;j<select[0].length;j++){
                left =Integer.min(left,select[i][j]);
                right = Integer.max(right,select[i][j]);
            }
        }
        System.out.println(left);
        System.out.println(right);
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(isValidate(select,mid)){
                left=  mid;
            }
            else right = mid-1;
        }
        if(isValidate(select,right))return right;
        return left;
    }

    public static void main(String[] args) {
        int[][]grid = new int[][]{{1,3,1},{3,1,1},{1,2,2},{1,1,3}};
        System.out.println(select(grid));
    }
}

