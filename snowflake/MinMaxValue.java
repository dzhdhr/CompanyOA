package snowflake;

public class MinMaxValue {
    // search for left bound
    public static int MaxminValue(int[]arr){
        int max = arr[0];
        int min = arr[0];
        for(int i = 0;i<arr.length;i++){
            max = Integer.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        int left = min, right = max;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(validate(mid,arr)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        if(validate(left,arr)){
            return left;
        }
        return right;
    }

    private static boolean validate(int target, int[] arr) {
        int diff = 0;
        System.out.println(target+" ");
        for (int j : arr) {
            if (j <= target) {//如果我比target小说明我可以给diff贡献值
                diff += target - j;
            } else if (j - diff <= target) {//如果我比target大但是能通过diff弥补回来那么我可以直接用diff弥补
                diff -= j - target;
            } else {//如果我比diff大那么我弥补不回来
                System.out.println();
                return false;
            }
            System.out.print(diff+" ");
        }
        System.out.println();
        return true;
//        for(int elem:arr){
//            diff+=elem-left;
//        }
//        System.out.print(left+" ");
//        System.out.println(diff);
//        // if left is too big diff will be negetive
//        // if left is too small elem -left will be postive diff sum will be negtive
//        return diff<=0;
    }

    public static void main(String[] args) {
        int []arr = new int[]{1,5,7,6};
        System.out.println(MaxminValue(arr));
    }
}
