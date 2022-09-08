package Amazon;

public class AZ {
    public static int AZ(String s){
        int numberOfA = 0;
        int numberOfZ =  0 ;
        int ret = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='A'){
                numberOfA++;
            }
            if (c=='Z'){
                numberOfZ++;
                ret +=numberOfA;
            }
        }
        return Math.max(ret+numberOfA,ret+numberOfZ);
    }

    public static void main(String[] args) {
        System.out.println(AZ("W"));
    }
}
