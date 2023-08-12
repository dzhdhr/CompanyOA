package DRW;

public class BitAdd {

    public static String toBinary(int x) {
        return String.format("%64s", Integer.toBinaryString(x)).replaceAll(" ", "0");
    }
    public static int maxBitAdd(int[]arr){
        String[]s = new String[arr.length];
        for(int i = 0;i<arr.length;i++){
            String s1 = toBinary(arr[i]);
           s[i] = s1;
        }
        int max = 0;
        for(int i = 0;i<64;i++){
            int cur = 0;
            for(int j = 0;j<arr.length;j++){
                if(s[j].charAt(i)=='1')cur++;
            }
            max = Math.max(cur,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxBitAdd(new int[]{16,16}));
    }
}
