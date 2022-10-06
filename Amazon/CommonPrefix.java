package Amazon;

public class CommonPrefix {
    public static int commonPrefix(String s){
        int ret = s.length();
        for(int i = 0;i<s.length();i++){
            int l = shareStart(s.substring(0,i),s.substring(i));
            //
            ret+=l;
        }
        return ret;
    }

    private static int shareStart(String substring, String substring1) {
        int left = 0;
        int right = Math.min(substring.length(),substring1.length());
        while(left<right-1){
            int mid = left+(right-left);
            String prefix = substring.substring(0,mid);
            if(substring.startsWith(prefix)&&substring1.startsWith(prefix)){
                left=mid;
            }
            else{
                right = mid-1;
            }
        }
        String prefix = substring.substring(0,right);
        if(substring.startsWith(prefix)&&substring1.startsWith(prefix))return right;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(commonPrefix("ababa"));
    }
}
