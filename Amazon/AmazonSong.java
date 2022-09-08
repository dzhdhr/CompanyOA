package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AmazonSong {
    static List<Integer> ret = new LinkedList<>();
    public static int[] GenrateSong(int[] song, int time){

        List<Integer>cur = new LinkedList<>();
        backTracking(song,time,cur,0);
        int []retarry = new int[ret.size()];
        for (int i = 0;i<retarry.length;i++){
            retarry[i] = ret.get(i);
        }
        return retarry;
    }
    //t : cur index in song,
    private static void backTracking(int[]song,int time,List<Integer>cur, int t){
        if(time==30&&cur.size()>ret.size()){
            ret = new LinkedList<>(cur);
            return;
        }
        if(time<30)return;
        for(int i = t;i<song.length;i++){
            cur.add(i);
            backTracking(song,time-song[i],cur,i+1);
            cur.remove(cur.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(GenrateSong(new int[]{1, 10, 25, 35, 60}, 90)));
    }
}
