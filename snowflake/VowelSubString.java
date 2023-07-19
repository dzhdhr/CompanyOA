package snowflake;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

// sliding window
// add fast add one element every time
// remove slow if the cur element is not vowel then clear move slow to fast+1 clear whole thing
public class VowelSubString {
    private static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
    public static int count (String s){
        HashMap<Character,Integer> m = new HashMap<>();
        int ret = 0;
        int fast = 0, slow = 0;
        while (fast<s.length()){
            if(isVowel(s.charAt(fast))){
                m.put(s.charAt(fast),m.getOrDefault(s.charAt(fast),0)+1);
                fast++;
                if(m.size()==5){
                    ret++;
                    System.out.println(s.substring(slow,fast));
                }
            }
            else{
                if(!m.isEmpty()) {
                    if (m.get(s.charAt(slow)) == 1) m.remove(s.charAt(slow));
                    else m.put(s.charAt(slow), m.get(s.charAt(slow))-1);
                    slow++;
                    while (m.size() == 5) {
                        ret++;
                        System.out.println(s.substring(slow,fast));
                        if (m.get(s.charAt(slow)) == 1) m.remove(s.charAt(slow));
                        else m.put(s.charAt(slow), m.get(s.charAt(slow))-1);
                        slow++;
                    }
                }
                slow = fast+1;
                fast++;
                m.clear();
            }
        }
        if(!m.isEmpty()) {
            if (m.get(s.charAt(slow)) == 1) m.remove(s.charAt(slow));
            else m.put(s.charAt(slow), m.get(s.charAt(slow))-1);
            slow++;
            while (m.size() == 5) {
                ret++;
                System.out.println(s.substring(slow));
                if (m.get(s.charAt(slow)) == 1) m.remove(s.charAt(slow));
                else m.put(s.charAt(slow), m.get(s.charAt(slow))-1);
                slow++;
            }
        }
        return ret;
    }

    public static int countVowelSubstrings(String word) {
        if (word.length() < 5) {
            return 0;
        }
        Set<Character> vo = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int res = 0;
        char[] charArr = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        int r = 0, l = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (vo.contains(charArr[i])) {
                if ((i == 0) || !(vo.contains(charArr[i - 1]))) {
                    r = i;
                    l = i;
                    map.clear();
                }
                map.put(charArr[i], map.getOrDefault(charArr[i], 0) + 1);
                System.out.println(map);
                while (map.size() == 5 ) {
                    map.put(charArr[r], map.get(charArr[r]) - 1);
                    if (map.get(charArr[r]) <= 0)
                    {
                        map.remove(charArr[r]);
                    }
                    r++;
                }
                System.out.print("i="+i+" "+l+" ");
                System.out.println(r);
                res += (r - l);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("aaeiouuai"));
    }
}
