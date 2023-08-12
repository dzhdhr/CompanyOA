package DRW;

public class BitXOR {
    private static int xor(int n){
        if (n % 4 == 0)
            return n;

        // If n%4 gives remainder 1
        if (n % 4 == 1)
            return 1;

        // If n%4 gives remainder 2
        if (n % 4 == 2)
            return n + 1;

        // If n%4 gives remainder 3
        return 0;
    }
    public static int bitXOR(int i, int j){
        int result1 = xor(i-1);
        int result = xor(j);
        int r = 0;
        for(int t = i ;t<=j;t++)r =r^t;

        System.out.println(result1+" "+result+" "+r);
        return result1^result;
    }

    public static void main(String[] args) {
        System.out.println(bitXOR(5,8));
    }
}
