package Citdeal;

public class MathWithLego {
    public static int maxValue(int []arr1,int []arr2){
        int zero1 = 0,zero2 =0,sum1 =0,sum2 = 0;
        for(int elem:arr1){
            if(elem==0)zero1++;
            else sum1+=elem;
        }
        for(int elem:arr2){
            if(elem==0)zero2++;
            else sum2+=elem;
        }
        if(zero1==0&&0==zero2){
            if(sum2!=sum1){
                return -1;
            }
           // return sum1;
        }
        if(zero1+sum1>zero2+sum2){
            if(zero2==0)return -1;
        }
        if(zero1+sum1<zero2+sum2){
            if(zero1==0)return -1;
        }


        return Math.max(zero1+sum1,zero2+sum2);
    }

    public static void main(String[] args) {
        System.out.println(maxValue(new int[]{1,1,2},new int[]{1,1,2}));
    }
}
