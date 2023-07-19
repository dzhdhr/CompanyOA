package snowflake;

import java.util.Arrays;

public class PerfectPairs {
    // find the last element that is less than cur element
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        if (target <= arr[0]) return 0;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {//cur is greater or equal target this could be first or last
                left = mid;
            } else {// greater
                right = mid - 1;
            }
        }
        if (arr[right] <= target) return right;
//        if(arr[left]>=target)return right;
//        return arr.length;
        return left;
    }

    public static int allPair(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }
        Arrays.sort(arr);
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = binarySearch(arr, arr[i] * 2);
            ret += Math.max(0, index - i);

        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ret = new int[]{2,1,0};
        System.out.println(allPair(ret));
        System.out.println(numberOfPair(ret));
    }

    public static int numberOfPair(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) arr[i] = -arr[i];
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int idx = bs(arr, arr[i] * 2);
            res += Math.max(0, idx - i);
        }
        return res;
    }

    // find the int x that arr[x] <= n < arr[x + 1]
    public static int bs(int[] arr, int n) {
        int sz = arr.length;
        if (n <= arr[0]) return 0;
        //System.out.println(arr[sz - 1] <= n);
        if (arr[sz - 1] <= n) return sz - 1;
        int lo = 0;
        int hi = sz - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (n < arr[mid]) {
                hi = mid - 1;
            } else if (arr[mid] <= n && mid < sz - 1 && n < arr[mid + 1]) {
                return mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
