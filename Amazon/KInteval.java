package Amazon;

import java.util.HashMap;

public class KInteval {
    public static int KInteval(String s1, String s2,int k){
        if(s1.length()<s2.length())return 0;
        int count = 0;
        HashMap<Character ,Integer> pattern = new HashMap<>();
        for(int i = 0;i<s2.length();i++){
            pattern.put(s2.charAt(i),pattern.getOrDefault(s2.charAt(i),0)+1);
        }

        for(int i = 0;i<k;i++){
            HashMap<Character,Integer> m = new HashMap<>();
            int size = 0;
            int slow = i;
            int fast = i;
            while (fast<s1.length()){
                //add fast,
                //System.out.printf("add %c ",s1.charAt(fast));

                m.put(s1.charAt(fast),m.getOrDefault(s1.charAt(fast),0)+1);
                fast+=k;
                size++;
                //System.out.println(m);
                //remove slow
                if(size>s2.length()){
                    //System.out.println("remove "+s1.charAt(slow));
                    if (m.get(s1.charAt(slow))==1)m.remove(s1.charAt(slow));
                    else m.put(s1.charAt(slow),m.get(s1.charAt(slow))-1);
                    slow+=k;
                    size--;
                    //System.out.println("result :"+m);
                }
                //get result
                if(pattern(m,pattern)){
                    //System.out.println("match");
                    count++;
                }

            }
        }
        return count;
    }

    private static boolean pattern(HashMap<Character, Integer> m, HashMap<Character, Integer> pattern) {
        if (m.size()!=pattern.size())return false;
        else {
            for (char character : pattern.keySet()) {
                if(m.containsKey(character)&&m.get(character)==pattern.get(character))continue;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(KInteval("acaccaaa", "aac", 2));

    }
}
