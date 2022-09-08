package Amazon;

import java.util.HashSet;

public class FindMinSegment {
    public static int minSegments(String str){
        int count=1;
        HashSet<Character>set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {

            if(!set.contains(str.charAt(i))){
                set.add(str.charAt(i));
            }
            else {
                System.out.println(set);
                set.clear();
                set.add(str.charAt(i));
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minSegments("aabcdea"));
    }
}
