package Amazon;

import java.util.Arrays;

public class TwoPassword {
    public static String TwoPassword(String newPassword, String oldPassword){
        int p1 = 0,p2 = 0;
        while (p2<oldPassword.length()){
            System.out.printf("%d %d\n",p1,p2);
            if(p1>=newPassword.length())return "no";
            char newPasswordChar = newPassword.charAt(p1);
            char oldPasswordChar = oldPassword.charAt(p2);
            char temp1;
            if(newPasswordChar=='z') temp1='a';
            else temp1 = (char) (newPasswordChar+1);
           if(temp1==oldPasswordChar||newPasswordChar==oldPasswordChar){
               p2++;
           }
           p1++;
        }
        return "yes";
    }
    public static String[] OldNewPassword(String[] newPassword, String [] oldPassword){
        String[] ret= new String[newPassword.length];
        for(int i= 0;i<newPassword.length;i++){
            String s1 = newPassword[i];
            String s2 = oldPassword[i];
            int p1 = 0;
            int p2 = 0;
            while(p2<s2.length()){
                if(p1>=s1.length()){
                    ret[i] = "no";
                    break;
                }
                char c = s1.charAt(p1);
                char next = c=='z'?'a': (char) (c + 1);
                if(next==s2.charAt(p2)||c==s2.charAt(p2)) {
                    p2++;
                }
                p1++;

            }
            if(p2==s2.length())ret[i] = "YES";
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(TwoPassword("dzhdhrty", "dzhdhst"));
        String[] newPassword = new String[]{"baacbab","aci","baacba"};
        String [] oldPasswords = new String[]{"abdbc","ach","abb"};
        System.out.println(Arrays.toString(OldNewPassword(newPassword,oldPasswords)));
    }
}
