public class ClosestNumber {
    public static int closestNumber(int[]array, int k){
        int left = 0,right = array.length;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(array[mid]>k){
                right = mid;
            }
            if(array[mid]==k){
                return k;
            }
            else{
                left = mid;
            }
        }
        int ret = array[left];
        for(int i = left;i<=right;i++){
            if(Math.abs(k-ret)>Math.abs(k-array[i])){
                ret = array[i];
            }
        }
        return ret;
    }
}
