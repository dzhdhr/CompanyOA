package DoorDash;

import java.util.Arrays;

public class friendGroup {
    public static int[] totalFriend(int n, int []friend1,int []friend2, String[]query){
        int[]uf = new int[n];
        int []groupSize = new int[n];
        for(int i = 0;i<n;i++){
            uf[i] = i;
            groupSize[i] = 1;
        }
        int[] ret= new int[query.length];
        for(int i = 0;i<query.length;i++){
            if(query[i].equals("Total")){
                int aboss = find(uf,friend1[i]-1);
                int bboss = find(uf,friend2[i]-1);
                if(aboss!=bboss) {
                    ret[i] = groupSize[aboss]+groupSize[bboss];
                }
                else {
                    ret[i] = groupSize[bboss];
                }
            }
            else{
                union(uf,groupSize,friend1[i]-1,friend2[i]-1);
            }
        }
        return ret;
    }

    private static void union(int[] uf, int[] groupSize, int i, int i1) {
        int aboss = find(uf,i);
        int bboss = find(uf,i1);
        if(aboss!=bboss){
            if(groupSize[aboss]>groupSize[bboss]){ //a u b
                uf[bboss] = aboss;
                groupSize[aboss]+=groupSize[bboss];
            }
            else{// b u a
                uf[aboss]= bboss;
                groupSize[bboss]+=groupSize[aboss];
            }
        }
    }

    private static int find(int[] uf, int i1) {
        if (uf[i1]==i1)return i1;
        uf[i1] = find(uf,uf[i1]);
        return uf[i1];
    }

    public static void main(String[] args) {
        int[]friends1 = new int[]{1,2,4};
        int []friends2 = new int[]{2,3,4};
        String[] s= new String[]{"Friend","Friend","Total"};
        System.out.println(Arrays.toString(totalFriend(4, friends1, friends2, s)));
    }
}
