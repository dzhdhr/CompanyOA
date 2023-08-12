package DRW;

import java.util.HashSet;

public class PostStoreClient {
    public static int post(int[]people){
        int ret = 0;
        HashSet<Integer>sheif = new HashSet<>();
        int prevEnd = 0;
        for (int person : people) {
            while (!sheif.contains(person)) {
                sheif.add(++prevEnd);
            }
            sheif.remove(person);
            ret = Math.max(ret, sheif.size());
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(post(new int[]{1,2,3,4,5,6}));
    }
}
