package Amazon;

public class Seqence101010 {
    static int count;
    public static int numberOfSequences(String str){
        backTracking(str,0,'0',0);
        backTracking(str,0,'1',0);
        return count;
    }
    public static void backTracking(String str, int index, char need,int length){
        if(length==3){
            count++;
            return;
        }
        for(int i = index;i<str.length();i++){
            char c = str.charAt(i);
            if(c==need){
                if(need=='1')
                backTracking(str,i,'0',length+1);
                else{
                    backTracking(str,i,'1',length+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numberOfSequences("0100"));
    }
}
