package Amazon;

import java.util.Calendar;
import java.util.HashMap;

public class PMachingScore {
    public static int getPMachingScore(String str1, String str2,int p){
        int l1 = str1.length();
        int l2 = str2.length();
        HashMap<Character,Integer>m = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            m.put(str2.charAt(i),m.getOrDefault(str2.charAt(i),0)+1);
        }
        int sorce=0;
        for(int i =0;i<p;i++){
            int fast = i;
            int slow = i;
            HashMap<Character,Integer> m2 = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            while (fast<l1){
                //add fast
                sb.append(str1.charAt(fast));
                m2.put(str1.charAt(fast),m2.getOrDefault(str1.charAt(fast),0)+1);

                fast+=p;
                //remove slow
                if(sb.length()>l2) {
                    sb.deleteCharAt(0);
                    if (m2.get(str1.charAt(slow))==1){
                        m2.remove(str1.charAt(slow));
                    }
                    else {
                        m2.put(str1.charAt(slow),m2.get(str1.charAt(slow))-1);
                    }
                    slow += p;
                }
                //get results
                if (sb.toString().equals(str2)||compareMap(m,m2)){

                    sorce++;
                }
            }
        }
        return sorce;
    }

    private static boolean compareMap(HashMap<Character, Integer> m, HashMap<Character, Integer> m2) {
//        System.out.println(m2);
//        System.out.println(m);
        for (char c: m.keySet()){
            if (m2.containsKey(c)&&m2.get(c)==m.get(c)) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getPMachingScore("acaccaa", "aac",2));
    }
}
