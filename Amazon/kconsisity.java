package Amazon;

import java.util.HashMap;

public class kconsisity {

    public static void main(String[] args) {
        int[] stock_price = {1, 2, 1, 1, 2, 2, 2, 2};
        int k = 2;
        int len = stock_price.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            map.put(stock_price[end], map.getOrDefault(stock_price[end], 0) + 1);
            maxCount = Math.max(maxCount, map.get(stock_price[end]));
            while (end - start + 1 - maxCount > k) {
                map.put(stock_price[start], map.get(stock_price[start]) - 1);
                start++;
            }
        }
        System.out.println(maxCount);
    }

}
