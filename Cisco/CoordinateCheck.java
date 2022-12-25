package Cisco;

import java.util.Arrays;


public class CoordinateCheck {
    private static boolean checkX(int start, String s,int end, int top){
        if(start>end)return false;

        if(!Character.isDigit(s.charAt(start))&&s.charAt(start)!='.')return false;
        int leadZero = 0;
//        if()
        for(int i = start;i<=end;i++){

            if (s.charAt(i)=='0')leadZero++;
            else break;
        }
        if (leadZero>1)return false;

        System.out.println(leadZero);
        try {
            double  result = Double.parseDouble(s.substring(start,end+1));
            System.out.println(result);

            if (leadZero==1&Math.abs(result)>=1)return false;
            return result<=top;
        }catch (NumberFormatException e){

            //System.out.println(s.substring(start,end+1));
            return false;
        }

    }
    public static boolean isValid(String s){
        if(s.length()==0)return false;
        String[]splite = s.split(",");
        System.out.println(Arrays.toString(splite));
        if(splite.length!=2||s.charAt(s.length()-1)!=')')return false;
        if(splite[0].length()<2||splite[1].length()<2)return false;
        int cur = 0;
       //System.out.println(splite[0]);
        int i = 0;
        if(splite[0].charAt(i)!='(')return false;
        i++;
        int sign =  1;
        if(splite[0].charAt(i)=='-'){
            sign = -1;
            i++;
        }
        else if(splite[0].charAt(i)=='+'){
            sign = 1;
            i++;
        }
        if(!checkX(i,splite[0], splite[0].length()-1,90 ))return false;

        //if(i==splite[0].length())return false;
//        for(;i<splite[0].length();i++){
//            if(Character.isDigit(splite[0].charAt(i))){
//                if(cur==0&&Character.getNumericValue(splite[0].charAt(i))==0)return false;
//                cur=cur*10+Character.getNumericValue(splite[0].charAt(i));
//            }
//            else return false;
//        }
//        cur = cur*sign;
//        if(!(cur>=-90&&cur<=90))return false;

        i = 0;
        sign =  1;
        cur = 0;
        if(splite[1].charAt(i)!=' ')return false;
        i++;

        if(splite[1].charAt(i)=='-'){
            sign = -1;
            i++;
        }
        else if(splite[1].charAt(i)=='+'){
            sign = 1;
            i++;
        }
        if (!checkX(i,splite[1],splite[1].length()-2,180))return false;
//        if(i==splite[1].length()-1)return false;
//        for(;i<splite[1].length();i++){
//            if(i==splite[1].length()-1){
//                if(splite[1].charAt(i)!=')'){
//                    System.out.println("here");
//                    return false;
//                }
//            }
//            else if(Character.isDigit(splite[1].charAt(i))){
//                if(cur==0&&Character.getNumericValue(splite[1].charAt(i))==0)return false;
//                cur=cur*10+Character.getNumericValue(splite[1].charAt(i));
//            }
//            else return false;
//        }

//        cur = cur*sign;
//        //System.out.println(cur);
//        if(cur<=180&&cur>=-180)return true;
        return true;
    }

    public static void main(String[] args) {
        String tests[]  = new String[]{"(10., 0)"};
        for(String s: tests){
            System.out.println(isValid(s));
        }
    }
}

