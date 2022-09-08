package Amazon;

import java.util.Arrays;
import java.util.HashSet;

public class DistanceDevloper {
    public static int DistenceDevloper(int []num){
        Arrays.sort(num);
        HashSet<Double> set = new HashSet<>();
        for(int i =0;i<num.length/2;i++){
            double average = 1.0*(num[i]+num[num.length-i-1])/2;
            System.out.println(average);
            set.add(average);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(DistenceDevloper(new int[]{1, 2, 3, 4, 4, 5}));
    }
}
