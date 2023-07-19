package Citdeal;

public class Process {
    public static int NumberOfProcess(int numberOfProcess, int numberOfInterval){
        if(numberOfProcess==1&&numberOfInterval==1)return 1;
        else if(numberOfProcess==1) return 0;
        long result =  (long)numberOfProcess*(long)Math.pow(numberOfProcess-1,numberOfInterval-1);
        System.out.println(result);
        return (int)result%(100000000+7);
    }

    public static void main(String[] args) {
        System.out.println(NumberOfProcess(2,3));
    }
}
