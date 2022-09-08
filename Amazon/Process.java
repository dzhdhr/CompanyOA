package Amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Process {
    public static int process(int[] exctime) {
        HashMap<Integer, List<Integer>> timeToIndex = new HashMap<>();
        for (int i = 0; i < exctime.length; i++) {
            timeToIndex.computeIfAbsent(exctime[i], k -> new LinkedList<>());
            timeToIndex.get(exctime[i]).add(i);
        }
        int[] newTimes = exctime.clone();
        int totalTime = 0;

        for (int i = 0; i < exctime.length; i++) {
            int oldTime = exctime[i];
            int newTime = newTimes[i];
            int reduceTime = Math.ceilDiv(newTime, 2);
            totalTime += newTime;
            for (int elem : timeToIndex.get(oldTime)) {
                newTimes[elem] = reduceTime;
            }
        }
        return totalTime;
    }

    public static void main(String[] args) {
        System.out.println(process(new int[]{5,8,4,4,8,2}));
    }
}
