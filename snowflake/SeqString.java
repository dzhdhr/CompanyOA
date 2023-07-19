package snowflake;

import java.util.Arrays;

public class SeqString {
    private static void SeqString(String s, String[]target){
        int[][]count = new int[s.length()][10];
        for(int i = 0;i<s.length();i++){
            for(int j = i;j<s.length();j++) {
                count[j][s.charAt(i) - '0']++;
            }
        }
        System.out.println(Arrays.deepToString(count));
        int []ret = new int[target.length];
        for(int i = 0;i<target.length;i++){
            String elem = target[i];
            ret[i] = bs(elem, count);
        }
        System.out.println(Arrays.toString(ret));

    }
    private static boolean isValid(int[][]count, int []p, int target){
        System.out.println(target);
        for(int i = 0;i<p.length;i++){
            if(count[target][i]<p[i])return false;
        }
        return true;
    }
    // search for leftbound
    private static int bs(String target, int[][]count){
        int[]p = new int[10];
        for (char c: target.toCharArray()){
            p[c-'0']++;
        }
        int left = 0,right = count.length-1;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(isValid(count,p,mid)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        if(isValid(count,p,left))return left+1;
        if(isValid(count,p,right))return right+1;
        return -1;

    }

    public static void main(String[] args) {
        String s = "1";
        String[]arr = new String[]{"1"};
        SeqString(s,arr);
    }
}
