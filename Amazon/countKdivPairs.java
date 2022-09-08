package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
* https://www.geeksforgeeks.org/count-pairs-in-array-whose-sum-is-divisible-by-k/
* */
public class countKdivPairs {
    static int countKdivPairs(int []nums,int k ){
        Map<Integer,Integer> remainderToTimeCounter = new HashMap<>();
        for (int num : nums) {
            remainderToTimeCounter.put(num % k, remainderToTimeCounter.getOrDefault(num % k, 0) + 1);
        }
        int count =0;
        System.out.println(remainderToTimeCounter);
        count+=remainderToTimeCounter.getOrDefault(0,0)*(remainderToTimeCounter.getOrDefault(0,0)-1)/2;
        System.out.println(count);
        HashSet<Integer>visited = new HashSet<>();
        for(int key:remainderToTimeCounter.keySet()){
            int need = k-key;
            System.out.println(count);
            if (visited.contains(key))continue;
            if (need==key) count+=(remainderToTimeCounter.get(key)-1)*remainderToTimeCounter.get(key)/2;
            else count+=remainderToTimeCounter.get(key)*remainderToTimeCounter.getOrDefault(need,0);
            visited.add(need);
        }
        return count;

    }

    public static void main(String[] args) {
        int A[] = new int[]{5, 9, 36, 74, 52, 31, 42};
        System.out.println(countKdivPairs(A, 3));
    }
}
