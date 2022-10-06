package TT;

import java.util.LinkedList;
import java.util.*;

public class PrimNumber {
    public static int numberOfPrim(int n){
        if(n<=2)return 0;
        else if(n==3)return 1;
        boolean[] dp = new boolean[n];
        int ret = 0;
        List<Integer> primNumber = new LinkedList<>();
        for(int i = 2;i<n;i++){
            if(!dp[i-1]){
                primNumber.add((i));
                System.out.println(i);
                ret++;
            }
            for(int elem: primNumber){
                if(elem*i>=n)break;
                dp[i*elem-1] = true;
                if(i%elem==0){
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPrim(29));
    }
}
