package snowflake;

import java.util.Arrays;
import java.util.Comparator;

public class MinSetInterval {
    private static int result (int[][]arr){
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        return 0;
    }
    public static void main(String[] args) {

    }
}
