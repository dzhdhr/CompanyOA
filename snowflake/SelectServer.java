package snowflake;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;


public class SelectServer {
    static int n; static int m;
    static List<List<Integer>> grid;
    public static boolean haveDuplicateRows(int c){
        int[] marks=new int[m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)>=c){
                    marks[j]+=1;


                }
            }
        }
        boolean ret = false;
        System.out.println(Arrays.toString(marks));
        for(int elem:marks){
            if(elem==1)return false;
            if(elem>=2)ret = true;
        }
        return ret;

    }
    // max of min(max in each col)//删掉至少一行
    // 3 4 5
    // 7 8 9
    // 7 8 9
    //max
    //7
    //m-1 max > target
    public static int getMaxNetVulnerability(List<List<Integer>> vulnerability) {
        // Write your code here
        //rows:m cols:n
        m=vulnerability.size();
        n=vulnerability.get(0).size();

        int high=1000000;
        int low=1000000;

        grid= vulnerability;
        Integer[][] gridT=new Integer[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                gridT[i][j]=vulnerability.get(j).get(i);
            }
        }
        for(int ii=0;ii<n;ii++){
            high=Math.min(high,Collections.max(Arrays.asList(gridT[ii])));
            low=Math.min(low,Collections.min(Arrays.asList(gridT[ii])));
        }
        System.out.println(high);
        System.out.println(low);
        if(haveDuplicateRows(high)) return high;
        while(low<high){
            int mid=low+(high-low+1)/2;
            if(haveDuplicateRows(mid)) low=mid;
            else high=mid-1;
        }
        return low;

    }

    public static boolean isValidate(int[][]grid, int target){
        //set add
        //
        Set<Integer> colSet = new HashSet<>();
        int[]rowmask = new int[grid.length];
        int[]mask = new int[grid[0].length];//每一列有几个比target大的
        boolean twoInOneRow = false;
        for(int j = 0;j< grid[0].length;j++){
            boolean atLeastOneInCol = false;

            for(int i = 0;i<grid.length;i++){

                if(grid[i][j]>=target){
                    if(colSet.contains(i)){
                        twoInOneRow = true;
                    }
                    colSet.add(i);
                    mask[j]++;//
                    atLeastOneInCol = true;

                }
            }
            if(!atLeastOneInCol)return false;
        }
        return twoInOneRow;
//        System.out.println();
//        boolean ret = false;
//        System.out.println(Arrays.toString(mask));
//        for(int elem:mask){
//            if(elem==0)return false;
//            if(elem>=2)ret = true;
//        }
//        return ret;
    }
    public static int select(int[][]select){
//        if(select[0].length==2){
//            int ret = Integer.MIN_VALUE;
//            for(int[]elem:select){
//                ret = Math.max(Math.min(elem[0],elem[1]),ret);
//            }
//            return ret;
//        }
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
//        int[][]grid = new int[][]{
//                {40, 93},
//                {91, 89},
//                {33, 7},
//                {86, 17},
//                {84, 38},
//                {53, 84},
//                {5, 89},
//                {26, 98},
//                {44, 13},
//                {59, 7},
//                {79, 37},
//                {50, 40},
//                {22, 8},
//                {96, 61},
//                {97, 50},
//                {60, 91},
//                {55, 47},
//                {61, 47},
//                {8, 69},
//                {81, 31},
//                {16, 69},
//                {56, 84},
//                {55, 44},
//                {7, 97},
//                {51, 9},
//                {65, 68},
//                {80, 64},
//                {40, 53},
//                {85, 48},
//                {69, 60},
//                {7, 79},
//                {77, 74},
//                {92, 77},
//                {17, 16},
//                {90, 1},
//                {38, 40},
//                {45, 85},
//                {77, 39},
//                {72, 14},
//                {22, 27},
//                {82, 98},
//                {5, 38},
//                {62, 4},
//                {100, 41},
//                {43, 17},
//                {23, 19},
//                {71, 46},
//                {49, 3}, {11, 99}, {34, 81}, {37, 74}, {51, 85}, {97, 49}, {79, 74}, {34, 4}, {89, 59}, {45, 69}, {85, 13}, {29, 68}, {96, 74}, {98, 87}, {98, 52}, {14, 82}, {2, 56}, {14, 23}, {32, 1}, {52, 44}, {45, 99}, {20, 47}, {19, 6}, {73, 45}, {16, 74}, {32, 100}, {48, 41}, {77, 20}, {50, 63}, {51, 71}, {20, 86}, {64, 68}, {1, 26}, {21, 97}, {17, 3}, {70, 54}, {88, 56}, {80, 8}, {88, 65}, {11, 43}, {21, 55}, {83, 20}, {47, 3}, {26, 68}, {64, 62}, {2, 82}, {90, 62}, {24, 10}, {9, 55}, {11, 82}, {83, 47}, {96, 66}, {93, 13}};
//        //max of min(max in each col)
        int [][]grid = new int[][]{
            {100,100,1},
            {2,2,2},
            {1,100,100},
            {100,1,100},
         //

        };
        System.out.println(select(grid));
    }
}

