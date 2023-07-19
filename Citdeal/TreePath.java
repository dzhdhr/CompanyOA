package Citdeal;

public class TreePath {
    static class TreeNode{
        TreeNode []childern;
//        TreeNode left;
        int val;
    }
    // public Result helper(TreeNode)
    // result: curMax: max val start at cur element
    // global max : max val at cur element
    // base case if cur==null return null;
    // recursion rule:
    // if left==null&&right==null return new Result{cur.val,cur.val}
    // if left!=null return result{max(cur.val,cur.val+left.cur),max(cur.val,cur.val+left.cur,left.max)}
    // if right!=null return result{max(cur.val,cur.val+left.cur),max(cur.val,cur.val+left.cur,left.max)}
    // cur max = cur.val+left.cur if>0+right.curif>0
    // curpath = Math.max(cur.val,left.cur+cur,right.cur+cur);
    static class Result{
        int cur;
        int max;

        public Result(int val, int val1) {
            this.cur = val;
            this.max = val1;
        }
    }
    static int globelMax;
    private static int maxTreePath(TreeNode root){
        globelMax = 0;
        return helper(root);
    }
//    private static Result helper(TreeNode root){
//        if(root==null)return null;
//        Result left = helper(root.left);
//        Result right = helper(root.right);
//        if(left==null&&right==null){
//            return new Result(root.val,root.val);
//        }
//        if(right==null){
//            int cur = Math.max(root.val,root.val+left.cur);
//            return new Result(cur,Math.max(cur, left.max));
//        }
//        if(left==null){
//            int cur = Math.max(root.val,root.val+right.cur);
//            return new Result(cur,Math.max(cur, right.max));
//        }
//        int cur = root.val;
//        int withLeft = left.cur+cur;
//        int withRight = right.cur+cur;
//        int withBoth = root.val+left.cur+right.cur;
//        int curMax = Math.max(cur,Math.max(withLeft,withRight));
//        int golabMath = Math.max(curMax,Math.max(withBoth,Math.max(left.max,right.max)));
//        return new Result(curMax,golabMath);
//
//    }
    private static int helper(TreeNode root){
        if(root==null)return 0;
        int max1 = 0;
        int max2 = 0;
        for(TreeNode elem:root.childern){
            int result = helper(elem);
            if(max1 < result){
                int temp =max1;
                max1 = result;
                if(temp>max2){
                    max2 = temp;
                }
            }
            else if(max2<result){
                max2 = result;
            }

        }
        globelMax = Math.max(globelMax,max2+max1+root.val);
        return Math.max(max1+root.val,max2+root.val);
    }
    public static void main(String[] args) {
//        TreeNode n = new TreeNode();
//        n.val = 4;
//        TreeNode t2 = new TreeNode();
//        t2.val = -10;
//        t2.left = n;
//        TreeNode t3 = new TreeNode();
//        t3.val = 7;
//        t3.left = t2;
//        TreeNode t4 = new TreeNode();
//        t4.val = 5;
//        t4.left = t3;
//        TreeNode t5 = new TreeNode();
//        t5.val=15;
//        t4.right = t5;
//        System.out.println(maxTreePath(t4));
    }
}
