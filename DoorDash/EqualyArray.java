package DoorDash;

import java.util.Arrays;

public class EqualyArray {
    // give 2 array you can only add 1 to the front or and 1 to the back
    // return how many number of move need to make 2 array equals
    public static int EquaArray(int[]arr1,int[]arr2){
        int diff [] = new int[arr2.length];
        for(int i = 0;i<diff.length;i++){
            diff[i] = arr2[i]-arr1[i];
            if(diff[i]<0)return -1;
        }
        System.out.println(Arrays.toString(diff));
        //diff = new int[]{1,0,1};
        // how  many step to make diff zero
        int ret = 0;
        for(int i = 0;i<diff.length-1;i++){
            ret+=Math.abs(diff[i+1]-diff[i]);
            if(diff[i+1]-diff[i]<0){
                diff[0]-=Math.abs(diff[i+1]-diff[i]);
            }
        }
        ret+=Math.abs(diff[0]);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(EquaArray(new int[]{-1,-1,-1}, new int[]{0,0,0}));
    }
}
