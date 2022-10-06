package TT;

public class TomToy {
    public double maxEquval(int n, int [] arrays){
        int left = 1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int array : arrays) {
            sum += array;
            min = Integer.min(min, array);
            max = Integer.max(max, array);
        }
        int right =0;
        return -1;
    }
}
