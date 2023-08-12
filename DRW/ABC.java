package DRW;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ABC {
    public static String constructABC(int a, int b, int c){
        HashMap<String,Integer>map = new HashMap<>();
        map.put("A",a);
        map.put("B",b);
        map.put("C",c);
        StringBuilder sb = new StringBuilder();
        int []count = new int[]{0};
        for(int i = 0;i<a+b+c;i++){
            sb.append(getNext(map,count,sb));
        }
        return sb.toString();
    }

    private static char getNext(HashMap<String, Integer> map,int []count,StringBuilder sb) {
        if(map.get("A")==0&&map.get("B")==0){
            map.put("C", map.get("C")-1);
            return 'C';
        }
        String max = getMax(map.get("A"),map.get("B"),map.get("C"));
        int total = map.get("A")+map.get("B")+map.get("C");
        if(map.get("A")!=0){// 可以选a
           if(total-map.get(max)>(map.get(max)+1)/2-1||max.equals("A")){
               if(sb.length()==0){
                   count[0]++;
                   map.put("A",map.get("A")-1);
                   return 'A';
               }
               else if(sb.charAt(sb.length()-1)!='A'){
                   count[0] = 1;
                   map.put("A",map.get("A")-1);
                   return 'A';
               }
               else if(count[0]<2){
                   count[0]++;
                   map.put("A",map.get("A")-1);
                   return 'A';
               }
           }
        }
        if(map.get("B")!=0){

            if(total-map.get(max)>(map.get(max)+1)/2-1||max.equals("B")){
                if(sb.length()==0){
                    count[0]++;
                    map.put("B",map.get("B")-1);
                    return 'B';
                }
                else if(sb.charAt(sb.length()-1)!='B'){
                    count[0] = 1;
                    map.put("B",map.get("B")-1);
                    return 'B';
                }
                else if(count[0]<2){
                    count[0]++;
                    map.put("B",map.get("B")-1);
                    return 'B';
                }
            }
        }

        map.put("C", map.get("C")-1);
        return 'C';

    }

    private static String getMax(int a, int b,int c) {
        if(a>=b&&a>=c)return "A";
        if(b>=c&&b>=a)return  "B";
        return "C";

    }

    public static void main(String[] args) {
        System.out.println(constructABC(8,8,0));
    }
}
