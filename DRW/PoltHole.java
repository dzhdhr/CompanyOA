package DRW;

import java.util.*;

public class PoltHole {
    public static int numberOfPoltHole(String s,int burget){
        List<Integer> ret = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='x'){
                int j = i;
                while (j<s.length()&&s.charAt(j)=='x'){
                    j++;
                }
                int size = j-i;
                ret.add(size);
                i = j;
            }
        }

        ret.sort((x, y) -> Integer.compare(y, x));
        System.out.println(ret);
        int result = 0;
        for (Integer integer : ret) {
            if (integer + 1 <= burget) {
                result += integer;
                burget -= integer + 1;
            }
            else{
                int canFix = burget-1;
                result+=canFix;
                burget-=canFix+1;
            }
            if (burget <= 0) return result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPoltHole("...xxx...x....xxx", 7));
    }
}
