package Citdeal;

public class GroupOption {
    static int [][]memo;
    public static int GroupOption(int group, int people){
        memo = new int[group][people];
        return helper(group,people,1);

    }
    private static int helper(int group, int people,int prev){

        if(group==0&&people==0){
            return 1;
        }
        if(people==0||group==0)return 0;
        int ret = 0;
        for(int i = prev;i<=people;i++){
            ret+=helper(group-1,people-i,i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(GroupOption(4,8));
    }
}
