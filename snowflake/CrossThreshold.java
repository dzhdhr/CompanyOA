package snowflake;

public class CrossThreshold {
    public static int findThreshold(int[]arr,int th){
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int j : arr) {
            left = Math.min(j, left);
            right = Math.max(j, right);
        }

        while(left<right-1){
            int mid = left+(right-left)/2;
            if(validate(mid,arr,th)){
                left = mid;
            }
            else{
                right = mid-1;
            }
        }
        if(validate(right,arr,th))return right;
        return left;
    }
    private static boolean validate(int target, int[]arr,int th){
        int sum = 0;
        for(int elem: arr){
            sum+=Math.max(0,elem-target);
            if(sum>=th)return true;
        }
        return sum>=th;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,13,10};
        System.out.println(findThreshold(arr,8));
    }
}


