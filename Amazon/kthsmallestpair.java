package Amazon;

import java.util.Arrays;
import java.util.PriorityQueue;
// need to improve if not pass
// dynamic adding
public class kthsmallestpair {
    public static int[]getSmallestInefficenciess(int []skill,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->Integer.compare(b,a));
        for(int i = 0;i<skill.length;i++){
            for (int j = i+1;j<skill.length;j++){
                System.out.println(skill[i]-skill[j]);
                pq.offer(Math.abs(skill[i]-skill[j]));
                if (pq.size()>k)pq.poll();
            }
        }
        int[] ret = new int[k];
        for (int i = k-1;i>=0;i--){
            ret[i] = pq.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] skills = new int[]{6,9,1,10,4};
        System.out.println(Arrays.toString(getSmallestInefficenciess(skills, 5)));
    }
}
