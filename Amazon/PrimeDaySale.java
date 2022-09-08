package Amazon;

import java.util.HashMap;

public class PrimeDaySale {
    public static int PrimeDaySale(String catalogs,int k){
        HashMap<Character,Integer> m = new HashMap<>();
        for(int i = 0;i<catalogs.length();i++){
            m.put(catalogs.charAt(i),m.getOrDefault(catalogs.charAt(i),0)+1);
        }
        HashMap<Character,Integer>m2 = new HashMap<>();
        int count = 0;
        for(int i = 0;i<catalogs.length();i++){
            m2.put(catalogs.charAt(i),m2.getOrDefault(catalogs.charAt(i),0)+1);
            if (m.get(catalogs.charAt(i))==1)m.remove(catalogs.charAt(i));
            else m.put(catalogs.charAt(i),m.get(catalogs.charAt(i))-1);
            int distinct = 0;
            for (char c: m2.keySet()){
                if (m.containsKey(c))distinct++;
                if (distinct>k){
                    count++;
                    break;
                }
            }
            //System.out.println(distinct);

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(PrimeDaySale("abbcac",1));
    }
}
