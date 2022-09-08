package Amazon;

public class AWSServer {
    public static int minLag(int[]data,int[]server){
        int array1sum = 0;
        int array2sum = 0;
        for (int i = 0;i<server.length;i++){
            array1sum+=data[i];
            array2sum+=server[i];
        }
        return Math.abs(array2sum-array1sum);
    }

    public static void main(String[] args) {
        System.out.println(minLag(new int[]{1, 2, 2}, new int[]{5, 2, 4}));
    }
}
