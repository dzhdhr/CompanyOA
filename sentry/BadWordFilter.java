package sentry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BadWordFilter {
    static class TrieNode{
        boolean isword;
        HashMap<Character,TrieNode>childern;
        int numberOfChildern;
        public TrieNode(){
            this.childern = new HashMap<>();
            this.isword = false;
            this.numberOfChildern = 0;
        }
    }
    static TrieNode root;
    public static void insert(String word){
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            if(c=='*'){
                if(cur.childern.get('*')==null){
                    cur.childern.put('*',new TrieNode());
                    cur.numberOfChildern++;
                }
                cur = cur.childern.get('*');
            }
            else {
                //int index = c-'a';
                if(cur.childern.get(c)==null){
                    cur.childern.put(c,new TrieNode());
                    cur.numberOfChildern++;
                }
                cur = cur.childern.get(c);
            }
        }
        cur.isword = true;
    }
    public static boolean isword(String word,TrieNode cur,int index){
        if(index==word.length()&&cur.isword){
            return true;
        }
        if(index==word.length()&&cur.childern.containsKey('*')&&cur.childern.get('*').isword)return true;
        if(index==word.length())return false;
        if(cur.childern.containsKey('*')){
            boolean result = isword(word,cur,index+1);
            if(result)return true;
            boolean result2 = isword(word,cur.childern.get('*'),index+1);
            //System.out.println(result);
            if (result2)return true;
            boolean result3 = isword(word,cur.childern.get('*'),index);
            if(result3)return true;
        }
        int charIndex = word.charAt(index)-'a';

        if(cur.childern.containsKey(word.charAt(index))){
            return isword(word,cur.childern.get(word.charAt(index)),index+1);
        }
        return false;

    }

    public static String wordFilter(String filter,String input){
        root = new TrieNode();
        String []sfilter = filter.split(" ");
        for(String elem:sfilter){
            if("".equals(elem))continue;
            insert(elem);
        }
        StringBuilder ret =new StringBuilder();
        for(int i =0 ;i<input.length();i++){
            if(!Character.isAlphabetic(input.charAt(i))){
                ret.append(input.charAt(i));
                continue;
            }
            int j = i;
            while (j<input.length()&&Character.isAlphabetic(input.charAt(j))){
                j++;
            }
            String cur = input.substring(i,j);
            System.out.println(cur);
            if(isword(cur,root,0)){
                ret.append("*".repeat(Math.max(0, j - i)));
            }
            else{
                ret.append(cur);
            }
            i = j-1;
            System.out.println(i);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(wordFilter("lame jerk scrub", "The programmer was being a jerk during code review."));
    }
}
