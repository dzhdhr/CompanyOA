package Citdeal;

import java.util.HashMap;
import java.util.Map;

public class Coupon {
    private static final int MOD = 1000000000+7;
    public static long CouponValue(String s,int k){
        long windowValue = 0;
        long ret = 0;
        int fast = 0;
        int slow = 0;
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i = 0;i<k;i++){
            fast++;
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        }

        ret = getResult(map);
        while (fast<s.length()){
            map.put(s.charAt(fast),map.getOrDefault(s.charAt(fast),0)+1);
            fast++;
            if(map.get(s.charAt(slow))==1){
                map.remove(s.charAt(slow));
            }
            slow++;
            long result = getResult(map);
            ret = Long.max(result,ret);
        }
        return ret%MOD;

    }

    private static long getResult(HashMap<Character, Integer> map) {
        long ret = 0;
        for(char elem: map.keySet()){
            ret = (long) (ret+ Math.pow(elem-'a'+1,map.get(elem))%MOD)%MOD;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(CouponValue("abcc", 2));
    }
}
