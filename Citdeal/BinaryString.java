package Citdeal;

public class BinaryString {
    public static int numberOfPossibleBinary(int minLength,int maxLength, int oneGroup, int zeroGroup){
        return helper(minLength,maxLength,oneGroup,zeroGroup,0);
    }

    private static int helper(int minLength, int maxLength, int oneGroup, int zeroGroup, int i) {
        if(i>maxLength){
            return 0;
        }

        int ret = 0;
        if(i<=maxLength&&i>=minLength){
            ret++;
        }
        ret = ret+helper(minLength,maxLength,oneGroup,zeroGroup,i+oneGroup);
        ret= ret+helper(minLength,maxLength,oneGroup,zeroGroup,i+zeroGroup);
        return ret;
    }

    public static void main(String[] args) {

    }
}
