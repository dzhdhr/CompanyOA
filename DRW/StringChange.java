package DRW;

import java.util.Arrays;

public class StringChange {
    public static String helper(String s,String t){
        if(s.length()>t.length())return"IMPOSSIBLE";
        if(s.length()+1==t.length()){
            System.out.println("here");
            return insert(s,t);
        }
        if(s.length()==t.length()){
            char []a = new char[2];
            char []b = new char[2];
            int count = 0;
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)==t.charAt(i))continue;
                if(count==0){
                    a[0]=s.charAt(i);
                    a[1] = t.charAt(i);
                    count++;
                }
                else if(count==1){
                    b[0]=s.charAt(i);
                    b[1] = t.charAt(i);
                    count++;
                }
                else{
                    return "IMPOSSIBLE";
                }
            }
            if (count==1){
                return "CHANGE"+a[0]+" "+a[1];
            }
            else if (count==2){
                System.out.println(Arrays.toString(a));
                System.out.println(Arrays.toString(b));
                if(a[0]==b[1]&&a[1]==b[0]){
                    return "SWAP"+a[0]+" "+b[0];
                }
            }
            System.out.println(count);
        }

        return "IMPOSSIBLE";
    }

    private static String insert(String s, String t) {
        int diff = 0;
        char c = '-';
        int p1 = 0;
        int p2 = 0;
        while (p1<s.length()&&p2<t.length()){
            if(s.charAt(p1)==t.charAt(p2)){
                p1++;
                p2++;
                continue;
            } else if (diff>0) {
                return "IMPOSSIBLE";
            }
            diff++;
            c = t.charAt(p2);
            p2++;
        }
        if(diff==1&&p2==t.length()&&p1==s.length()){
            return "INSERT "+c;
        }
        if(diff==0){
            return "INSERT"+t.charAt(t.length()-1);
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        System.out.println(helper("d","do"));
    }
}
