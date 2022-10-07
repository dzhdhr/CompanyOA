package DoorDash;

import java.util.Arrays;

public class TwoString {
    public static int TwoString(String s1, String s2){
        int prefix[] = new int[s2.length()+1]; // number of characters needed from s1 to make [0-i) subseqs
        int post[] = new int[s2.length()+1];// number of characters needed from s1 to make (i-n-1]subseq
        prefix[0] = -1;
        for(int i = 0;i<s2.length();i++){
            char c = s2.charAt(i);
            int start = prefix[i]+1;
            for(;start<s1.length();start++){
                if(s1.charAt(start)==c)break;
            }
            prefix[i+1]=start;
        }
        System.out.println(Arrays.toString(prefix));
        post[post.length-1] = s1.length();
        for(int i = s2.length()-1;i>=0;i--){
            char c = s2.charAt(i);
            int start = post[i+1]-1;
            for(;start>=0;start--){

                if(s1.charAt(start)==c)break;
            }
            post[i] = start;
        }
        System.out.println(Arrays.toString(post));
        // binary search for the left bound in range of 0-m such that remove that number of element can cause s2 to be s1's subseq
        int left =0, right = s2.length();
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(validation(mid,prefix,post,s1,s2)){
                right = mid;
            }
            else{//如果不能达成那么说明再短的 也不能达成
                left = mid+1;
            }
        }
        if(validation(left,prefix,post,s1,s2))return left;
        return right;
    }

    private static boolean validation(int size, int[] prefix, int[] postfix, String s1, String s2) {
        //if(size==0)return s1.equals(s2);
        if(size==s2.length())return true;
        int slow = 0;
        int fast = slow+size;
        while(fast<=s2.length()){
            int pre = prefix[slow];
            int post = postfix[fast];
            if(pre<post)return true;
            fast++;
            slow++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(TwoString("aadasdwa", "bsdwsbaa"));
    }
}
